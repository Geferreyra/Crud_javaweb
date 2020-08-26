<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invalid login</title>
</head>
<body>

<center> 
Sorry yo are not registred, please Sing up here!
</center>

<div align="center">
<h3>Registration form</h3>

<form action="SaveServlet" name="singUP" method="post">

<table>
<tr>

<td>
Frist name:
</td>

<td>
<input type="text" name="FirstName" placeholder="Insert first name"> 
</td>
</tr>

<tr>
<td>
Last name:
</td>
<td>
<input type="text" name="LastName" placeholder="Insert last name">
</td>
</tr>

<tr> 
<td>
Email:
</td>

<td>
<input type="text" name="email" placeholder="Example@dxc.com">
</td>
</tr>


<tr> 
<td>
User Name:
</td>

<td>
<input type="text" name="userName" placeholder="Example@dxc.com">
</td>
</tr>



<tr>
<td>
Password:
</td>
<td>
<input type="password" name="pass" placeholder="Insert password">
</td>
</tr>

<tr>
<td>
Confirm password:
</td>

<td>
<input type="password" name="passConfirm" placeholder="Repeat password">
</td>
</tr>

<tr>
<td>
<input type="reset" value="Clean">
</td>

<td>
<input type="submit" value="Sing up">
</td>
</tr>

</table>
</form>

</div>

</body>
</html>