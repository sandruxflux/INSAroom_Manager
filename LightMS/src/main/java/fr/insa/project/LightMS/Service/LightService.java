package fr.insa.project.LightMS.Service;
import org.springframework.stereotype.Service;

import fr.insa.project.LightMS.model.LightState;

@Service

public class LightService {
	
	private LightState light = new LightState();
	
	public LightState getLightState() {
		
		return light;
	}
	
	public void turnOn( ) {
		light.setOn(true);
		}
	
	public void turnOFF( ) {
		light.setOn(false);
		}



}
