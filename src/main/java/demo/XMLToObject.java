package demo;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



public class XMLToObject {

	public static void main(String[] args) throws IOException, JAXBException {
		try(InputStream in = XMLToObject.class.getResourceAsStream("/fahrzeuge2.xml")) {
			
			JAXBContext jaxbContext = JAXBContext.newInstance("demo");
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Fahrzeuge f=(Fahrzeuge) jaxbUnmarshaller.unmarshal(in);
			
			
			List<Fahrzeug> fahrzeuge=f.getFahrzeug();
			for(Fahrzeug ans:fahrzeuge) {
				System.out.println(ans.getModel());
			}
			fahrzeuge.removeIf(fz->fz.getFahrzeugart().equalsIgnoreCase("lkw"));
			jaxbContext.createMarshaller().marshal(f, new File("fahrzeuge3.xml"));
	        
		}
	} 
}


//TODO JaxB Binding File, Java Code erzeugen einstellen;
//TODO Andersrum, object to xml