package com.groupb.week3.assignment1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GradeSchemeServlet
 */
@WebServlet("/GradeSchemeServlet")
public class GradeSchemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeSchemeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("studentName", request.getParameter("studentname"));
		session.setMaxInactiveInterval(30 * 60);
		
		//get scores from user request
		response.setContentType("text/html");
		float scores[] = new float[5];
		scores[0] = Float.parseFloat(request.getParameter("sub1")); 
		scores[1] = Float.parseFloat(request.getParameter("sub2")); 
		scores[2] = Float.parseFloat(request.getParameter("sub3")); 
		scores[3] = Float.parseFloat(request.getParameter("sub4")); 
		scores[4] = Float.parseFloat(request.getParameter("sub5")); 
		
		
		float minValue = scores[0];
		float maxValue = scores[0];
		float sum = 0;
		float avg = 0;
		
		//to find min, max, avg of scores
        for(int i=0;i<scores.length;i++){
            if(scores[i] > maxValue){
                maxValue = scores[i];
            }
        }
        
        for(int i=0;i<scores.length;i++){
            if(scores[i] < minValue){
            	minValue = scores[i];
            }
        }
        
        for(int i=0;i<scores.length;i++){
           sum += scores[i];
        }
        
        avg = sum/scores.length;
        
        //Grade scheme
        String grade = null;
        double gradePoint = 0;
        
        if (avg <= 100 && avg >= 94)
        {
        	grade = "A+";
        	gradePoint = 4;
        }
        else if (avg <= 93 && avg >= 87) {
        	grade = "A";
        	gradePoint = 3.7;
        }
        else if (avg <= 86 && avg >= 80) {
        	grade = "A-";
        	gradePoint = 3.5;
        }
        else if (avg <= 79 && avg >= 77) {
        	grade = "B+";
        	gradePoint = 3.2;
        }
        else if (avg <= 76 && avg >= 73) {
        	grade = "B";
        	gradePoint = 3.0;
        }
        else if (avg <= 70 && avg >= 72) {
        	grade = "B-";
        	gradePoint = 2.7;
        }
        else if (avg <= 67 && avg >= 69) {
        	grade = "C+";
        	gradePoint = 2.3;
        }
        else if (avg <= 66 && avg >= 63) {
        	grade = "C";
        	gradePoint = 2.0;
        }
        else if (avg <= 62 && avg >= 60) {
        	grade = "C-";
        	gradePoint = 1.7;
        }
        else if (avg <= 59 && avg >= 50) {
        	grade = "D";
        	gradePoint = 1.0;
        }
        else if (avg <= 0 && avg >= 49) {
        	grade = "F";
        	gradePoint = 0.0;
        }
        
        PrintWriter out = response.getWriter();
        
        out.print("<table border='1'><tr><th>Student Name</th><th>Average Score</th>"
        		+ "<th>Grade</th><th>Grade Point</th></tr>");
        out.print("<tr><td>" + (String)session.getAttribute("studentName") + "</td>");
        out.print("<td>" + avg + "</td>");
        out.print("<td>" + grade + "</td>");
        out.print("<td>" + gradePoint + "</td></tr></table>");
        
        out.close();
	}

}
