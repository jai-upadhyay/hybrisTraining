package org.nagarro.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.nagarro.model.User;
import org.nagarro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String getLogin(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null) {
			user = new User();
			user.setUsername("admin");
			user.setPassword("admin");
		}
		model.addAttribute("user",user);
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Username set: " + user.getUsername());
		
		if(result.hasErrors()) {
			return "login";
		}
		else {
			loginService.doLogin(user);
		}
		return "redirect:employees";
	}

}
