package com.webadd.service;


import java.util.List;

import com.webadd.entity.Course;

public interface CourseService {
	public Course addCourse(Course course);
	public List<Course> getAllCourses();
	public Course getCourseById(int id);
	public void deleteById(int id);
	public Course updateCourse(Course course);
}
