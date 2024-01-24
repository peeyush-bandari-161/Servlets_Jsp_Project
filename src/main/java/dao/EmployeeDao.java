package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Employee;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("peeyush");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public Employee insertEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
	public Employee getEmpByEmail(String  email) {
		Query query=entityManager.createQuery("SELECT e FROM Employee e WHERE emailId=?1");
		query.setParameter(1, email);
		Employee employee=(Employee) query.getSingleResult();
		return employee;
		
	}
	public List<Employee> getAllEmployees() {
		Query query=entityManager.createQuery("SELECT e FROM Employee e");
		List<Employee>employees=query.getResultList();
		return employees;
	}
	public boolean deleteEmployee(int id) {
	   Employee employee=entityManager.find(Employee.class, id);
	   if (employee!=null) {
		   entityTransaction.begin();
		   entityManager.remove(employee);
		   entityTransaction.commit();
		   return true;
	   }
	   return false;
	}
	public Employee updateEmployee(int id) {
		Employee employee=entityManager.find(Employee.class, id);
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return employee;
	}
}
