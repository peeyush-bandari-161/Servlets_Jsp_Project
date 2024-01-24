package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dto.Employee;

@WebServlet("/update")
public class UpdateEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("update.jsp");
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
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee saveEmp=employeeDao.updateEmployee(id);
		if (saveEmp!=null) {
			req.setAttribute("message", "Successfully Updated Proceed to Login");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}
