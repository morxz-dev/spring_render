# springboot_render: 
It's an Api which can be deploy on render, just upadte the parameters as needed
Eco Trace API
This API provides endpoints for managing users, trips, user statistics, and feedback for the Eco Trace application. It includes functionalities to track user emissions based on their transportation modes, calculate various statistics, and collect feedback.


Table of Contents:
-----------------
Technologies
Endpoints
User Endpoints
Trip Endpoints
User Stats Endpoints
Feedback Endpoints
Emissions Calculation
-----------------


Technologies
------------
Java 17
Spring Boot
In the file "properties_bd.txt" you can find the configuration for mysql, H2 and postgresql( with render ).
You can update the file "application.propertis" based on the file "properties_bd.txt" to match your needs ( Do not forget to update the configuration: password, username ...)
Docker (for deployment)
Maven (for dependency management)
-------------

Make sure to include the Dockerfile and configure Render for the deployment.

Endpoints
-------------

User Endpoints
-------------
Method	Endpoint	Description
GET	/api/users	Get all users
GET	/api/users/{id}	Get a user by ID
POST	/api/users	Create a new user
PUT	/api/users/{id}	Update a user by ID
DELETE	/api/users/{id}	Delete a user by ID
--------------
Trip Endpoints
--------------
Method	Endpoint	Description
POST	/api/trips	Create a new trip
GET	/api/trips/user/{userId}	Get all trips for a specific user
GET	/api/trips/user/{userId}/trip/{id}	Get a specific trip of a specific user
GET	/api/trips/{id}	Get trip by ID
GET	/api/trips	Get all trips
PUT	/api/trips/{id}	Update a trip by ID
DELETE	/api/trips/{id}	Delete a trip by ID
DELETE	/api/trips/user/{userId}	Delete all trips for a specific user
--------------------
User Stats Endpoints
--------------------
Method	Endpoint	Description
GET	/api/user-stats/weekly-emissions/{userId}	Get weekly emissions for a user
GET	/api/user-stats/day/{userId}	Get emissions for the current day
GET	/api/user-stats/previous-day/{userId}	Get emissions for the previous day
GET	/api/user-stats/week-max/{userId}	Get the max emissions for the current week
GET	/api/user-stats/week-min/{userId}	Get the min emissions for the current week
GET	/api/user-stats/week-average/{userId}	Get the average emissions for the current week
GET	/api/user-stats/total-since-creation/{userId}	Get total emissions since account creation
GET	/api/user-stats/average-emission-for-all-users	Get average emissions for all users
GET	/api/user-stats/max-since-creation/{userId}	Get max emissions since account creation
GET	/api/user-stats/min-since-creation/{userId}	Get min emissions since account creation
------------------
Feedback Endpoints
------------------
Method	Endpoint	Description
POST	/api/feedback	Submit feedback
GET	/api/feedback	Get all feedback

---------------------
Emissions Calculation
---------------------
Emission factors are calculated based on vehicle type, size, and fuel type. These are stored in the EmissionFactors class. Examples include:

VOITURE-ESSENCE-MOYEN: 2.50
MOTO-ELECTRIQUE-MOYEN: 0.0
BUS-DIESEL-GRAND: 4.00

Emission factors are managed in the "EmissionFactors.java" file with predefined values for various types of vehicles.
