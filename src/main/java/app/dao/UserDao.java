package app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	public List<User> findByEmail(String email);
}
