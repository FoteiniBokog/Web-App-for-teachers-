package com.project.ProjectApp_4315_4438.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;

@Repository
public interface StudentRegistrationDAO extends JpaRepository<StudentRegistration,Integer> {
	public StudentRegistration findById(int theId);
	//public void save(StudentRegistration theStudent);
	public void deleteById(int theId);
	public List<StudentRegistration> findAll();

	
}
