package com.project.ProjectApp_4315_4438;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.ProjectApp_4315_4438.DAO.StudentRegistrationDAO;
import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class StudentRegistrationDAOTest {
		
		@Autowired 
		StudentRegistrationDAO studentRegistrationDAO;
			
		@Test
		void testStudentRegistrationDAOJpaImplIsNotNull() {
			Assertions.assertNotNull(studentRegistrationDAO);
		}

		@Test
		void testFindByIdReturnsStudentRegistration() {
			StudentRegistration storedStudentRegistration = studentRegistrationDAO.findById(1);
			Assertions.assertNotNull(storedStudentRegistration);
			Assertions.assertEquals("Fotini", storedStudentRegistration.getFirstName());
			Assertions.assertEquals("Bokogianni", storedStudentRegistration.getLastName());
			
		}

}
