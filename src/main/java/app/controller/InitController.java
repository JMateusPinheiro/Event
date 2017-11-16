package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitController {

	@RequestMapping("/")
	public String Home(){
		return "Index";
	}
}
