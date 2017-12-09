<!DOCTYPE html>
<%@ page import = "com.virtualpairprogrammers.domain.User" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Utenti</title>
    </head>
    <body>
      <%

        String mode = (String)session.getAttribute("mode");
        List<User> users = (List<User>)session.getAttribute("users");
      %>
        <h1>Lista utenti registrati:</h1>

        <%
        switch (mode) {
         case "all": {

             for (User user: users)
             {
        %>
               <%= user %>


        <%   }
          break;
         }
        }
        %>


    </body>


</html>