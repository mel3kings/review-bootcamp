package snippets;


import static snippets.Constants.ACKNOWLEDGE_MODE;
import static snippets.Constants.CONSUMER1_TOPIC;
import static snippets.Constants.DELIVERY_MODE;
import static snippets.Constants.ENDPOINT;
import static snippets.Constants.PASSWORD;
import static snippets.Constants.PRODUCER_TOPIC;
import static snippets.Constants.USERNAME;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ActiveMQRouterController {

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
    producerJmsTemplate.setDefaultDestination(new ActiveMQTopic(PRODUCER_TOPIC));
    producerJmsTemplate.setSessionAcknowledgeMode(ACKNOWLEDGE_MODE);
    producerJmsTemplate.setDeliveryMode(DELIVERY_MODE);

    // Create a message creator.
    MessageCreator messageCreator = new MessageCreator() {
      public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("ROUTER");
      }
    };

    // Send the message.
    producerJmsTemplate.send(messageCreator);
    System.out.println("Message sent.");

    // Clean up the producer.
    // producer JmsTemplate will close underlying sessions and connections.

    // Create a JmsTemplate for the consumer.
    // Note: Consumers should not use PooledConnectionFactory.

    JmsTemplate consumerJmsTemplate = new JmsTemplate();
    consumerJmsTemplate.setConnectionFactory(connectionFactory);
    consumerJmsTemplate.setDefaultDestination(new ActiveMQQueue(CONSUMER1_TOPIC));
    consumerJmsTemplate.setSessionAcknowledgeMode(ACKNOWLEDGE_MODE);
    consumerJmsTemplate.setReceiveTimeout(1000);

    // Begin to wait for messages.
    Message consumerMessage = consumerJmsTemplate.receive();

    // Receive the message when it arrives.
    TextMessage consumerTextMessage = (TextMessage) consumerMessage;
    System.out.println("Message received: " + consumerTextMessage.getText());

    // Clean up the consumer.
    // consumer JmsTemplate will close underlying sessions and connections.
    pooledConnectionFactory.stop();
  }
}

