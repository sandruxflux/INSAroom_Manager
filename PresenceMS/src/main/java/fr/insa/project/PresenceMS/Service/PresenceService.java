package fr.insa.project.PresenceMS.Service;

import org.springframework.stereotype.Service;

import fr.insa.project.PresenceMS.model.PresenceState;

@Service

public class PresenceService {
	
	private PresenceState state = new PresenceState(false);
	
	public PresenceState getPresence() {
		return state;
	}

}