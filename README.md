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


Basic requirements (If these aren’t met the assignment will not pass):
● A user need to be able to add a new service with URL and a name 
● Added services have to be kept when the server is restarted  
● Display the name, url, creation time and status for each service 
● Provide a README in english with instructions on how to run the 
application
Extra requirements (No prioritisation on these, pick the ones that you find
interesting):
● We want full create/update/delete functionality for services
● The results from the poller are automatically shown to the user (no
need to reload the page to see results)
● We want to have informative and nice looking animations on
add/remove services 
● The service properly handles concurrent writes
● Protect the poller from misbehaving services (for example answering
really slowly)
● URL Validation ("sdgf" is probably not a valid service)
● Multi user support. Users should not see the services added by
another user
