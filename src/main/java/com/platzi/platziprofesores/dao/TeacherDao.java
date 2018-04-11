package com.platzi.platziprofesores.dao;

import java.util.List;

import com.platzi.platziprofesores.model.Teacher;


public interface TeacherDao {
	
	void saveTeacher(Teacher teacher);
	
	void deleteTeacherById(Long id);
	
	void updateTeacherBy(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	
	Teacher findTeacherById(Long id);
	
	Teacher findTeacherByName(String name);
}
