package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import app.dao.UserDao;

@Controller
public class RedirectController {

	@Autowired
	UserDao usuariodao;

	@RequestMapping("/")
	public String Home(){
		return "FormSignIn";
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

//	@RequestMapping("/Redirect")
//	public String Redirect(HttpServletRequest req,Principal user, Model model){
//		System.out.println(user.toString());
//		User user2 = usuariodao.findByEmail(user.getName());
//		model.addAttribute("user", user2);
//		if(user2.getId() == 1){
//			return "redirect:/HomeAdm";
//		}
//		return "redirect:/HomeUser";
//	}

}
