package fr.insa.project.OrchestratorMS.model;

public class AlarmState {

    private boolean active;

    public AlarmState() {
        this.active = false; // pas d'alarme au départ
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}