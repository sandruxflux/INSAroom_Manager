package fr.insa.project.PresenceMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.project.PresenceMS.Service.PresenceService;
import fr.insa.project.PresenceMS.model.PresenceState;

@RestController
@RequestMapping("/presence")

public class PresenceController {

	@Autowired
    private PresenceService presenceService;

    @GetMapping("/status")
    public PresenceState getStatus() {
        return presenceService.getPresenceState();
    }

    @PostMapping("/detect")
    public PresenceState detectPresence() {
        presenceService.setDetected(true);
        return presenceService.getPresenceState();
    }

    @PostMapping("/clear")
    public PresenceState clearPresence() {
        presenceService.setDetected(false);
        return presenceService.getPresenceState();
    }
}
