package fr.insa.project.OrchestratorMS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.project.OrchestratorMS.Service.OrchestratorService;
import fr.insa.project.OrchestratorMS.model.AlarmState;
import fr.insa.project.OrchestratorMS.model.Room;
import fr.insa.project.OrchestratorMS.model.ServiceUrl;

@RestController
@RequestMapping("/orchestrator")

public class OrchestratorController {

    private final OrchestratorService orchestratorService;

    public OrchestratorController(OrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }
    
    @GetMapping("/room/{name}") 
    
    public Room getRoom(@PathVariable String name) { 
    	return orchestratorService.getRoomByName(name); } 
    
    @GetMapping("/serviceurl/{name}") 
    
    public ServiceUrl getServiceUrl(@PathVariable String name) { 
    	return orchestratorService.getServiceByName(name); } 

    // Active le mode nuit : ferme portes/fenêtres et éteint lumière
     @PostMapping("/night/{name}")
    public String nightMode(@PathVariable String name) {
        orchestratorService.nightMode(name);
        return "Night mode activated!";
    }

    // Active le mode matin : ouvre portes/fenêtres et allume lumière
    @PostMapping("/morning/{name}")
    public String morningMode(@PathVariable String name) {
        orchestratorService.morningMode(name);
        return "Morning mode activated!";
    }
    
    @PostMapping("/room/{name}/simPresence")
    public String simulatePresence(@PathVariable String name) {
        orchestratorService.simulatePresence(name);
        return "Presence Simulated!";
    }
     
    
    // Vérifie la présence et déclenche l’alarme si nécessaire
   /*@PostMapping("/checkPresence")
    public String checkPresence() {
        orchestratorService.checkPresence();
        return orchestratorService.getAlarmState().isActive() 
                ? "Presence detected! Alarm triggered." 
                : "No presence detected.";
    }

    // Retourne l’état actuel de l’alarme
    @GetMapping("/alarm")
    public AlarmState getAlarmState() {
        return orchestratorService.getAlarmState();
    }*/
}