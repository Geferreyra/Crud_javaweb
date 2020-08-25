<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import ="modelo.UsuarioVO"
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type">
<meta charset="ISO-8859-1">
<title> User Logged Successfully</title>
</head>
<body>

<div align="center">
<% UsuarioVO currentUser = (UsuarioVO)session.getAttribute("currentSessionUser");%>
 

Welcome <%=currentUser.getFirstName()+" "+ currentUser.getLastName() %>

</div>



</body>
</html>