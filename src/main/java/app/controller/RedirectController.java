package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping("/")
	public String Home(){
		return "FormSignIn";
	}
	
	@RequestMapping("SignUp")
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
	public String HomeUser(){
		return "redirect:user/Events";
	}
	
	@RequestMapping("adm/AddEvent")
	public String AddEventForm(){
		return "adm/ADM_FormAddEvent";
		
	}
	
}
