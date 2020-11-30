package com.webadd.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String courseName;
	private float price;
	private String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Author author;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String courseName, float price, String description, Author author) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.price = price;
		this.description = description;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", price=" + price + ", description=" + description
				+ ", author=" + author + "]";
	}

}
