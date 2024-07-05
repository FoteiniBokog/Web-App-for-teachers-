package com.project.ProjectApp_4315_4438.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
	
	@GetMapping("/Menu")
	public String Menu(Model theModel) {
		
		//return "/students/list-student";
		return "Application"; 
	}
}
