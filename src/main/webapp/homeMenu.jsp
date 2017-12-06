<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU</title>
        <%  String role =((String) session.getAttribute("role"));%>
    </head>
    <body>
        <%if (role.equals("admin")){%>
            <h1>Menu ADMIN</h1>
                <%}else if(role.equals("user")) {%>
                    <h1>Menu USER</h1>
                <%}%>
    </body>
</html>