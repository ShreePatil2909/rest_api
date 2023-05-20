package rest_api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rest_api.model.Student;

@Repository
public class StdDaoImpl implements StdDao {

	@Autowired
	SessionFactory factory;

	Session session = null;
	Transaction tx = null;

	@Override
	public Student createStudent(Student student) {

		session = factory.openSession();
		tx = session.beginTransaction();

		session.save(student);
		tx.commit();
		return student;
	}

	@Override
	public List<Student> getAllStudent() {

		session = factory.openSession();
		tx = session.beginTransaction();

		List<Student> std = session.createQuery("from Student").list();

		return std;

	}

	

}
