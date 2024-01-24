package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dto.Employee;

@WebServlet("/Login")
public class FetchEmployee extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("emailId");
		String password=req.getParameter("password");
		
		
		Employee employee=new Employee();
		employee.setEmailId(email);
		employee.setPassword(password);
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee dbEmployee=employeeDao.getEmpByEmail(email);
		
		if (dbEmployee.getPassword().equals(password)) {
			
			List<Employee> employees=employeeDao.getAllEmployees();
			req.setAttribute("emp", employees);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
