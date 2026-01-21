# INSA Room Manager 🏢

# "Smart Automation System based on Microservices Architecture"

#  Project Description
This project aims to automate room management . The system ensures energy efficiency and security by automatically controlling actuators (doors, windows, lights) based on working hours and human presence.

# Key Logic 
Energy Saving: Automatically closes doors, windows, and turns off lights outside of working hours when no presence is detected.

Security: If presence is detected after 10:00 PM (22h), the system triggers an emergency alarm.

#  Architecture Overview
The project follows a Microservices Architecture powered by **Spring Boot** and **Spring Cloud**.

Components:
1) **Eureka Server (EurekaServer)**: The Service Registry that allows microservices to find each other dynamically.

2) **Orchestrator (OrchestratorMS)**: The "brain" of the system. It contains the business logic, communicates with Eureka to find services, and logs every action into a MySQL database.

3) **Actuator Microservices (LightMS, DoorMS, WindowsMS)**: Each service manages a specific hardware component. They are built with a standard Controller-Service-Model pattern.

4) **Sensor Microservice (PresenceMS)**: Monitors activity within the rooms to inform the Orchestrator's decisions.

#  Tech Stack
**Framework**: Spring Boot 3.x

**Discovery Server**: Netflix Eureka

**Database**: MySQL (MySQLWorkBench)

**Communication**: REST API with RestTemplate 

**Tools**: Maven, Postman, Git/GitHub

# 1. Orchestrator Logic (OrchestratorMS) 
The OrchestratorMS acts as the central intelligence of the system, managing the coordination between sensors and actuators without direct hardware control. It retrieves logical service names (for instance http://DOORMS) from a MySQL database rather than using hardcoded IP addresses.

# 2. Dynamic Decision Making

Step 1: It queries the PresenceMS to check for human activity in the room.

Step 2: If no presence is detected, it triggers commands to close doors, windows, and turn off lights via their respective microservices.

Step 3 : If presence is detected between 22:00 (10 PM) and 8 AM, the Orchestrator overrides standard procedures to trigger an **Alarm State** log instead of standard automation.

Every decision and resulting action is persisted in the RoomState MySQL table, providing a complete audit trail of the room's automation history.

For testing reasons, the nightMode for all rooms is launched every 20 seconds instead of at 10 pm in order to see the work done and the update of the RoomState for each room. The morning mode is set normally, at 8 AM. 

# 3. **Internal Structure** 
All our microservices (LightMS, DoorMS, WindowMS, PresenceMS) share the same architecture:

1) **Controller/**: Handles incoming REST requests (e.g., POST /open, GET /status ....).

2) **Service/**: Contains the business logic .

3) **Model/**: Defines the data structures and entities.

4) **Resources/**: Holds configuration files like **application.properties** where the Eureka registration name is defined for example.

# 4. **Eureka Discovery**
The Eureka Server enables dynamic discovery across the network by acting as a Service Registry for the entire microservices ecosystem.

1) **Automatic Registration**: As soon as any microservice starts up, it registers its current IP address and port with Eureka.

2) **Service Discovery**: The Orchestrator uses the @LoadBalanced annotation to resolve names like DOORMS into actual network locations. This means the code never needs to be updated if a service moves to a new machine or port.

3) **Real-time Monitoring**: It provides a central dashboard (Port 8761) that shows the "UP" status of every registered service, as seen in the system's administration view.

4) **Dynamic Finding**: When the Orchestrator wants to close a door, it asks the MySQL database for the name (DOORMS), then asks Eureka for the current location of that name.

# 5. **Testing**

In order to test the project properly, first launch the Eureka Server Application as a Java Application. 

Then following the same method, launch all of the microservices's applications : DoorMS, WindowMS, PresenceMS and LightMS.

Finally, launch OrchestratorMS's application. 

The order is important because if the Eureka server is not launched, the microservices cannot use it. And the orchestrator calls to the URLs of those microservices as well. 
The chain must be followed. 

You will then be able to see the nightMode activated. 

The presence state is always set to 0, in order to test the case where a presence is detected anywhere in the rooms, an endpoint was included : 
http://localhost:8086/orchestrator/room/{name}/simPresence : name corresponds to the room name, for instance you could use gei13 to test it. 

There are also endpoints to simulate both night mode and morning mode but for a specific room : 
http://localhost:8086/orchestrator/night/{name}
http://localhost:8086/orchestrator/morning/{name}

And an endpoint to show the characteristics of a room :                      
http://localhost:8086/orchestrator/room/{name}

In order to test these, you have to use either Postman or the curl command in the terminal as the first 3 links are POST procedures. Only the room's characteristics can be accessed in a web browser because of its GET function. 

# 👥 Contributors
**Imane EL GHAIT** 

**Sandra BEJAOUI** 



