package com.project.ProjectApp_4315_4438.Service;
import java.util.List;
import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;


public interface StudentRegistrationService {
	public void save(StudentRegistration theStudent);
	public void deleteById(int theId);
	public List<StudentRegistration> findAll();
	public StudentRegistration findById(int theId);
}
