# RestaurantAppAPI

Enhanced the restaurant app project by implementing backend endpoints with Spring Web, Maven, JUnit, Mockito, Lombok,
Liquibase, MapStruct and MariaDB.

### Setting up the Database

Ensure you have database ```raa``` created in your MariaDB client. If it doesn't exist, you can create it by running 
the following commands

```DROP DATABASE IF EXISTS raa;```

```CREATE DATABASE raa;```

### Running the Application

To run the application, use one of the following commands: 
- On Windows: ```./mvnw.cmd spring-boot:run``` 
- On Linux```./mvnw spring-boot:run```

Alternatively, you can install Maven on your Machine and run the project that way.

After successfully starting the application open your web browser and go to ```http://locahost:8080```  to access the app. 

### Additional Information

- The default TCP/IP port for MariaDB is ```3306``` (This port is used for the database connection)
- The default username is ```root```, and the default password is also set to ```root```

You can change this data in ```application.properties``` file

Ensure you have ```Java``` and ```MariaDB``` installed on your machine as it is required to run the application.
