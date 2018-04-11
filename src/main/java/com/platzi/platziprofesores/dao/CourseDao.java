package com.platzi.platziprofesores.dao;

import java.util.List;

import com.platzi.platziprofesores.model.Course;

public interface CourseDao {
	
	void saveDao(Course course);
	
	void deleteById(Long idCourse);
	
	void updateCourseBy(Course course);
	
	Course findCourseById(Long idCourse);
	
	List<Course> findAllCourses();
	
	Course findCourseByName(String name);
	
	List<Course> findCourseByIdTeacher(Long idTeacher);
	
}
