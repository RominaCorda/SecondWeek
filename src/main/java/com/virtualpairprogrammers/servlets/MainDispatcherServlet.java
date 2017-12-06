package com.virtualpairprogrammers.servlets;




import com.virtualpairprogrammers.utils.ReflectionUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class MainDispatcherServlet extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        //processRequest(request, response);
        //String test = (String)request.getParameter("testingText");
        //String methodToCall = (String)request.getParameter("method");
        Method method;
        HttpSession session = request.getSession(true);
        String methodToCall = (String)session.getAttribute("method");
        try {
            out.println(methodToCall);
            method = this.getClass().getMethod(methodToCall, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, (HttpServletRequest)request, (HttpServletResponse)response);
            //test(request, response);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void callAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("I'm here!!!!");
        HttpSession session = request.getSession(true);
        ServletCustom oggettoServlet = (ServletCustom) ReflectionUtils.instantiateClass("com.virtualpairprogrammers.servlets." + session.getAttribute("servlet") + "Servlet");

        try {

            Method metodo = oggettoServlet.getClass().getMethod("service", HttpServletRequest.class, HttpServletResponse.class);
            metodo.invoke( oggettoServlet, (HttpServletRequest) request, (HttpServletResponse)response);
        } catch (Throwable e) {
            //GestoreEccezioni.getInstance().gestisciEccezione(e);
            e.printStackTrace();
        }
    }

    public void callView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("I'm here!!!!");
        response.sendRedirect("risultato.jsp");
    }

}
