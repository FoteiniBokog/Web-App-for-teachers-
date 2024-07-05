package com.project.ProjectApp_4315_4438;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.project.ProjectApp_4315_4438.Controller.StudentController;
import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

@AutoConfigureMockMvc
public class StudentControllerTest {
		
		@Autowired
	    private WebApplicationContext context;
		
		@Autowired
		private MockMvc mockMvc;
		
		@Autowired
		StudentController studentController;

		@BeforeEach
	    public void setup() {
			mockMvc = MockMvcBuilders
	          .webAppContextSetup(context)
	          .build();
	    }
		
		@Test
		void testStudentControllerIsNotNull() {
			Assertions.assertNotNull(studentController);
		}
		
		@Test
		void testMockMvcIsNotNull() {
			Assertions.assertNotNull(mockMvc);
		}
		
		
		@Test 
		void testListStudentsReturnsPage() throws Exception {
			mockMvc.perform(get("/student/list")).
			andExpect(status().isOk()). // adds result matchers that check some property
			andExpect(view().name("students/list-student")); // adds view matchers that check some property		
		}

		@Test 
		@WithMockUser(value="zaras")
		void testSaveStudentReturnsPage() throws Exception {
			
		    StudentRegistration student = new StudentRegistration(1, "Fotini", "Bokogianni", 5.0, 5.0);
		    	    
		    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		    multiValueMap.add("id", Integer.toString(student.getId()));
		    multiValueMap.add("firstName", student.getFirstName());
		    multiValueMap.add("lastName", student.getLastName());
		    multiValueMap.add("ExamGrade",Double.toString(student.getExamGrade()));
		    multiValueMap.add("ProjectGrade", Double.toString(student.getProjectGrade()));
		  
		    
			mockMvc.perform(
					post("/student/save")
				    .params(multiValueMap))
					.andExpect(status().isFound())
					.andExpect(view().name("redirect:/student/list"));
							
		}
}


