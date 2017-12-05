package app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
	private UserDao usuariodao;

	@Autowired
	private EventDao eventdao;

	@Autowired
	private CommentDao commentdao;

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
			Role role = roleDao.getOne((long) 1);
			roleDao.saveAndFlush(role);
			usuario.getRoles().add(role);
			role.getUsers().add(usuario);
			roleDao.save(role);
			usuariodao.save(usuario);
			System.out.println("Conta criada com sucesso: " + usuario.getNome());
			return "redirect:/";
		}
	}

	@RequestMapping("user/Events")
	public String EventsUser(Model model, Authentication auth){
		List<Event> eventos;
		User user = usuariodao.findByEmail(auth.getName());
		eventos = eventdao.findEventsByIdUser(user.getId());

		model.addAttribute("events", eventos);
		return "user/USER_IndexUser";
	}

	@RequestMapping("user/subEvent/{event_id}")
	public String subEvent(@PathVariable("event_id") int event_id, Authentication auth){
		User user = usuariodao.findByEmail(auth.getName());
		Event event = eventdao.getOne(event_id);
		System.out.println(user.getNome());
		event.getUsuarios().add(user);
		eventdao.save(event);
		return "redirect:/user/Events";
	}
	
	@RequestMapping("user/leaveEvent/{event_id}")
	public String leaveEvent(Authentication auth, @PathVariable("event_id") int event_id){
		User user = usuariodao.findByEmail(auth.getName());
		Event event = eventdao.getOne(event_id);
		event.getUsuarios().remove(user);
		eventdao.save(event);
		return "redirect:/user/MyEvents";
	}

	@RequestMapping("user/MyEvents")
	public String myEvents(Authentication auth, Model model){
		User user = usuariodao.findByEmail(auth.getName());
		List<Event> myevents = eventdao.findMyEventsByIdUser(user.getId());
		model.addAttribute("myevents", myevents);
		return "user/USER_MyEvents";
	}

	@RequestMapping("user/EventDetail/{event_id}")
	public String eventDetails(@PathVariable("event_id") int event_id, Model model){
		model.addAttribute("event", eventdao.getOne(event_id));
		List<Comment> comments = commentdao.findAll();
		model.addAttribute("comments", comments);
		return "user/USER_EventDetails";
	}

	@RequestMapping("/redirecionar")
	public String login(Authentication auth, HttpServletRequest req){
		HttpSession session = req.getSession();
		User user = usuariodao.findByEmail(auth.getName());
		session.setAttribute("user", user);
		if(user.getId() == 1){
			return "redirect:adm/mngEvent";
		}
		return "redirect:/user/Events/";
	}
}
