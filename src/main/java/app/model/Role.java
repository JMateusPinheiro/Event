package app.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private @ManyToMany(mappedBy = "roles") List<User> users = new ArrayList<User>();

    public Role() { }

    public Role(String nome) {
        this.nome = nome;
    }

    public List<User> getUsers () {
        return this.users;
    }

    @Override
    public String getAuthority() {
        return nome;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}