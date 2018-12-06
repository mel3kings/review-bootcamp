package snippets;


import com.jcraft.jsch.ChannelSftp.LsEntry;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.dsl.support.GenericHandler;
import org.springframework.integration.endpoint.MethodInvokingMessageSource;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.Message;

@Slf4j
@SpringBootApplication
public class ParallelIntegrationApplicationSftp {

  private static final long EVERY_MINUTE = 1000L * 60L;
  public static final String HOST = "127.0.0.1";
  public static final String USER = "foo", PASSWORD = "pass";
  public static final String UPLOAD = "/upload", LOCAL_DIRECTORY = "/Users/melchor.tatlonghari/Desktop/download";
  @Bean
  public IntegrationFlow integrationFlow() {
    DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
    factory.setHost(HOST);
    factory.setPort(22);
    factory.setUser(USER);
    factory.setPassword(PASSWORD);
    SessionFactory<LsEntry> lsFactory = new CachingSessionFactory<LsEntry>(factory);
    factory.setAllowUnknownKeys(true);
    return IntegrationFlows
        .from(s -> s.sftp(lsFactory)
                .preserveTimestamp(true)
                .remoteDirectory(UPLOAD)
                .localDirectory(new File(LOCAL_DIRECTORY))
                .autoCreateLocalDirectory(true),
            e -> e.id("sftpInboundAdapter")
                .autoStartup(true)
                .poller(Pollers
                    .fixedRate(EVERY_MINUTE)
                    .maxMessagesPerPoll(1)
                )
        )
        .channel(MessageChannels.executor(Executors.newCachedThreadPool()))
        .handle((GenericHandler<File>) (payload, headers) -> {
          log.info("\t delaying message:" + payload + " on thread " + Thread.currentThread().getName());
          try {
            Thread.sleep(30000);
          } catch (InterruptedException e) {
            log.error(e.getMessage());
          }
          return payload;
        }).wireTap(sf -> sf.handle(this::logMessage))
        .handle(this::logMessage).get();
  }

  public static void main(String[] args) {
    SpringApplication.run(ParallelIntegrationApplicationSftp.class, args);
  }

  private Message logMessage(Message message) {
    log.info("logMessage: " + message.getPayload() + " on thread " + Thread.currentThread().getName());
    return message;
  }

  @Bean
  public MessageSource<?> integerMessageSource() {
    MethodInvokingMessageSource source = new MethodInvokingMessageSource();
    source.setObject(new AtomicInteger(1));
    source.setMethodName("getAndIncrement");
    return source;
  }
}