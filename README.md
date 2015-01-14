# Microservice-Quickstart

Dieses Projekt umfasst einen einzelnen Microservice auf Basis der Techologien Spring Boot, 
Spring MVC, Spring Data MongoDB, AngularJS, Bootstrap und MongoDB.

Weitere Informationen über den microservice-quickstart gibt es im adesso Blog: 

TODO Link

# Installation & Start

Zur Ausführung des Microservice ist dieser von GitHub zu laden.
Java sollte mindestens in Version 1.7 und Maven in Version 3.0.5 installiert sein. 
Dazu muss eine MongoDB, die unter dem Standard Port 27017 läuft, eingerichtet sein.
Unterstützung bei der Installation der einzelnen Technologien ist unter diesen Links zu finden:

Java    - Https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

Maven   - Http://maven.apache.org/download.cgi

MongoDB - Http://docs.mongodb.org/manual/installation/

Für die Anwendung selber muss Port 8080 frei gehalten werden.
Ist das Projekt von GitHub geladen kann dieses mit Maven gebaut werden. 
Das dabei entstehende JAR im "target" Verzeichnis umfasst dann den gesamten Microservice. 
Dieser kann über die CLI mittels 

```java -jar microservice-quickstart-1.0.jar```

gestartet werden. Der Microservice ist dann unter 

Http://localhost:8080/start.html

erreichbar. Dies ist eine Startseite, welche auf drei verschiedene Testseiten verweist,
auf denen der Microservice über ein iframe-Element eingebunden ist.
