package com.groupb.week3.assignment1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupb.week3.assignment1.model.UserModel;

/**
 * Servlet implementation class ValidationServlet
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

			Cookie userCookie = new Cookie("user", user.getUsername().toUpperCase());
			userCookie.setMaxAge(30 * 60);
			response.addCookie(userCookie);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ResponseServlet");
			requestDispatcher.forward(request, response);
		}
	}

}
