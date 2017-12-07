package com.virtualpairprogrammers.servlets;




import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.utils.ReflectionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

public class MainDispatcherServlet extends HttpServlet
{
    private static MainDispatcherServlet instance;

    public static MainDispatcherServlet getInstance() {
        if (instance == null) {
            instance = new MainDispatcherServlet();
        }
        return instance;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Method method;
        HttpSession session = request.getSession(true);
        String methodToCall = (String)session.getAttribute("method");
        try
        {
            method = this.getClass().getMethod(methodToCall, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, (HttpServletRequest)request, (HttpServletResponse)response);
        }
        catch (Throwable e) {GestoreEccezioni.getInstance().gestisciEccezione(e);}
    }

    public void callAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession(true);
        HttpServlet oggettoServlet = (HttpServlet) ReflectionUtils.instantiateClass("com.virtualpairprogrammers.servlets." + session.getAttribute("servlet") + "Servlet");

        try
        {

            Method metodo = oggettoServlet.getClass().getMethod("service", HttpServletRequest.class, HttpServletResponse.class);
            metodo.invoke( oggettoServlet, (HttpServletRequest) request, (HttpServletResponse)response);
        }
        catch (Throwable e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);}
    }

    public void callView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession(true);
        String view = (String)session.getAttribute("view");
        response.sendRedirect(view);
    }

}
