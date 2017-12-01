package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Event;

@Repository
public interface EventDao extends JpaRepository<Event, Integer> {
	
}
