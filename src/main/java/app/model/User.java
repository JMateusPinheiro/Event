package app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="Users")
public class User implements UserDetails{

	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(unique=true)
	private String email;
	private String address;
	private String phone;
	private String password;
	@ManyToMany(mappedBy="users")
	private List<Event> events;

	private @JsonIgnore Boolean isEnable = true;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="role_user", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id")) 
	private @JsonIgnore List<Role> roles = new ArrayList<Role>();

	public User(int id, String name, String email, String address, String phone, String password, List<Event> events) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.events = events;
		setPassword(password);
	}

	public User(){

	}
	public int getId() {
		return id;
	}
//----------Getters an Setters--------

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

//------------------------------------
	public void setPassword(String password) {
		this.password = PASSWORD_ENCODER.encode(password);
	}

	@Override
	public String getName() {
		return email;
	}

	@Override @JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override @JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override @JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override @JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override @JsonIgnore
	public boolean isEnabled() {
		return isEnable;
	}

}
