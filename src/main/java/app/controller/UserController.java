package app.controller;

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

import app.dao.EventDao;
import app.dao.UserDao;
import app.model.Event;
import app.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao usuariodao;
	
	@Autowired
	EventDao eventdao;
	
	@PostMapping("user/RequestSignUp")
	public String SignUp(@Valid User usuario, @RequestParam("re-senha") String resenha, @RequestParam("email") String email, RedirectAttributes red)  {
		if(!usuariodao.findByEmail(email).isEmpty()){
			red.addFlashAttribute("rusuario", usuario);
			System.out.println("Error: Email Já Cadastrado");
			return "SignUp";
		}
		else if(usuario.getSenha().equals(resenha)){
			usuariodao.save(usuario);
			System.out.println("Conta criada com sucesso: " + usuario.getNome());
			return "redirect:/";
		}
		else{
			red.addFlashAttribute("rusuario", usuario);
			System.out.println("Error: Senhas Não Conferem");
			return "SignUp";
		}
	}
	
	@RequestMapping("user/Events")
	public String EventsUser(Model model){
		List<Event> eventos = eventdao.findAll();
		model.addAttribute("events", eventos);
		return "user/USER_IndexUser";
	}
	
	@RequestMapping("user/subEvent/{event_id}")
	public String subEvent(@PathVariable("event_id") int event_id, HttpServletRequest req){
		HttpSession session = req.getSession();
		Event event = eventdao.findOne(event_id);
		User user = (User) session.getAttribute("user");
		System.out.println(user.getNome());
		event.getUsuarios().add(user);
		eventdao.save(event);
		return "redirect:/user/Events";
	}
	
	@PostMapping("/Login")
	public String Login(@RequestParam("senha") String senha, @RequestParam("email") String email, HttpServletRequest req){
		HttpSession session = req.getSession();
		User user = usuariodao.findByEmail(email).get(0);
		if(user.getSenha().equals(senha)){
			session.setAttribute("user", user);
			if(user.getId() == 1){
				return "redirect:HomeAdm";
			}
			return "redirect:HomeUser";
		}
		else{
			return "/";	
		}
	}
}
