package services;

import models.Student;
import play.db.jpa.JPA;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class StudentService {
	public Student getById(int id) {
		return JPA.em().find(Student.class, id);
	}
	public Collection<Student> getAllStudents() {
		EntityManager em = JPA.em();
		String queryString = "SELECT s from Student s"; //HSQL syntax
		TypedQuery<Student> query = em.createQuery(queryString, Student.class);
		return query.getResultList();		
	}
	public boolean storeStudent(Student student) {
		EntityManager em = JPA.em();
		try {
			em.persist(student);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
