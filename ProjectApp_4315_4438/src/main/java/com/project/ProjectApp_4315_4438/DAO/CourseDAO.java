package com.project.ProjectApp_4315_4438.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ProjectApp_4315_4438.Entity.Course;
//import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;

@Repository
public interface CourseDAO extends JpaRepository<Course,Integer> {

	//public void save(Course course);
	public List<Course> findAll();
	public Course findById(int theCourseId);
	public void deleteById(int theId);
	//public void registerExamGrade(StudentRegistration s, double ExamGrade);
	//public void registerProjectGrade(StudentRegistration s, double ProjectGrade);
	
}
