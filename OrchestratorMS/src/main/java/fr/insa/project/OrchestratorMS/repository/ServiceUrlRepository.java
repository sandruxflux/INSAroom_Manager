package fr.insa.project.OrchestratorMS.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository ;
import org.springframework.stereotype.Repository;

import fr.insa.project.OrchestratorMS.model.Room;
import fr.insa.project.OrchestratorMS.model.ServiceUrl;

@Repository

public interface ServiceUrlRepository extends JpaRepository<ServiceUrl, Long>{
	Optional<ServiceUrl> findByServiceName(String name);
}
