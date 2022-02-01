package com.groupb.week3.assignment1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupb.week3.assignment1.model.StudentModel;
import com.groupb.week3.assignment1.model.UserModel;

/**
 * Servlet implementation class ValidationServlet
 * 
 * @Date - 30/01/2022
 * @Author - Abhishek
 * @Description - This Servlet validates the username and password provided by
 *              the user and provide entry to the system or redirect back to
 *              login page
 */
@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserModel user = new UserModel("admin", "admin123");

		if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user.getUsername());
			session.setMaxInactiveInterval(30 * 60);
			ArrayList<StudentModel> students = createDefaultStudents();
			session.setAttribute("studentData", students);

			Cookie userCookie = new Cookie("user", user.getUsername().toUpperCase());
			userCookie.setMaxAge(30 * 60);
			response.addCookie(userCookie);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ResponseServlet");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	public ArrayList<StudentModel> createDefaultStudents() {
		StudentModel s1 = new StudentModel("Abhishek V Nair", "90", "92", "91", "91", "86", "90", "A+", "3.8", "92",
				"86");
		StudentModel s2 = new StudentModel("Kevin Paul", "62", "57", "99", "100", "60", "75.6", "A-", "3.0", "100",
				"60");
		StudentModel s3 = new StudentModel("Sanjay Raj", "12", "5", "3", "100", "100", "44", "C", "2.4", "100", "3");
		StudentModel s4 = new StudentModel("Suchitra", "88", "79", "91", "80", "70", "81.6", "A", "3.2", "91", "70");
		StudentModel s5 = new StudentModel("Jith Koshy", "90", "92", "67", "91", "55", "79", "B+", "2.8", "92", "55");

		ArrayList<StudentModel> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);

		return students;
	}

}
