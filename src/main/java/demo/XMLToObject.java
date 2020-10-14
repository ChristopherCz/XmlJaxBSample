package demo;
import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



public class XMLToObject {

	public static void main(String[] args) {
		try {
			File test = new File("C:/Users/Benutzer 1/XMLVerarbeitungSchulung/xml-sample/fahrzeuge2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance("demo");
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Fahrzeuge f=(Fahrzeuge) jaxbUnmarshaller.unmarshal(test);
			
			
			List<Fahrzeug> fahrzeuge=f.getFahrzeug();
			for(Fahrzeug ans:fahrzeuge) {
				System.out.println(ans.getFahrzeugart());
			}
			fahrzeuge.removeIf(fz->fz.getFahrzeugart().equalsIgnoreCase("lkw"));
			jaxbContext.createMarshaller().marshal(f, new File("fahrzeuge3.xml"));
	        
		}catch(JAXBException e) {e.printStackTrace();}
	} 
}


//TODO JaxB Binding File, Java Code erzeugen einstellen;
//TODO Andersrum, object to xml