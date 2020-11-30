package com.webadd.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webadd.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
