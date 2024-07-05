package com.project.ProjectApp_4315_4438.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CourseId")
	private int CourseId;
	
	@Column(name="professor")
	private  String professor;
	
	@Column(name="semester")
	private int semester;
	
	@Column(name="CourseName")
	private String CourseName;
	
	@Column(name="year")
	private int year;
	
	@Column(name="syllabus")
	private String syllabus;
	
	public Course() {}
	
	public Course(int CourseId,String professor,int semester,String CourseName, int year,String syllabus) {
		this.CourseId=CourseId;
		this.professor=professor;
		this.semester=semester;
		this.CourseName=CourseName;
		this.year=year;
		this.syllabus=syllabus;
	}
	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int CourseId) {
		this.CourseId = CourseId;
	}         
	
	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String CourseName) {
		this.CourseName =CourseName;
	}
	
	public int getYear() {
		return  year;
	}

	public void setYear(int year ) {
		this.year = year;
	}
	
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	
	public String getSyllabus() {
		return syllabus;
	}
	
}