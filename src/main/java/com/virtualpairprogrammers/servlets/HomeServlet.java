package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    public void doPost (HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException,IOException
    {

        LoginService loginService= new LoginService();
        String result;
        HttpSession sess=request.getSession(true);
        String firstName= (String) sess.getAttribute("firstName");
        String role= (String) sess.getAttribute("role");

        if((firstName==null) && (role==null)) {//Controlla se si è loggatti
            //Legge i dati inseriti da input
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            result = loginService.login(userName, password);
            if (result != null) {
                String[] part = result.split(":");
                sess.setAttribute("firstname", part[0]);
                sess.setAttribute("role", part[1]);
                //Manca chiamata alla JSP Homeview dove è presente il menu dell'user o dell'admin
                response.sendRedirect("Home.jsp");
            } else {
                //Il login non è andato a buon fine e si deve ricaricare la JSP che permette di rimettere}
                response.sendRedirect("Login.jsp");
            }
        }else{//Se si è già loggati si va direttamente al menù
            //Manca chiamata alla JSP Homeview dove è presente il menu dell'user o dell'admin
            response.sendRedirect("Home.jsp");
        }
    }

}
