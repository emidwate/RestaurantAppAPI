# RestaurantApp 

Simple restaurant project using Spring Web, Maven, JUnit, Mockito and MariaDB.

### Setting up the Database

Import the ```schema.sql``` file located in the ```resources``` directory into your MariaDB client to set up
the database. 

Once the database is ready navigate to the RestaurantAppApiApplication class in you project.

### Running the Application

To run the application, use one of the following commands: 
- On Windows: ```./mvnw spring-boot:run``` 
- On Linux```./mvnw spring-boot:run```

Alternatively, you can install Maven on your Machine and run the project that way.

After successfully starting the application open your web browser and go to http://locahost:8080  to access the app. 

### Additional Information

- The default TCP/IP port for MariaDB is ```3306```. 
- The default username is ```root```, and the default password is also set to ```root```

You can change this data in ```application.properties``` file

Ensure you have ```Java``` installed on your machine as it is required to run the application.
