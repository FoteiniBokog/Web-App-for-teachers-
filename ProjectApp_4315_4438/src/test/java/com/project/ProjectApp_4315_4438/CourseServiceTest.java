package com.project.ProjectApp_4315_4438;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.project.ProjectApp_4315_4438.Entity.Course;
import com.project.ProjectApp_4315_4438.Service.CourseService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ContextConfiguration(classes= {Application.class,CourseService.class})
public class CourseServiceTest {

			@Autowired 
			CourseService courseService;
			
			@Test
			void testCourseDAOJpaImplIsNotNull() {
				Assertions.assertNotNull(courseService);
			}

			@Test
			void testFindByIdReturnsCourse() {
				Course storedCourse = courseService.findById(1);
				Assertions.assertNotNull(storedCourse);
				Assertions.assertEquals("Zaras", storedCourse.getProfessor());
			}
}


