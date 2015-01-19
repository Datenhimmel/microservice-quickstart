# Microservice-Quickstart

Dieses Projekt umfasst einen einzelnen Microservice auf Basis der Technologien Spring Boot, 
Spring MVC, Spring Data MongoDB, AngularJS, Bootstrap und MongoDB.

Weitere Informationen über den microservice-quickstart gibt es im adesso Blog: 

TODO Link

# Installation & Start

Zur Ausführung des Microservice ist dieser von GitHub zu laden.
Java sollte mindestens in Version 1.7 und Maven in Version 3.0.5 installiert sein. 
Dazu muss eine MongoDB, die unter dem Standard Port 27017 läuft, eingerichtet sein.
Unterstützung bei der Installation der einzelnen Technologien ist unter diesen Links zu finden:

[Java](Https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html), 
[Maven](Http://maven.apache.org/download.cgi) und
[MongoDB](Http://docs.mongodb.org/manual/installation/).

Für die Anwendung selber muss Port 8080 frei gehalten werden.
Ist das Projekt von GitHub geladen kann dieses mit Maven gebaut werden.
Das `spring-boot-maven-plugin` sorgt dafür, dass im target-Verzeichnis ein "Fat" Jar erstellt wird. 
Dieses umfasst dann den gesamten Microservice und kann über die CLI mittels 

```java -jar microservice-quickstart-1.0.jar```

ausgeführt werden. Der Microservice ist nach dem Start unter 

[Http://localhost:8080/start.html](Http://localhost:8080/start.html)

erreichbar. Dies ist eine Startseite, welche auf drei verschiedene Testseiten verweist,
auf denen der Microservice über ein iframe-Element eingebunden ist.

# Lizenz

Dieses Projekt steht unter der MIT License. Mehr Informationen dazu in der LICENSE Datei.
