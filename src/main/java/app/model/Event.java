package app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Event {

	@Id
	@GeneratedValue
	int id;
	String nome;
	String descricao;
	String inicio;
	String fim;
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "user_event", 
	joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	List<User> user_event;

	public Event(int id, String nome, String descricao, String inicio, String fim) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Event (){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	public List<User> getUsuarios() {
		return user_event;
	}
	public void setUsuarios(List<User> users) {
		this.user_event = users;
	}

}
