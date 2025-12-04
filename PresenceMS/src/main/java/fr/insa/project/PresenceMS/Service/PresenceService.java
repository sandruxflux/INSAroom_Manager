package fr.insa.project.PresenceMS.Service;

import org.springframework.stereotype.Service;

import fr.insa.project.PresenceMS.model.PresenceState;

@Service

public class PresenceService {

    private final PresenceState presence = new PresenceState();

    public PresenceState getPresenceState() {
        return presence;
    }

    public void setDetected(boolean detected) {
        presence.setDetected(detected);
    }
  
}