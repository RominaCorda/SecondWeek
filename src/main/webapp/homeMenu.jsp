<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU</title>
        <%  String role =((String) session.getAttribute("role"));%>
    </head>
    <body>
     <%
       HttpSession session = request.getSession(true);
               String firstName= (String)  session.getAttribute("firstName");
               out.println(firstName);
     %>
    </body>
</html>