package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.User;
import com.virtualpairprogrammers.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {



    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer choice = (Integer) session.getAttribute("choice");
        String role = (String) session.getAttribute("role");
        UserService userService = UserService.getService();

        switch (role) {

            case "admin": {
                switch (choice) {
                    case 3: {
                        List<User> users = userService.getAllUser();
                        session.setAttribute("view", "UserView.jsp");
                        session.setAttribute("mode", "all");
                        session.setAttribute("users", users);
                        MainDispatcherServlet.getInstance(request).callView(request, response);
                        break;
                    }
                }
            }

            case "user": {
                break;
            }

        }


    }


}
