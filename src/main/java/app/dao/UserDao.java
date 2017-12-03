package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	@Query(value="select * from users where email = ?1", nativeQuery=true)
	public User findByEmail(String email);
	
}
