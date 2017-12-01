package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import app.dao.EventDao;
import app.model.Event;

@Controller
public class EventController {
	
	@Autowired
	EventDao eventdao;
	
	@RequestMapping("adm/addEvent")
	public String addEvent(Event event){
		eventdao.save(event);
		return "redirect:/adm/mngEvent";
	}
	
	@RequestMapping("adm/rmEvent/{id}")
	public String removeEvent(@PathVariable("id") int id){
		eventdao.delete(id);
		return "redirect:/adm/mngEvent";
	}
	
	@RequestMapping("adm/mngEvent")
	public String ManagerEvent(Model model){
		List<Event> eventos = eventdao.findAll();
		model.addAttribute("events", eventos);
		return "adm/ADM_ManagerEvents";
	}
}
