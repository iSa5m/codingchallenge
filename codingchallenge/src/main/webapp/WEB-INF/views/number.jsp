<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Next Greater Number</title>
</head>
<body>
	<form action="/coding-challenge/nextnumber" method="post">
		<p><font color="red">${responseMessage}</font></p>
		Please enter a number: <input type="text" name="number"/> <input type="submit" value="Submit"/>
	</form>
</body>
</html>