import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Marshal {

  public static void main(String[] args) throws JAXBException, SOAPException, ParserConfigurationException, IOException {

    //CREATE PERSON
    Person  person = new Person();
            person.id   = 1;
            person.name = "John";
            person.age  = 20;

    //MARSHAL PERSON
    //Marshaller  marshaller = JAXBContext.newInstance(Person.class).createMarshaller();
   //             marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
   //             marshaller.marshal(person, new File("person.xml"));

    //MARSHAL PERSON
    Document    document   = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Marshaller  marshaller = JAXBContext.newInstance(Person.class).createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(person, document);

    //ADD SOAP ENVELOPE
    SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
                soapMessage.getSOAPBody().addDocument(document);

    //DISPLAY RESULT
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                          soapMessage.writeTo(outputStream);
    String output = new String(outputStream.toByteArray());

    System.out.println(output);

  }

}
