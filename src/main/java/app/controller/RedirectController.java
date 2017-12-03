package app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import app.model.User;

@Controller
public class RedirectController {

	@RequestMapping("/")
	public String Home(){
		return "FormSignIn";
	}
	
	@RequestMapping("/SignUp")
	public String SignUp(){
		return "FormUserSignUp";
	}
	
	@RequestMapping("SignIn")
	public String SignIn(){
		return "FormSignIn";
	}
	
	@RequestMapping("HomeAdm")
	public String HomeAdm(){
		return "redirect:adm/mngEvent";
	}
	
	@RequestMapping("HomeUser")
	public String HomeUser(HttpServletRequest req){
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		return "redirect:user/Events/" + user.getId();
	}
	
	@RequestMapping("adm/AddEvent")
	public String AddEventForm(){
		return "adm/ADM_FormAddEvent";
		
	}
	
}
