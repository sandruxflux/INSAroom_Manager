package fr.insa.project.PresenceMS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.project.PresenceMS.Service.PresenceService;
import fr.insa.project.PresenceMS.model.PresenceState;

@RestController
@RequestMapping("/presence")

public class PresenceController {

    private final PresenceService presenceService;

    public PresenceController(PresenceService presenceService) {
        this.presenceService = presenceService;
    }

    @GetMapping
    public PresenceState getPresence() {
        return presenceService.getPresence();
    }
}