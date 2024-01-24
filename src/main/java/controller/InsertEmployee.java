package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dto.Employee;

@WebServlet("/Signup")
public class InsertEmployee extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("empName");
		int age=Integer.parseInt(req.getParameter("empAge"));
		String address=req.getParameter("empAddress");
		long phno=Long.parseLong(req.getParameter("empPhno"));
		String email=req.getParameter("mailId");
		String password=req.getParameter("password");
		
		Employee employee=new Employee();
		employee.setEmpName(name);
		employee.setEmpAge(age);
		employee.setEmpAddress(address);
		employee.setEmpPhno(phno);
		employee.setEmailId(email);
		employee.setPassword(password);
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee savePoint=employeeDao.insertEmployee(employee);
				
		if (savePoint!=null) {
			
			req.setAttribute("message", "Successfully SignedUp Proceed to Login");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Login.jsp");
			requestDispatcher.forward(req, resp);
			
		}
	}
}
