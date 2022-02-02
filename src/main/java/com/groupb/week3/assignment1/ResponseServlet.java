package com.groupb.week3.assignment1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResponseServlet
 * 
 * @Date - 30/01/2022
 * 
 * @Author - Sanjay Raj
 * @Description - Create servlet web page for adding student information to the
 *              grade system and the calculation is done through
 *              gradeschemeservlet
 * 
 */
@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseServlet() {
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

		// student name and scores
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);

		if (session.getAttribute("user") != null && (String) session.getAttribute("user") != "") {
			String username = (String) session.getAttribute("user");
			String userCookie = "";
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("user")) {
					userCookie = cookies[i].getValue();
				}
			}
//			Optional<String> cookieValue = Arrays.stream(request.getCookies()).filter(c -> "user".equals(c.getName()))
//					.map(Cookie::getValue).findAny();
			out.print("<html><body><b>Welcome " + userCookie + " to Student Grade Information System</b>");
			out.print("<form action='LogoutServlet' method='GET'><button type='submit'>LOGOUT</button></form>");

			String htmlResponse = "";
			htmlResponse += "<h5>Please enter below details: </h5>";
			htmlResponse += "<form action='GradeSchemeServlet' method='post'>";
			htmlResponse += "Student Name <input type='text' name='studentname'><br>";
			htmlResponse += "<h5>Please enter scores: </h5>";
			htmlResponse += "<table>";
			htmlResponse += "<tr><td>CSD3354 Web Applications Using C# .NET</td><td><input type='number' name='sub1'></td></tr>";
			htmlResponse += "<tr><td>CSD4464 Programming Java EE</td><td><input type='number' name='sub2'></td></tr>";
			htmlResponse += "<tr><td>CSD4203 Database Programming</td><td><input type='number' name='sub3'></td></tr>";
			htmlResponse += "<tr><td>CSD3183 Mobile Development</td><td><input type='number' name='sub4'></td></tr>";
			htmlResponse += "<tr><td>CSD3313 Web Technologies III</td><td><input type='number' name='sub5'></td></tr>";
			htmlResponse += "<tr><td><input type='submit' value='ADD STUDENT INFORMAION'></td><td></td></tr></table>";
			htmlResponse += "</form>";
			htmlResponse += "</br></br></br></br>";
			htmlResponse += "<p>More features :</p>";
			htmlResponse += "<form action='final.jsp' method='POST'><button type='submit'>SHOW STUDENT INFORMATION</button></form>";
			htmlResponse += "</body></html>";

			out.println(htmlResponse);

			out.close();

		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LogoutServlet");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
