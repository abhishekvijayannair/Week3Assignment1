<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background: #d2bf37;
}

#login_head {
	font-family: serif;
	font-size: 26px;
	color: White;
	text-align: center;
	background: #4169e1;
}

#bodydiv {
	text-align: center;
	margin-top: 100px;
	padding: 20px;
	background-color: #4169e1;
}

.child-div {
	margin-top: 20px;
}

label {
	color: white;
}

footer {
	font-family: monospace;
	color: #4169e1;
	text-align: center;
	animation: blinker 1s linear infinite;
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 2.5rem;
	text-shadow: 0.75px 0px grey;
}

@keyframes blinker {
  50% {
    opacity: 0;
  }
}
</style>
</head>
<body>
	<header id="login_head"> Login </header>
	<main id="bodydiv">
		<form action="ValidationServlet" method="POST">
			<div class="child-div">
				<label for="username">Username : </label><input type="text"
					id="username" name="username"><br>
			</div>
			<div class="child-div">
				<label for="password">Password : </label><input type="password"
					id="password" name="password"><br>
			</div>
			<div class="child-div">
				<button>Login</button>
			</div>
		</form>
	</main>
	<footer>Created by: Group B - Abhishek, Sanjay, Kevin, Jith, Suchitra</footer>
</body>
</html>