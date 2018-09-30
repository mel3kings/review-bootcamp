package Snippets;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Slf4j
public class SoapGenerator {

  protected static final ObjectMapper XML_MAPPER = new XmlMapper()
      .enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
      .registerModule(new JavaTimeModule());

  private static final String SOAP_BODY_OPEN = "<soap:Body>";
  private static final String SOAP_BODY_CLOSE = "</soap:Body>";
  private static final String SOAP_ENVELOPE_OPEN = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
  private static final String SOAP_ENVELOPE_CLOSE = "</soap:Envelope>";

  public static String soapWrap(String xml) {
    return SOAP_ENVELOPE_OPEN + SOAP_BODY_OPEN + xml + SOAP_BODY_CLOSE + SOAP_ENVELOPE_CLOSE;
  }

  public static String soapUnwrap(String xml) {
    return StringUtils.substringBetween(xml, SOAP_BODY_OPEN, SOAP_BODY_CLOSE);
  }

  public static void main(String[] args) throws Exception{
    Person p = new Person();
    p.setName("Test");
    p.setAge(12);

    String xml = SoapGenerator.soapWrap(XML_MAPPER.writeValueAsString(p));
    log.info("Generated String");
    log.info(xml);
  }
}

