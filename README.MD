Bank

Spring boot application. It has data about clients, their addresses, credit cards and cards' histories. Web interface allows to add new data and change it (deleting is only as stub). 

How-to:
Requirement: java 8, maven, internet connection (for angularJS).
"mvn package" creates executable .jar file. Runs from the /target dir: java -jar bank-1.0-SNAPSHOT.jar (by default: http://localhost:8080/).
Database (h2) has placed in user's folder (place can be changed in src/main/resources/application.properties file).
WARNING! After first start it's recommended to change "spring.jpa.hibernate.ddl-auto" field from "create" to "update" in order not to lose data which was added in DB (it can be changed in application.properties file).