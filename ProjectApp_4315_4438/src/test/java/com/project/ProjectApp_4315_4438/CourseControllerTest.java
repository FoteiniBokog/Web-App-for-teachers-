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

import com.project.ProjectApp_4315_4438.Controller.CourseController;
import com.project.ProjectApp_4315_4438.Entity.Course;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc

public class CourseControllerTest {
			
			@Autowired
		    private WebApplicationContext context;
			
			@Autowired
			private MockMvc mockMvc;
			
			@Autowired
			CourseController courseController;

			@BeforeEach
		    public void setup() {
				mockMvc = MockMvcBuilders
		          .webAppContextSetup(context)
		          .build();
		    }
			
			@Test
			void testCourseControllerIsNotNull() {
				Assertions.assertNotNull(courseController);
			}
			
			@Test
			void testMockMvcIsNotNull() {
				Assertions.assertNotNull(mockMvc);
			}
			
			
			@Test 
			@WithMockUser(value="zaras")
			void testListCourseReturnsPage() throws Exception {
				mockMvc.perform(get("/courses/list")).
				andExpect(status().isOk()). // adds result matchers that check some property
				andExpect(model().attributeExists("courses")). // adds view matchers that check some property	
				andExpect(view().name("courses/list-courses"));
			}

			@Test 
			@WithMockUser(value="zaras")
			void testSaveCourseReturnsPage() throws Exception {
				
			    Course course = new Course(1, "Bokogianni", 2, "Texnologia Logismikou", 2022,"Spring's course");
			    	    
			    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
			    multiValueMap.add("CourseId", Integer.toString(course.getCourseId()));
			    multiValueMap.add("professor", course.getProfessor());
			    multiValueMap.add("semester", Integer.toString(course.getSemester()));
			    multiValueMap.add("CourseName",course.getCourseName());
			    multiValueMap.add("year", Integer.toString(course.getYear()));
			    multiValueMap.add("syllabus", course.getSyllabus());
			    
				mockMvc.perform(
						post("/courses/save")
					    .params(multiValueMap))
						.andExpect(status().isFound())
						.andExpect(view().name("redirect:/courses/list"));
								
			}
}





