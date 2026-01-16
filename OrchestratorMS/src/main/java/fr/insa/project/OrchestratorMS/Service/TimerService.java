package fr.insa.project.OrchestratorMS.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TimerService {
	private final OrchestratorService orchestratorService;
	
	public TimerService(OrchestratorService orchestratorService) {
		this.orchestratorService = orchestratorService;
	}
	
	//@Scheduled(cron ="0 0 22 * * ?")
	@Scheduled(cron ="*/20 * * * * ?")  //Nous permet de tester toutes les 20s
	public void NightModeActivate() {
		
		System.out.println("Night mode triggered");
		orchestratorService.nightModeForAllRooms();
	}
	
	@Scheduled(cron ="0 0 22 * * ?")
	public void MorningModeActivate() {
		
		System.out.println("Morning mode triggered");
		orchestratorService.morningModeForAllRooms();
	}

}
