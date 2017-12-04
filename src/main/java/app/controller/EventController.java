package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import app.dao.EventDao;
import app.dao.UserDao;
import app.model.Event;
import app.model.User;

@Controller
public class EventController {

	@Autowired
	UserDao usuariodao;
	
	@Autowired
	EventDao eventdao;
	
	@RequestMapping("adm/addEvent")
	public String addEvent(Event event){
		eventdao.save(event);
		return "redirect:/adm/mngEvent";
	}
	
	@RequestMapping("adm/rmEvent/{id}")
	public String removeEvent(@PathVariable("id") int id){
		eventdao.deleteById(id);
		return "redirect:/adm/mngEvent";
	}
	
	@RequestMapping("adm/mngEvent")
	public String ManagerEvent(Model model, Authentication auth){
		List<Event> eventos = eventdao.findAll();
		User user = usuariodao.findByEmail(auth.getName());
		model.addAttribute("user", user);
		model.addAttribute("events", eventos);
		return "adm/ADM_ManagerEvents";
	}
}
