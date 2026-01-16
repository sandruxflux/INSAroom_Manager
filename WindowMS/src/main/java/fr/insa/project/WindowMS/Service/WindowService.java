package fr.insa.project.WindowMS.Service;

import org.springframework.stereotype.Service;

import fr.insa.project.WindowMS.model.WindowState;

@Service

public class WindowService {
	

	
	private WindowState window = new WindowState();
	
	public WindowState getWindowState() {
		return window;
	}
	
	public void openWindow( ) {
		window.setClosed(false);
		}
	
	public void closeWindow( ) {
		window.setClosed(true);
		}



}
