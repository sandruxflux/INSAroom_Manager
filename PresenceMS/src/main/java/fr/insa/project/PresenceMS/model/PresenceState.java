package fr.insa.project.PresenceMS.model;

public class PresenceState {

	private boolean presence;
	
	public PresenceState (boolean presence) {
		 this.presence = presence;
	 }
	public boolean isPresent() {
		return presence;
	}
}
