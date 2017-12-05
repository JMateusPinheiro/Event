package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> { }