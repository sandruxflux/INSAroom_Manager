package fr.insa.project.DoorMS.Service;

import org.springframework.stereotype.Service;

import fr.insa.project.DoorMS.model.DoorState;

@Service

public class DoorService {
	
	private DoorState door = new DoorState();
	
	public DoorState getDoorState() {
		return door;
		}
	
	public void openDoor( ) {
		door.setClosed(false);
		}
	
	public void closeDoor( ) {
		door.setClosed(true);
		}

}
