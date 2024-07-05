package com.project.ProjectApp_4315_4438.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.ProjectApp_4315_4438.DAO.CourseDAO;
import com.project.ProjectApp_4315_4438.Entity.Course;
//import Service.statistics.StatisticStrategy;

@Service
public class CourseServiceImp  implements CourseService{
	
	
	@Autowired
	private CourseDAO courseRepository;
	
	
	public CourseServiceImp()
	{
		super();
	}
	
	@Autowired
	public CourseServiceImp( CourseDAO theCourseRepository)
	{
		courseRepository = theCourseRepository;
	}
	
	

	@Override
	@Transactional
	public void save(Course thecourse) {
		courseRepository.save(thecourse);
		
	}

	@Override
	@Transactional
	public void deleteById(int thecourseId) {
		courseRepository.deleteById(thecourseId);
		
	}

	@Override
	@Transactional
	public List<Course> findAll() {
		return courseRepository.findAll();
		
	}

	@Override
	@Transactional
	public Course findById(int theCourseId) {
		Course result =courseRepository.findById(theCourseId);
		if(result!=null) {
			return result;
		}
		else {
			return null;
		}
	}

	/*@Override
	@Transactional
	public void registerExamGrade(StudentRegistration s, double ExamGrade) {
		// TODO Auto-generated method stub
		s.setExamGrade(ExamGrade);
		
	}
	@Override
	@Transactional
	public void registerProjectGrade(StudentRegistration s, double ProjectGrade) {
		// TODO Auto-generated method stub
		s.setProjectGrade(ProjectGrade);
		
	}
	
	/*public Map<String,Double>getCourseStatistics(){
	
	}
	public List<StatisticStrategy>getStatCalculationStrategies(){
		
	}
	public void setStatCalculationStrategies(List<StatisticStrategy>){	
		
	}*/
	

}

