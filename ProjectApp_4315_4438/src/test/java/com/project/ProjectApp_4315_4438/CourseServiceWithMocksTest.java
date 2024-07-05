package com.project.ProjectApp_4315_4438;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.ProjectApp_4315_4438.Entity.Course;
import com.project.ProjectApp_4315_4438.Service.CourseService;
import com.project.ProjectApp_4315_4438.Service.CourseServiceImp;

@ExtendWith(SpringExtension.class) // extends junit with spring test capabilities
/*
 * @TestConfiguration can be used to 
 * define additional beans or customizations for a test
 */
public class CourseServiceWithMocksTest {
		
			@TestConfiguration
		    static class CourseServiceImplTestContextConfiguration {
		 
		        @Bean
		        public CourseService courseService() {
		            return new CourseServiceImp();
		        }
		    }

			@Autowired 
			CourseService courseService;
			
			@MockBean
			CourseService courseDAO;
			
			@Test
			void testCourseDAOJpaImplIsNotNull() {
				Assertions.assertNotNull(courseService);
			}

			@Test
			void testFindByIdReturnsCourse() {
				Mockito.when(courseDAO.findById(2)).thenReturn(new Course(1, "Bokogianni", 2, "Texnologia Logismikou", 2022,"Spring's course"));
				
				Course storedCourse = courseService.findById(2);
				Assertions.assertNotNull(storedCourse);
				Assertions.assertEquals("Texnologia Logismikou", storedCourse.getCourseName());
				
				 
				    
			}
}



