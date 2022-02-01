package com.groupb.week3.assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupb.week3.assignment1.model.StudentModel;

/**
 * Servlet implementation class GradeSchemeServlet
 * 
 * @Date - 30/01/2022
 * @Author - Suchitra
 * @Description - This Servlet calculates the grade of the student and minimum
 *              and maximum value of the grades and regarding grade points based
 *              on lambton data.
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		calculateGradeOfStudent(request, response);
		response.sendRedirect("final.jsp");
	}

	@SuppressWarnings("unchecked")
	public void calculateGradeOfStudent(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		// get scores from user request
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

		// to find min, max, avg of scores
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > maxValue) {
				maxValue = scores[i];
			}
		}

		for (int i = 0; i < scores.length; i++) {
			if (scores[i] < minValue) {
				minValue = scores[i];
			}
		}

		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}

		avg = sum / scores.length;

		// Grade scheme
		String grade = null;
		double gradePoint = 0;

		if (avg <= 100 && avg >= 94) {
			grade = "A+";
			gradePoint = 4;
		} else if (avg < 94 && avg >= 87) {
			grade = "A";
			gradePoint = 3.7;
		} else if (avg < 87 && avg >= 80) {
			grade = "A-";
			gradePoint = 3.5;
		} else if (avg < 80 && avg >= 77) {
			grade = "B+";
			gradePoint = 3.2;
		} else if (avg < 77 && avg >= 73) {
			grade = "B";
			gradePoint = 3.0;
		} else if (avg < 73 && avg >= 72) {
			grade = "B-";
			gradePoint = 2.7;
		} else if (avg < 72 && avg >= 69) {
			grade = "C+";
			gradePoint = 2.3;
		} else if (avg < 69 && avg >= 63) {
			grade = "C";
			gradePoint = 2.0;
		} else if (avg < 63 && avg >= 60) {
			grade = "C-";
			gradePoint = 1.7;
		} else if (avg < 60 && avg >= 50) {
			grade = "D";
			gradePoint = 1.0;
		} else if (avg < 50 && avg >= 0) {
			grade = "F";
			gradePoint = 0.0;
		}

		StudentModel model = new StudentModel();
		model.setsName(request.getParameter("studentname"));
		model.setSubject1(String.valueOf(scores[0]));
		model.setSubject2(String.valueOf(scores[1]));
		model.setSubject3(String.valueOf(scores[2]));
		model.setSubject4(String.valueOf(scores[3]));
		model.setSubject5(String.valueOf(scores[4]));
		model.setMaxValue(String.valueOf(maxValue));
		model.setMinValue(String.valueOf(minValue));
		model.setAverage(String.valueOf(avg));
		model.setGrade(String.valueOf(grade));
		model.setGradePoint(String.valueOf(gradePoint));

		@SuppressWarnings("unchecked")
		List<StudentModel> studentDataList = (List<StudentModel>) session.getAttribute("studentData");
		studentDataList.add(model);
		session.setAttribute("studentData", studentDataList);

	}

}
