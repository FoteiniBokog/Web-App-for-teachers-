package com.project.ProjectApp_4315_4438.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ProjectApp_4315_4438.DAO.StudentRegistrationDAO;
import com.project.ProjectApp_4315_4438.Entity.StudentRegistration;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
	
	@Autowired
	private StudentRegistrationDAO studentRepository;
	
	
	public StudentRegistrationServiceImpl()
	{
		super();
	}
	
	@Autowired
	public StudentRegistrationServiceImpl(StudentRegistrationDAO theStudentRepository)
	{
		studentRepository = theStudentRepository;
	}
	

	@Override
	@Transactional
	public void save(StudentRegistration theStudent) 
	{
		studentRepository.save(theStudent);

	}

	@Override
	@Transactional
	public void deleteById(int theId) 
	{
		studentRepository.deleteById(theId);

	}
	
	@Override
	@Transactional
	public StudentRegistration findById(int theId)
	{
		StudentRegistration result =studentRepository.findById(theId);
		if(result!=null) {
			return result;
		}
		else {
			return null;
		}
	}

	@Override
	@Transactional
	public List<StudentRegistration> findAll() {
		
		return studentRepository.findAll();
	}
}
