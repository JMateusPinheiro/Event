package app.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.dao.CommentDao;
import app.dao.EventDao;
import app.dao.RoleDao;
import app.dao.UserDao;
import app.model.Comment;
import app.model.Event;
import app.model.Role;
import app.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao usuariodao;

	@Autowired
	EventDao eventdao;

	@Autowired
	CommentDao commentdao;

	@Autowired
	private RoleDao roleDao;

	@PostMapping("/RequestSignUp")
	public String SignUp(@Valid User usuario, @RequestParam("re-senha") String resenha, @RequestParam("email") String email, RedirectAttributes red)  {
		if(usuariodao.findByEmail(email) != null){
			red.addFlashAttribute("rusuario", usuario);
			System.out.println("Error: Email Já Cadastrado");
			return "SignUp";
		}
		else {
			Role role = new Role("USER");
			roleDao.saveAndFlush(role);
			usuario.getRoles().add(role);
			role.getUsers().add(usuario);
			roleDao.save(role);
			usuariodao.save(usuario);
			System.out.println("Conta criada com sucesso: " + usuario.getName());
			return "redirect:/";
			}
	}

	@RequestMapping("user/Events/{id}")
	public String EventsUser(@PathVariable("id") int id ,Model model){
		List<Event> eventos = eventdao.findEventsByIdUser(id);
		model.addAttribute("events", eventos);
		return "user/USER_IndexUser";
	}

	@RequestMapping("user/subEvent/{event_id}")
	public String subEvent(@PathVariable("event_id") int event_id, HttpServletRequest req){
		HttpSession session = req.getSession();
		Event event = eventdao.getOne(event_id);
		User user = (User) session.getAttribute("user");
		System.out.println(user.getName());
		event.getUsuarios().add(user);
		eventdao.save(event);
		return "redirect:/user/Events/" + user.getId();
	}

	@RequestMapping("user/MyEvents/{id}")
	public String myEvents(@PathVariable("id") int id, Model model){
		List<Event> myevents = eventdao.findMyEventsByIdUser(id);
		model.addAttribute("myevents", myevents);
		return "user/USER_MyEvents";
	}

	@RequestMapping("user/EventDetail/{event_id}")
	public String eventDetails(@PathVariable("event_id") int event_id, Model model){
		model.addAttribute("event" ,eventdao.getOne(event_id));
		List<Comment> comments = commentdao.findAll();
		model.addAttribute("comments", comments);
		return "user/USER_EventDetails";
	}

	@PostMapping("/login")
	public String Login(@RequestParam("password") String password, @RequestParam("email") String email, HttpServletRequest req, Principal user){
		System.out.println(user.getName());
//		HttpSession session = req.getSession();
//		User user2 = usuariodao.findByEmail(email);
//		if(user2.getPassword().equals(password)){
//			session.setAttribute("user", user2);
//			if(user2.getId() == 1){
//				return "redirect:HomeAdm";
//			}
//			return "redirect:HomeUser";
//		}
//		else{
//			return "/";	
//		}
		return "We are the champion";
	}
}
