package snippets;

import com.jcraft.jsch.ChannelSftp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ParallelIntegrationTest{

  //@Test
  public void uploadFile() throws Exception {
    SftpLoader sftpLoader = new SftpLoader("127.0.0.1", 22, "foo", "pass", null);
    sftpLoader.transferDirToRemote("/Users/melchor.tatlonghari/Desktop/upload", "upload");
    ChannelSftp sftp = sftpLoader.channel;
    com.jcraft.jsch.Session sesh = sftp.getSession();
  }
}