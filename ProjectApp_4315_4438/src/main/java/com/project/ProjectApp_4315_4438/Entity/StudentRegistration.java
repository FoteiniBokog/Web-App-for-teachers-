package com.project.ProjectApp_4315_4438.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentRegistration {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="firstName")
		private String firstName;
		
		@Column(name="lastName")
		private String lastName;
		
		@Column(name="ExamGrade")
		private double ExamGrade;
		
		@Column(name="ProjectGrade")
		private double ProjectGrade;
		
		
		
		
		// define constructors
		
		public StudentRegistration() {
			
		}
		
		public StudentRegistration(int id, String firstName, String lastName, double ExamGrade,double ProjectGrade) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.ExamGrade = ExamGrade;
			this.ProjectGrade=ProjectGrade;
			
			
		}
		
		public StudentRegistration(int id,String firstName, String lastName) {
			this.id=id;
			this.firstName = firstName;
			this.lastName = lastName;
			
		}

	
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public double getExamGrade() {
			return ExamGrade;
		}
		public void setExamGrade(double ExamGrade) {
			this.ExamGrade = ExamGrade;
		}
		public double getProjectGrade() {
			return ProjectGrade;
		}
		public void setProjectGrade(double ProjectGrade) {
			this.ProjectGrade = ProjectGrade;
		}
		/*public int getcourseId() {
			return courseId;
		}
		public void setcourseId(int courseId) {
			this.courseId = courseId;
		}*/
			
	}
