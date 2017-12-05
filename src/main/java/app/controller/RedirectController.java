package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import app.dao.UserDao;

@Controller
public class RedirectController {

	@Autowired
	UserDao usuariodao;

	@RequestMapping("/")
	public String Home(Authentication auth){
		if(auth != null){
			return "redirect:/redirecionar";
		}else{
			return "FormSignIn";
		}
	}

	@RequestMapping("/SignUp")
	public String SignUp(){
		return "FormUserSignUp";
	}

	@RequestMapping("/SignIn")
	public String SignIn(){
		return "FormSignIn";
	}

	@RequestMapping("adm/AddEvent")
	public String AddEventForm(){
		return "adm/ADM_FormAddEvent";

	}
}
