package fr.insa.project.OrchestratorMS.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room_state")
public class RoomState {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="room_name")
	private String roomName;
	@Column(name="service_name")
	private String serviceName;
	
	private String state; // "open", "closed", "on", "off", "active", "inactive", etc.

	private LocalDateTime timestamp;

	
	public RoomState() {
	this.timestamp = LocalDateTime.now();
	}

	// Getters et Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getRoomName() { return roomName; }
	public void setRoomName(String roomName) { this.roomName = roomName; }

	public String getServiceName() { return serviceName; }
	public void setServiceName(String serviceName) { this.serviceName = serviceName; }

	public String getState() { return state; }
	public void setState(String state) { this.state = state; }

	public LocalDateTime getTimestamp() { return timestamp; }
	public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }


}
