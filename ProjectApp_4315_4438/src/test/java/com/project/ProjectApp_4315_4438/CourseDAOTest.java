package com.project.ProjectApp_4315_4438;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.ProjectApp_4315_4438.DAO.CourseDAO;
import com.project.ProjectApp_4315_4438.Entity.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseDAOTest {
			
			@Autowired 
			CourseDAO courseDAO;
				
			@Test
			void testCourseDAOJpaImplIsNotNull() {
				Assertions.assertNotNull(courseDAO);
			}

			@Test
			void testFindByIdReturnsCourse() {
				Course storedCourse = courseDAO.findById(1);
				Assertions.assertNotNull(storedCourse);
				Assertions.assertEquals("Zaras", storedCourse.getProfessor());
			}
}


