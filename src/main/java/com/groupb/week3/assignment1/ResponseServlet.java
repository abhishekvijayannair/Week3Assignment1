package com.groupb.week3.assignment1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResponseServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//student name and scores
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("user");
		
		out.print("Welcome " + username + " !!!");
		out.print("Please enter below details:");
		
		String htmlResponse = "<html>";
		htmlResponse += "<h3>Please enter below details: </h3><br>";   
		
		htmlResponse += "<form action='GradeSchemeServlet' method='post'>";
		htmlResponse += "Student Name <input type='text' name='studentname'><br>";
		htmlResponse += "<h3>Please enter scores: </h3><br/>";  
		htmlResponse += "CSD3354 <input type='number' name='sub1'><br>";
		htmlResponse += "CSD4464 <input type='number' name='sub2'><br>";
		htmlResponse += "CSD4203 <input type='number' name='sub3'><br>";
		htmlResponse += "CSD3183 <input type='number' name='sub4'><br>";
		htmlResponse += "CSD3313 <input type='number' name='sub5'><br>";
		htmlResponse += "<input type='submit' value='go'><br>";
		htmlResponse += "</form>";
		htmlResponse += "</html>";
		
		out.println(htmlResponse);
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
 
	}

}
