package fr.insa.project.OrchestratorMS.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.insa.project.OrchestratorMS.model.AlarmState;
import fr.insa.project.OrchestratorMS.model.Room;
import fr.insa.project.OrchestratorMS.model.RoomState;
import fr.insa.project.OrchestratorMS.model.ServiceUrl;
import fr.insa.project.OrchestratorMS.repository.RoomRepository;
import fr.insa.project.OrchestratorMS.repository.RoomStateRepository;
import fr.insa.project.OrchestratorMS.repository.ServiceUrlRepository;
import jakarta.annotation.PostConstruct;

@Service

public class OrchestratorService {
	
	private final RestTemplate restTemplate;
	private final RoomRepository roomRepository;
	private final RoomStateRepository roomStateRepository;
	private final ServiceUrlRepository serviceUrlRepository;
	
	
	public OrchestratorService(RestTemplate restTemplate,
			RoomRepository roomRepository,
			RoomStateRepository roomStateRepository, 
			ServiceUrlRepository serviceUrlRepository) 
	{
			this.restTemplate = restTemplate;
			this.roomRepository = roomRepository;
			this.roomStateRepository = roomStateRepository;
			this.serviceUrlRepository = serviceUrlRepository;
	}
	
	 public Room getRoomByName(String name) { 
		 return roomRepository.findByName(name) 
			.orElseThrow(() -> new RuntimeException("Room not found")); 
		 } 
	 public ServiceUrl getServiceByName(String name) { 
		 return serviceUrlRepository.findByServiceName(name) 
			.orElseThrow(() -> new RuntimeException("Service Url not found")); 
		 } 
	
	 public void nightMode(String roomName) {
		 Room room = roomRepository.findByName(roomName)
		 .orElseThrow(() -> new RuntimeException("Room not found: " + roomName));

		 // Pour chaque service dans la table
		 sendCommand(room, "door_service", "close");
		 sendCommand(room, "window_service", "close");
		 sendCommand(room, "light_service", "off");
		 sendCommand(room, "presence_service", "status");
		 }
	 
	 public void morningMode(String roomName) {
		 Room room = roomRepository.findByName(roomName)
		 .orElseThrow(() -> new RuntimeException("Room not found: " + roomName));

		 // Pour chaque service dans la table
		 sendCommand(room, "door_service", "open");
		 sendCommand(room, "window_service", "open");
		 sendCommand(room, "light_service", "on");
		 }
	 

		 private void sendCommand(Room room, String serviceName, String action) {
		 ServiceUrl service = serviceUrlRepository.findByServiceName(serviceName)
		 .orElseThrow(() -> new RuntimeException("Service not found: " + serviceName));

		 String result = null;

		 // On ne fait pas de POST pour check presence
		 if (!serviceName.equals("presence_service")) {
		 result = restTemplate.postForObject(service.getserviceUrl() + "/" + action, null, String.class);
		 } else {
		 PresenceResponse response = restTemplate.getForObject(service.getserviceUrl() + "/status", PresenceResponse.class);
		 if (response != null && response.isDetected()) {
		 result = "Presence detected! Alarm activated";
		 } else {
		 result = "No presence detected";
		 }
		 }

		 // Log automatique
		 RoomState log = new RoomState();
		 log.setRoomName(room.getName());
		 log.setServiceName(serviceName);
		 log.setState(result);
		 roomStateRepository.save(log);

		 System.out.println("Action on " + serviceName + ": " + result);
		 }

		 static class PresenceResponse {
		 private boolean detected;
		 public boolean isDetected() { return detected; }
		 public void setDetected(boolean detected) { this.detected = detected; }
		 }
		  
		 
		 public void nightModeForAllRooms() {
			 roomRepository.findAll()
			 .forEach(room-> nightMode(room.getName()));
		 }
		 
		 public void morningModeForAllRooms() {
			 roomRepository.findAll()
			 .forEach(room-> morningMode(room.getName()));
		 }
		 
		 public void simulatePresence(String roomName) {
			 ServiceUrl service = serviceUrlRepository.findByServiceName("presence_service")
					 .orElseThrow(() -> new RuntimeException("Service not found: " + "presence_service"));

			 restTemplate.postForObject(service.getserviceUrl() + "/" + "detect", null, String.class);
		 }
	
	

	

}