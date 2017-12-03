package app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.Event;

@Repository
public interface EventDao extends JpaRepository<Event, Integer> {

	@Query(value="select e.* from user_event ue, event e where ue.user_id = ?1 and ue.event_id = e.id", nativeQuery=true)
	List<Event> findMyEventsByIdUser(int id);
	
	@Query(value="select e.* from user_event ue, event e where ue.user_id = ?1 and ue.event_id != e.id", nativeQuery=true)
	List<Event> findEventsByIdUser(int id);
	
}
