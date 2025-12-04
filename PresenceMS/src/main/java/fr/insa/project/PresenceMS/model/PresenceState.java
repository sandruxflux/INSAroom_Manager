package fr.insa.project.PresenceMS.model;

public class PresenceState {

	private boolean detected;

    public PresenceState() {
        this.detected = false; // par défaut pas de présence
    }

    public boolean isDetected() {
        return detected;
    }

    public void setDetected(boolean detected) {
        this.detected = detected;
    }
}
