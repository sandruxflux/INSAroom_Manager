package fr.insa.project.OrchestratorMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="insa_rooms")

public class Room {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name="name")
	
	private String name;
	
	
	private int doors;
	
	private int windows;
	
	private int lights;
	
	public Room() {}
	
	public Room(Long id, String name , int doors, int windows, int lights) {
		this.id = id;
		this.name = name ;
		this.doors = doors;
		this.windows = windows;
		this.lights = lights;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name; 
	}
	public int getDoors() {
		return doors; 
	}
	public int getWindows() {
		return windows; 
	}
	public int getLights() {
		return lights; 
	}
	
	public void SetId(Long id) {
		this.id = id;
	}
	public void SetName(String name) {
		this.name = name;
	}
	public void SetDoors(int doorCount) {
		this.doors = doorCount;
	}
	public void SetWindows(int windowCount) {
		this.windows = windowCount;
	}
	public void SetLights(int lightCount) {
		this.lights= lightCount;
	}

}
