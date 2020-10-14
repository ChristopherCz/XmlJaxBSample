# JAXB 
### Beschreibung JAXB
JaxB steht für **Java™ Architecture for XML Binding (JAXB)**  
Es stellt eine API und verschiedene tools bereit, die das mappen von XML und Java Objekten ermöglicht.  

Folgende Operationen sind möglich:  
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
- JAXB kann mit StAX kombiniert werden, um kein komplettes XML einlesen zu müssen.
- Es ist möglich, Java Code aus einer Schema Datei zu generieren
- Aus Java Code können Schemata generiert werden

### Ausführung
- Um die folgenden Codebeispiele zu verstehen ist es Empfohlen, das Beispiel aus dem GitRepository herunterzuladen und es selbst nachzuvollziehen.
- Grundsätzlich muss Ein JAXB Context Object erstellt werden. 
- Marshaller/Unmarshaller Objekte erzeugen
- Marshal/Unmarshal Methoden aufrufen

##### Erzeugen des Java-Codes aus dem Schema in Eclipse
- Maven Projekt
- JAXB Dependencys in pom.xml eintragen
~~~
<dependencies>
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.3.0.1</version>
		</dependency>
		<dependency>
			<groupId>javax.activation</groupId>
			<artifactId>activation</artifactId>
			<version>1.1.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-core</artifactId>
			<version>2.3.0.1</version>
		</dependency>
	</dependencies>
~~~
- JAXB2 Maven Plugin in pom.xml eintragen
~~~
<build>
		<plugins>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>jaxb2-maven-plugin</artifactId>
				<version>2.5.0</version>
				<executions>
					<execution>
						<id>xjc-schema1</id>
						<goals>
							<goal>xjc</goal>
						</goals>
						<configuration>
							<target>2.2</target>
							<schemaFiles>fahrzeuge.xsd</schemaFiles>
							<packageName>demo</packageName>
							<clearOutputDir>false</clearOutputDir>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
~~~
- In Eclipse --> Run As --> Maven install oder Generate Resources
- Alt + F5 zum Eclipse Aktualisieren 
- Code wurde generiert!

###### Elemente und Attribute werden über Annotationen festgelegt:
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

## Nützliche Links

- [JAXB-RI project home page](https://javaee.github.io/jaxb-v2/)
- [Baeldung Guide](https://www.baeldung.com/jaxb)
- [Javatpoint Tutorial](https://www.javatpoint.com/jaxb-tutorial)