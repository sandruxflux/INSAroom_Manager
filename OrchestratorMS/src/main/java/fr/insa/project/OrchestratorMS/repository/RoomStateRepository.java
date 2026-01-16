package fr.insa.project.OrchestratorMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.insa.project.OrchestratorMS.model.RoomState;

@Repository
public interface RoomStateRepository extends JpaRepository <RoomState, Long> {

}