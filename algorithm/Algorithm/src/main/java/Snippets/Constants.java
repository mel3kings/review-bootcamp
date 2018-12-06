package snippets;

import javax.jms.DeliveryMode;
import javax.jms.Session;

public class Constants {
  public static final int DELIVERY_MODE = DeliveryMode.NON_PERSISTENT;
  public static final int ACKNOWLEDGE_MODE = Session.AUTO_ACKNOWLEDGE;
  // The Endpoint, Username, Password, and Queue should be externalized and
  // configured through environment variables or dependency injection.
  public static final String ENDPOINT = "ssl://b-aee88514-1e0c-4572-bdd4-f0d67e119b88-1.mq.ap-southeast-2.amazonaws.com:61617";
  public static final String USERNAME = "guest";
  public static final String PASSWORD = "testing_guest";
  public static final String QUEUE = "billing";

  public static final String PRODUCER_TOPIC = "VirtualTopic.MyTopic";
  public static final String CONSUMER1_TOPIC = "Consumer.Consumer1." + PRODUCER_TOPIC;

}
