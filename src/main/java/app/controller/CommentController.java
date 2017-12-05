package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.dao.CommentDao;
import app.dao.UserDao;
import app.model.Comment;
import app.model.User;

@Controller
public class CommentController {

	@Autowired
	CommentDao commentdao;
	
	@Autowired
	UserDao userDao;

	@RequestMapping("user/Commentar/{event_id}")
	public String userComment(@PathVariable("event_id") int event_id, 
			@RequestParam("comment") String text, Model model, Authentication auth){
		User user = userDao.findByEmail(auth.getName());
		Comment comment = new Comment(user.getNome(), event_id, user.getId(), text);
		commentdao.save(comment);

		return "redirect:/user/EventDetail/" + event_id;
	}

	@RequestMapping("/user/Responder/{event_id}/{comment_id}")
	public String userAnswer(@PathVariable("event_id") int event_id, @PathVariable("comment_id") String comment_id, 
			@RequestParam("answer") String text, Model model, Authentication auth){
		Comment comment = commentdao.findById(comment_id).get();
		User user = userDao.findByEmail(auth.getName());
		List<Comment> answers;
		if(comment.getAnswer() == null){
			answers = new ArrayList<Comment>();
		}else{
			answers = comment.getAnswer();	
		}
		answers.add(new Comment(user.getNome(), event_id, user.getId(), text));
		comment.setAnswer(answers);
		commentdao.save(comment);
		return "redirect:/user/EventDetail/" + event_id;
	}
}
