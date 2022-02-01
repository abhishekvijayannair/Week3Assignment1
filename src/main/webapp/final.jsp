<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.groupb.week3.assignment1.model.StudentModel"%>
<!-- Page Created By - Kevin Paul 31/01/2022 - Render page for final grade scheme information of all the users-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
<img id="college-logo" src="https://www.lambtoncollege.ca/uploadedImages/LambtonCollege/Content/About_Us/Media/Vertical_FullColour.jpg">
<h1 class="display-1">Student Grade Information</h1>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Student Name</th>
				<th scope="col">CSD3354</th>
				<th scope="col">CSD4464</th>
				<th scope="col">CSD4203</th>
				<th scope="col">CSD3183</th>
				<th scope="col">CSD3313</th>
				<th scope="col">Max Mark</th>
				<th scope="col">Min Mark</th>
				<th scope="col">Grade</th>
				<th scope="col">Grade Point</th>
			</tr>
		</thead>
		<tbody>
			<%
			int counter = 1;
			List<StudentModel> studentDataList = (List<StudentModel>) session.getAttribute("studentData");
			for (StudentModel student : studentDataList) {
			%>
			<tr>
				<th scope="row">
					<%=
						counter++
					%>
				</th>
				<td>
					<%=
					student.getsName()
					%>
				</td>
				<td>
					<%=
					student.getSubject1()
					%>
				</td>
				<td>
					<%=
					student.getSubject2()
					%>
				</td>
				<td>
					<%=
					student.getSubject3()
					%>
				</td>
				<td>
					<%=
					student.getSubject4()
					%>
				</td>
				<td>
					<%=
					student.getSubject5()
					%>
				</td>
				<td>
					<%=
					student.getMaxValue()
					%>
				</td>
				<td>
					<%=
					student.getMinValue()
					%>
				</td>
				<td>
					<%=
					student.getGrade()
					%>
				</td>
				<td>
					<%=
					student.getGradePoint()
					%>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<form action="ResponseServlet" method="POST">
		<button class="btn btn-info" type="submit">Previous Page</button>
	</form>
</body>
</html>