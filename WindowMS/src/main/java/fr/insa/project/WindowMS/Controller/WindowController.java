package fr.insa.project.WindowMS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.project.WindowMS.Service.WindowService;
import fr.insa.project.WindowMS.model.WindowState;



@RestController
@RequestMapping


public class WindowController {
	
	WindowService windowService = new WindowService();
	
	@GetMapping("/status")
	public WindowState getStatus() {
		return windowService.getWindowState();
	}
	
	@PostMapping("/open")
	public WindowState openWindow() {
		windowService.openWindow();
		return windowService.getWindowState();
	}
	
	@PostMapping("/close")
	public WindowState closeWindow() {
		windowService.closeWindow();
		return windowService.getWindowState();
	}

}
