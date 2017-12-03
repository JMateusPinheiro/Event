package app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.model.Comment;

@Repository
public interface CommentDao extends MongoRepository<Comment, String> {

}
