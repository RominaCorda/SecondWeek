package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    private LoginService loginService;
    private String result = "";

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String firstName = (String) session.getAttribute("firstName");
        String role = (String) session.getAttribute("role");

        if ((request != null) && (role == null) && (firstName == null)) {//Controlla se si è loggatti
            //Legge i dati inseriti da input

            String userName = request.getParameter("user");
            String password = request.getParameter("pwd");

            result = loginService.login(userName, password);
            if (result != null) {
                String[] part = result.split(":");
                session.setAttribute("firstname", part[0]);
                session.setAttribute("role", part[1]);
                //Manca chiamata alla JSP Homeview dove è presente il menu dell'user o dell'admin
                session.setAttribute("view", "homeMenu.jsp");
                MainDispatcherServlet.getInstance().callView(request, response);
            } else {
                //Il login non è andato a buon fine e si deve ricaricare la JSP che permette di rimettere}
                session.setAttribute("view", "LoginMenu.jsp");
                MainDispatcherServlet.getInstance().callView(request, response);
            }
        } else {//Se si è già loggati si va direttamente al menù
            //Manca chiamata alla JSP Homeview dove è presente il menu dell'user o dell'admin
            session.setAttribute("view", "homeMenu.jsp");
            MainDispatcherServlet.getInstance().callView(request, response);
        }
    }


}
