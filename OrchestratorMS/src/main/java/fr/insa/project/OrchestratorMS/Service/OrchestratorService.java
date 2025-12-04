package fr.insa.project.OrchestratorMS.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.insa.project.OrchestratorMS.model.AlarmState;

@Service

public class OrchestratorService {
	
	private final RestTemplate restTemplate;
	
    private final String doorUrl = "http://localhost:8081/door";
    private final String lightUrl = "http://localhost:8082/light";
    private final String windowUrl = "http://localhost:8083/window";
    private final String presenceUrl = "http://localhost:8084/presence";
	
    public OrchestratorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    private final AlarmState alarm = new AlarmState();
    
    public AlarmState getAlarmState() {
        return alarm;
    }
    
    
 // Mode nuit : fermer portes/fenêtres, éteindre lumière et vérifier présence
    
    public void nightMode() {
        restTemplate.postForObject(doorUrl + "/close", null, String.class);
        restTemplate.postForObject(windowUrl + "/close", null, String.class);
        restTemplate.postForObject(lightUrl + "/off", null, String.class);

        // Vérifie la présence et déclenche l’alarme si nécessaire
        checkPresence();

        // Renvoie l'état de la porte
        String doorStatus = restTemplate.getForObject(doorUrl + "/status", String.class);
        System.out.println("Door state: " + doorStatus);
        
        // Renvoie l'état de la fenêtre
        String windowStatus = restTemplate.getForObject(windowUrl + "/status", String.class);
        System.out.println("Window state: " + windowStatus);
        
        // Renvoie l'état de la lumière
        String lightStatus = restTemplate.getForObject(lightUrl + "/status", String.class);
        System.out.println("Light state: " + lightStatus);
        
        System.out.println("Alarm active: " + alarm.isActive());
        
        System.out.println("Orchestrator: Night mode activated");
    }

    // Mode matin : ouvrir portes/fenêtres, allumer lumière, désactiver alarme
    
    public void morningMode() {
        restTemplate.postForObject(doorUrl + "/open", null, String.class);
        restTemplate.postForObject(windowUrl + "/open", null, String.class);
        restTemplate.postForObject(lightUrl + "/on", null, String.class);

        alarm.setActive(false);
        
        
        //Possibilité de créer une fonction pour faire ça sans avoir à réécrire 2 fois la même chose
        
        // Renvoie l'état de la porte
        String doorStatus = restTemplate.getForObject(doorUrl + "/status", String.class);
        System.out.println("Door state: " + doorStatus);
        
        // Renvoie l'état de la fenêtre
        String windowStatus = restTemplate.getForObject(windowUrl + "/status", String.class);
        System.out.println("Window state: " + windowStatus);
        
        // Renvoie l'état de la lumière
        String lightStatus = restTemplate.getForObject(lightUrl + "/status", String.class);
        System.out.println("Light state: " + lightStatus);
        
        System.out.println("Alarm active: " + alarm.isActive());
        System.out.println("Orchestrator: Morning mode activated");
    }
    
    

    // Vérifie la présence via PresenceMS et déclenche l’alarme
    
    public void checkPresence() {
        PresenceResponse response = restTemplate.getForObject(presenceUrl + "/status", PresenceResponse.class);
        if (response != null && response.isDetected()) {
            System.out.println("⚠️ ALERTE ! Présence détectée !");
            alarm.setActive(true);
        } else {
            alarm.setActive(false);
        }
    }

    
    // Classe interne pour parser le JSON renvoyé par PresenceMS
    
    static class PresenceResponse {
        private boolean detected;

        public boolean isDetected() {
            return detected;
        }

        public void setDetected(boolean detected) {
            this.detected = detected;
        }
    }
}