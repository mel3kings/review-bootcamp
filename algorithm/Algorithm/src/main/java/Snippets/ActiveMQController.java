package snippets;

import static snippets.Constants.ACKNOWLEDGE_MODE;
import static snippets.Constants.DELIVERY_MODE;
import static snippets.Constants.ENDPOINT;
import static snippets.Constants.PASSWORD;
import static snippets.Constants.QUEUE;
import static snippets.Constants.USERNAME;

import java.util.stream.IntStream;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
public class ActiveMQController {


  public static void main(String[] args) throws JMSException {
    // Create a connection factory.
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ENDPOINT);

    // Specify the username and password.
    connectionFactory.setUserName(USERNAME);
    connectionFactory.setPassword(PASSWORD);

    // Create a pooled connection factory.
    PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
    pooledConnectionFactory.setConnectionFactory(connectionFactory);
    pooledConnectionFactory.setMaxConnections(10);

    // Create a JmsTemplate for the producer.
    JmsTemplate producerJmsTemplate = new JmsTemplate();
    producerJmsTemplate.setConnectionFactory(pooledConnectionFactory);
    producerJmsTemplate.setDefaultDestination(new ActiveMQQueue(QUEUE));
    producerJmsTemplate.setSessionAcknowledgeMode(ACKNOWLEDGE_MODE);
    producerJmsTemplate.setDeliveryMode(DELIVERY_MODE);

    // Create a message creator.
    MessageCreator messageCreator = new MessageCreator() {
      public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("Hello from Spring Amazon MQ!");
      }
    };

    // Send the message.
    IntStream.range(0, 10).forEach(i -> {
      producerJmsTemplate.send(messageCreator);
      System.out.println("Message sent." + i);
    });

    // Clean up the producer.
    // producer JmsTemplate will close underlying sessions and connections.

    // Create a JmsTemplate for the consumer.
    // Note: Consumers should not use PooledConnectionFactory.
    JmsTemplate consumerJmsTemplate = new JmsTemplate();
    consumerJmsTemplate.setConnectionFactory(connectionFactory);
    consumerJmsTemplate.setDefaultDestination(new ActiveMQQueue(QUEUE));
    consumerJmsTemplate.setSessionAcknowledgeMode(ACKNOWLEDGE_MODE);
    consumerJmsTemplate.setReceiveTimeout(1000);

    // Begin to wait for messages.
    try {
      while (true) {
        Message consumerMessage = consumerJmsTemplate.receive();
        // Receive the message when it arrives.
        TextMessage consumerTextMessage = (TextMessage) consumerMessage;
        System.out.println("Message received: " + consumerTextMessage.getText());

      }
    } finally {
      pooledConnectionFactory.stop();

    }
  }
}