package com.webadd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String education;
	
	@OneToOne(mappedBy="author")
	@JsonBackReference
	private Course course;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int id, String name, String education, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.education = education;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", education=" + education + "]";
	}

	

	

}
