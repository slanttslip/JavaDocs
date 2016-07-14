package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Adrian.Calancea on 7/13/16.
 */
public class HttpSessionZTH extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        if(user.equals("admin")&&pass.equals("admin")){
            resp.getWriter().write("<p>Welcome back Username:"+ user+"</p>"+req.getSession());
        }
        else{
           RequestDispatcher requestDispatcher=req.getRequestDispatcher("views/loginFail.jsp");
            /*req.setAttribute("session", req.getSession());
            req.setAttribute("user", user);*/
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("session", req.getSession());
            //resp.sendRedirect("views/loginFail.jsp");

            requestDispatcher.forward(req,resp);

        }

    }
}
