package com.project.ProjectApp_4315_4438.Service;
import java.util.List;

import com.project.ProjectApp_4315_4438.Entity.Course;
//import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;


public interface CourseService {
	public void save(Course theCourse);
	public void deleteById(int theId);
	public List<Course> findAll();
	public Course findById(int theCourseId);
	//public void registerExamGrade(StudentRegistration s, double ExamGrade);
	//public void registerProjectGrade(StudentRegistration s, double ProjectGrade);
}
