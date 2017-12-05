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
	
	@Query(value="SELECT * FROM event WHERE id NOT IN (SELECT event_id FROM user_event WHERE user_id = ?1)", nativeQuery=true)
	List<Event> findEventsByIdUser(int id);
	
//	@Modifying
//	@Query("DELETE FROM user_event WHERE user_id = ?1 AND event_id = ?2")
//	void deleteEventOfUser(int user_id, int event_id);
}
