package fr.insa.project.LightMS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.project.LightMS.Service.LightService;
import fr.insa.project.LightMS.model.LightState;



@RestController
@RequestMapping


public class LightController {
	
	LightService lightService = new LightService();
	
	@GetMapping("/status")
	public LightState getStatus() {
		return lightService.getLightState();
	}
	
	@PostMapping("/on")
	public LightState turnOn() {
		lightService.turnOn();
		return lightService.getLightState();
	}
	
	@PostMapping("/off")
	public LightState turnOFF() {
		lightService.turnOFF();
		return lightService.getLightState();
	}

}
