package com.platzi.platziprofesores.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.platzi.platziprofesores.model.Teacher;
import com.platzi.platziprofesores.model.TeacherSocialMedia;


public class TeacherDaoImpl extends AbstractSession implements TeacherDao {

	@Override
	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().persist(teacher);
	}

	@Override
	public void deleteTeacherById(Long id) {
		Teacher teacher = findTeacherById(id);

		if (teacher != null) {

			Iterator<TeacherSocialMedia> i = teacher.getTeacherSocialMedia().iterator();
			while (i.hasNext()) {
				TeacherSocialMedia teacherSocialmedia = i.next();
				i.remove();
				getSession().delete(teacherSocialmedia);				
			}
			
			teacher.getTeacherSocialMedia().clear();
			getSession().delete(teacher);
		}
	}

	@Override
	public void updateTeacherBy(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().update(teacher);

	}

	@Override
	public List<Teacher> findAllTeachers() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Teacher").list();
	}

	@Override
	public Teacher findTeacherById(Long idTeacher) {
		// TODO Auto-generated method stub
		return getSession().get(Teacher.class, idTeacher);
	}

	@Override
	public Teacher findTeacherByName(String name) {
		// TODO Auto-generated method stub
		return (Teacher) getSession().createQuery("from Teacher where name = :name").setParameter("name", name)
				.uniqueResult();
	}

}
