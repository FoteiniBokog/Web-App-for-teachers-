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
import com.project.ProjectApp_4315_4438.Entity.Course;
import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;
import com.project.ProjectApp_4315_4438.Service.CourseService;


@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	public CourseController() {}
	
	
	
	public CourseController(CourseService theCourseService) {
		courseService = theCourseService;
	}
	
	// add mapping for "/list"
	
	@GetMapping("/list")
	public String listCourses(Model theModel) {
		
		// get employees from db
		List<Course> thecourses = courseService.findAll();
		
		// add to the spring model
		theModel.addAttribute("courses", thecourses);
		
		return "courses/list-courses";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Course course = new Course();
		
		
		theModel.addAttribute("courses",course);
		
		return "courses/course-form";
	}
	
	@GetMapping("/showFormForUpdate")//description
	public String showFormForUpdate(@RequestParam("courseId") int theId,Model theModel) {
		
		List<Course>courses=(List<Course>)theModel.getAttribute("courses");
		
		// get the employee from the service
		Course thecourses = courseService.findById(theId); //diornono
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("courses", thecourses);
		
		// send over to our form
		return "courses/course-form";			
	}
	
	@PostMapping("/save")
	public String saveCourse(@ModelAttribute("courses") 	Course theCourse, Model theModel) {
		
		// save the course
		courseService.save(theCourse);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/courses/list"; //lathos
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		
		// delete the course
		courseService.deleteById(theId);
		
		// redirect to /courses/list
		return "redirect:/courses/list";
		
	}
}



	
	


