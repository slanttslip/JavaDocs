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
public class HttpServletInclude extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/included");
        requestDispatcher.include(req,resp);
        resp.getWriter().write("<h1> asat e incldue</h1>");
    }
}
