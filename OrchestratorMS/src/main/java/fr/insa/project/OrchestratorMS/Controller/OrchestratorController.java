package fr.insa.project.OrchestratorMS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.project.OrchestratorMS.Service.OrchestratorService;
import fr.insa.project.OrchestratorMS.model.AlarmState;

@RestController
@RequestMapping("/orchestrator")

public class OrchestratorController {

    private final OrchestratorService orchestratorService;

    public OrchestratorController(OrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    // Active le mode nuit : ferme portes/fenêtres et éteint lumière
    @PostMapping("/night")
    public String nightMode() {
        orchestratorService.nightMode();
        return "Night mode activated!";
    }

    // Active le mode matin : ouvre portes/fenêtres et allume lumière
    @PostMapping("/morning")
    public String morningMode() {
        orchestratorService.morningMode();
        return "Morning mode activated!";
    }
    
    // Vérifie la présence et déclenche l’alarme si nécessaire
    @PostMapping("/checkPresence")
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
    }
}