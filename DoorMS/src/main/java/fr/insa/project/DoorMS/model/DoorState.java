package fr.insa.project.DoorMS.model;

public class DoorState {
	private boolean closed;
	
	public DoorState() {this.closed = true;}
	
	public boolean isClosed( ) {return closed;}
	
	public void setClosed (boolean closed) { this.closed = closed;}
	
}
