package com.project.ProjectApp_4315_4438;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;
import com.project.ProjectApp_4315_4438.Service.StudentRegistrationService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ContextConfiguration(classes= {Application.class, StudentRegistrationService.class})
public class StudentRegistrationServiceTest {

		@Autowired 
		StudentRegistrationService studentRegistrationService;
		
		@Test
		void testStudentRegistrationDAOJpaImplIsNotNull() {
			Assertions.assertNotNull(studentRegistrationService);
		}

		@Test
		void testFindByIdReturnsStudentRegistration() {
			StudentRegistration storedStudent = studentRegistrationService.findById(2);
			Assertions.assertNotNull(storedStudent);
			Assertions.assertEquals("Andreou", storedStudent.getLastName());
		}
}


