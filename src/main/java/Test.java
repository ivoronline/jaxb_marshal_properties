import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Test {

  public static void main(String[] args) throws JAXBException {

    //CREATE PERSON
    Person  person = new Person();
            person.id   = 1;
            person.name = "John";
            person.age  = 20;

    //MARSHAL PERSON
    Marshaller  marshaller = JAXBContext.newInstance(Person.class).createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(person, new File("person.xml"));
  }

}
