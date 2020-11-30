package com.webadd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webadd.entity.Course;
import com.webadd.service.dao.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return this.courseRepository.findAll();
	}

	@Override
	public Course getCourseById(int id) {
		Optional<Course> result = this.courseRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public Course updateCourse(Course course) {
		return this.courseRepository.save(course);
	}

	@Override
	public void deleteById(int id) {
		courseRepository.deleteById(id);
	}

}
