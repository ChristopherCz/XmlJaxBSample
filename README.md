# JAXB 
### Beschreibung JAXB
JaxB steht f�r **Java� Architecture for XML Binding (JAXB)**  
Es stellt eine API und verschiedene tools bereit, die das mappen von XML und Java Objekten erm�glicht.  

Folgende Operationen sind m�glich:  
>
>-Unmarshal XML als Java Darstellung (Klassen, Objekte,...)
>-Manipulation der Daten mithilfe von Java
>-Java Dateien "Marshal" \--> Umwandlung in XML
>
Vorteile | Herausforderungen | 
-------- | -------- | 
Automatische Codeerzeugung    | Komplettes XML muss geladen werden   | 
geringe XML Kenntnisse ausreichend   |  | 
### Eigenheiten
- JAXB kann mit StAX kombiniert werden, um kein komplettes XML einlesen zu m�ssen.
- Es ist m�glich, Java Code aus einer Schema Datei zu generieren
- Aus Java Code k�nnen Schemata generiert werden

### Ausf�hrung
- Um die folgenden Codebeispiele zu verstehen ist es Empfohlen, das Beispiel aus dem GitRepository herunterzuladen und es selbst nachzuvollziehen.
- Grunds�tzlich muss Ein JAXB Context Object erstellt werden. 
- Marshaller/Unmarshaller Objekte erzeugen
- Marshal/Unmarshal Methoden aufrufen
###### Elemente und Attribute werden �ber Annotationen festgelegt:
- @XmlRootElement gibt das Wurzelelement an
- @XmlElement beschreibt ein Unterelement des Wurzelelementes
- @XmlAttribute beschreibt ein Attribut
##### Marshaling
Das Marshaling kann anhand des Codebeispiels Nachvollzogen werden 
~~~
fahrzeuge.removeIf(fz->fz.getFahrzeugart().equalsIgnoreCase("lkw"));
jaxbContext.createMarshaller().marshal(f, newFile("fahrzeuge3.xml"));
~~~
##### Unmarshaling
Das Unmarshaling kann anhand des Codebeispiels Nachvollzogen werden
~~~
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Fahrzeuge f=(Fahrzeuge) jaxbUnmarshaller.unmarshal(in);
~~~

### Licensing and Governance

JAXB is licensed under a dual license - CDDL 1.1 and GPL 2.0 with Class-path Exception. That means you can choose which one of the two suits your needs better and use it under those terms.

We use [GlassFish Governance Policy](https://javaee.github.io/jaxb-v2/CONTRIBUTING), which means we can only accept contributions under the terms of [OCA](http://oracle.com/technetwork/goto/oca).

## N�tzliche Links

- [JAXB-RI project home page](https://javaee.github.io/jaxb-v2/)
- [Baeldung Guide](https://www.baeldung.com/jaxb)
- [Javatpoint Tutorial](https://www.javatpoint.com/jaxb-tutorial)