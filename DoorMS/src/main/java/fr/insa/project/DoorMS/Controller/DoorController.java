package fr.insa.project.DoorMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.project.DoorMS.Service.DoorService;
import fr.insa.project.DoorMS.model.DoorState;

@RestController
@RequestMapping("/door")

public class DoorController {
	
	@Autowired
	DoorService doorService;
	
	@GetMapping("/status")
	public DoorState getStatus() {
		return doorService.getDoorState();
	}
	
	@PostMapping("/open")
	public DoorState openDoor() {
		doorService.openDoor();
		return doorService.getDoorState();
	}
	
	@PostMapping("/close")
	public DoorState closeDoor() {
		doorService.closeDoor();
		return doorService.getDoorState();
	}

}
