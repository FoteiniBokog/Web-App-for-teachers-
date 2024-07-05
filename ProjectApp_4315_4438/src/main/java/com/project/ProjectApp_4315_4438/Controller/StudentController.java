package com.project.ProjectApp_4315_4438.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;
import com.project.ProjectApp_4315_4438.Service.StudentRegistrationService;



@Controller
@RequestMapping("/student")

public class StudentController {
	@Autowired
	private StudentRegistrationService studentService;
	
	public StudentController() {}
	
	
	
	public StudentController(StudentRegistrationService theStudentService) {
		studentService = theStudentService;
	}
	
	// add mapping for "/list"
	
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
		// get employees from db
		List<StudentRegistration> theStudents = studentService.findAll();
		
		// add to the spring model
		theModel.addAttribute("students", theStudents);
		
		return "students/list-student";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		StudentRegistration student = new StudentRegistration();
		
		
		theModel.addAttribute("students",student);
		
		return "students/student-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,Model theModel) {
		
		List<StudentRegistration>students=(List<StudentRegistration>)theModel.getAttribute("students");
		// get the employee from the service
		StudentRegistration theStudents = studentService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("students", theStudents);
		
		// send over to our form
		return "students/student-form";			
	}
	
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("students") 	StudentRegistration theStudents, Model theModel) {
		
		// save the employee
		studentService.save(theStudents);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		// delete the employee
		studentService.deleteById(theId);
		
		
		return "redirect:/student/list"; //lathos
		
	}
}


