package app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.dao.CommentDao;
import app.model.Comment;
import app.model.User;

@Controller
public class CommentController {

	@Autowired
	CommentDao commentdao;

	@RequestMapping("user/Commentar/{event_id}")
	public String userComment(@PathVariable("event_id") int event_id, 
			@RequestParam("comment") String text, Model model, HttpServletRequest req){
		HttpSession session = req.getSession();
		Comment comment = new Comment();
		User user = (User) session.getAttribute("user");

		comment.setComment(user.getName() + ": " + text);
		comment.setId_evento(event_id);
		comment.setId_usuario(user.getId());
		commentdao.save(comment);

		return "redirect:/user/EventDetail/" + event_id;
	}

	@RequestMapping("/user/Responder/{event_id}/{comment_id}")
	public String userAnswer(@PathVariable("event_id") int event_id, @PathVariable("comment_id") String comment_id, 
			@RequestParam("answer") String text, Model model, HttpServletRequest req){
		HttpSession session = req.getSession();
		Comment comment = commentdao.findById(comment_id).get();
		User user = (User) session.getAttribute("user");
		List<String> answers;
		if(comment.getAnswer() == null){
			answers = new ArrayList<String>();
		}else{
			answers = comment.getAnswer();	
		}
		answers.add(user.getName() + ": " + text);
		comment.setAnswer(answers);
		commentdao.save(comment);
		return "redirect:/user/EventDetail/" + event_id;
	}
}
