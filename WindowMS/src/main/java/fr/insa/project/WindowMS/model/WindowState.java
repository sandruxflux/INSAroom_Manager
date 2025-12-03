package fr.insa.project.WindowMS.model;

public class WindowState {
	
	private boolean closed;
	
	public WindowState() {
		this.closed = true;
		}
	
	public boolean isClosed( ) {
		return closed;
		}
	
	public void setClosed (boolean closed) { 
		this.closed = closed;
		}
	
}