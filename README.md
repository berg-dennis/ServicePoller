# PollingService

Stack used:
Java 11
Spring Boot 2.5.5
Angular 11
Tomcat
H2 database


Reasoning behind H2 database:
Picked this database because of ease of use and setup speed. 
This db is not a alternative for more robust databases like mySQL etc. It is just picked in this project to limit setup time.
IMPORTANT NOTE: One requirement for this project is that the program keeps the state on shutdown. 
For this to be possible H2 will write to a file in this case which will be located (spring-boot-h2-db) at file:~/spring-boot-h2-db (Windows C:\users\user).

 
How to run this project:

1. git clone https://github.com/BergsterCode/ServicePoller.git
 
2. cd ./ServicePoller 
 
3. mvn clean package 
 
4. cd ./backend/target 
 
5. java -jar backend-0.1-SNAPSHOT.jar 

I have included a already packaged JAR file with this repo in case Maven is not installed.
IF you want to use the jar file look at the instructions above from step 4.

Project has fully functioning CRUD capabilities via REST. Unfortunatly i had no time to complete CRUD operations
from frontend. Adding a service works from frontend ui. 

Endpoints:
GET localhost:8080/api/services 
POST localhost:8080/api/services/add
PUT localhost:8080/api/services/update
DELETE localhost:8080/services/delete/{id}

body:
{
    "serviceName": "",
    "serviceUrl": ""
}

Services can only be added with a protocol.

---------------------------------------------------------------------------------------------------------
