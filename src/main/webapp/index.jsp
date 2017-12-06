<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

<!-- <h1>Contrader Framework</h1>
     <p><i>Opzioni disponibili</i></p>
     <form action="LoginServlet" method="get"><br>
     <i>Registrazione nuovo utente</i><input type="radio" name="scelta" value="1"><br>
     <i>Accedi</i><input type="radio" name="scelta" value="2"><br>
     <input type="submit" name="submit" value="PROSEGUI"><br> -->


<%
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet", "HelloWorld");
%>
<form action = "MainDispatcherServlet" method = "POST">
    UserName <input type = "text" name "username">
    Password <input type = "password" name "password">
    <input type = "submit" value = "submit">
</form>

</body>
</html>