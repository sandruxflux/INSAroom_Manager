INSA Room Manager 🏢💡
"Smart Automation System based on Microservices Architecture"

📝 Project Description
This project aims to automate room management at INSA Toulouse. The system ensures energy efficiency and security by automatically controlling actuators (doors, windows, lights) based on working hours and human presence.

Key Logic:
Energy Saving: Automatically closes doors, windows, and turns off lights outside of working hours when no presence is detected.

Security: If presence is detected after 10:00 PM (22h), the system triggers an emergency alarm.

🏗 Architecture Overview
The project follows a Microservices Architecture powered by Spring Boot and Spring Cloud.

Components:
Eureka Server (EurekaServerMS): The Service Registry that allows microservices to find each other dynamically.

Orchestrator (OrchestratorMS): The "brain" of the system. It contains the business logic, communicates with Eureka to find services, and logs every action into a MySQL database.

Actuator Microservices (LightMS, DoorMS, WindowsMS): Each service manages a specific hardware component. They are built with a standard Controller-Service-Model pattern.

Sensor Microservice (PresenceMS): Monitors activity within the rooms to inform the Orchestrator's decisions.

🛠 Tech Stack
Framework: Spring Boot 3.x

Discovery Server: Netflix Eureka

Database: MySQL (Persistence for room states and service URLs)

Communication: REST API with RestTemplate (@LoadBalanced)

Tools: Maven, Postman, Git/GitHub

🚀 Getting Started
1. Prerequisites
Java 21

MySQL Server

Maven



👥 Contributors
Imane EL GHAIT 

Sandra BEJAOUI 



