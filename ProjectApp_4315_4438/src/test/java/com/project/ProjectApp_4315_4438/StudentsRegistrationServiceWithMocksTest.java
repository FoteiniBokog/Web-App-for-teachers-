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

import com.project.ProjectApp_4315_4438.DAO.StudentRegistrationDAO;
import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;
import com.project.ProjectApp_4315_4438.Service.StudentRegistrationService;
import com.project.ProjectApp_4315_4438.Service.StudentRegistrationServiceImpl;

@ExtendWith(SpringExtension.class) // extends junit with spring test capabilities
/*
 * @TestConfiguration can be used to 
 * define additional beans or customizations for a test
 */
public class StudentsRegistrationServiceWithMocksTest {
	
		@TestConfiguration
	    static class StudentServiceImplTestContextConfiguration {
	 
	        @Bean
	        public StudentRegistrationService studentRegistrationService() {
	            return new StudentRegistrationServiceImpl();
	        }
	    }

		@Autowired 
		StudentRegistrationService studentService;
		
		@MockBean
		StudentRegistrationService studentRegistrationDAO;
		
		@Test
		void testStudentRegistrationDAOJpaImplIsNotNull() {
			Assertions.assertNotNull(studentService);
		}

		@Test
		void testFindByIdReturnsStudent() {
			Mockito.when(studentRegistrationDAO.findById(2)).thenReturn(new StudentRegistration(2, "Bokogianni", "Fotini", 5.0,5.0));
			
			StudentRegistration storedStudent = studentService.findById(2);
			Assertions.assertNotNull(storedStudent);
			Assertions.assertEquals(2, storedStudent.getId());
			Assertions.assertEquals("Fotini", storedStudent.getFirstName());
			Assertions.assertEquals("Bokogianni", storedStudent.getLastName());
			Assertions.assertEquals(5.0, storedStudent.getExamGrade());
			Assertions.assertEquals(5.0, storedStudent.getProjectGrade());
			
			 
			    
		}
}


