package app.model;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
	
	public Comment(String owner, int id_evento, int id_usuario, String comment) {
		this.owner = owner;
		this.id_evento = id_evento;
		this.id_usuario = id_usuario;
		this.comment = comment;
	}
	
	public Comment() {
	
	}
	
	@Id
	String id;
	String owner;
	int id_evento;
	int id_usuario;
	String comment;
	List<Comment> answer;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Comment> getAnswer() {
		return answer;
	}
	public void setAnswer(List<Comment> answer) {
		this.answer = answer;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	
}
