package com.webadd.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webadd.entity.Course;
import com.webadd.service.CourseService;

@RestController
public class AppController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/")
	public String homepage() {
		return "This is the home page";
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getACourseById(@PathVariable("courseId") int courseId) {
		try {
			Course course = courseService.getCourseById(courseId);
			return ResponseEntity.of(Optional.of(course));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses(){
		try {
			List<Course> courses =  this.courseService.getAllCourses();
			return ResponseEntity.of(Optional.of(courses));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addACourse(@RequestBody Course course) {
		try {
			Course newCourse = this.courseService.addCourse(course);
			return ResponseEntity.status(HttpStatus.CREATED).body(newCourse);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> updateACourse(@RequestBody Course course) {
		try {
			Course updatedCourse = this.courseService.updateCourse(course);
			return ResponseEntity.of(Optional.of(updatedCourse));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable("courseId") int courseId) {
		this.courseService.deleteById(courseId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
}
