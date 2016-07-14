package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Adrian.Calancea on 7/13/16.
 */
public class InfoHttpServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/html");
        Enumeration list=req.getHeaderNames();

        String html="<table border=1 <tr><th>Header NAME</th><th>Header values</th></tr>";
        while(list.hasMoreElements()){
            String value=list.nextElement().toString();
        html+="<tr><td> ["+value+"] </td> <td> "+req.getHeader(value)+"</td></tr>";
        }
        html+=" </table>";

        html+="<br> <h1>"+req.getMethod()+"</h1>";
        html+="<br> <h2>"+req.getQueryString()+"</h1>";

        html+=" <br><table border=1>";
       Cookie[] cookie=req.getCookies();
        if (cookie!=null){
        for (int i=0;i<cookie.length;i++){

            html+="<tr><td> ["+cookie[i].getName()+"] </td><td>"+cookie[i].getValue()+"</tr>";
        }

        html+=" </table><br>";}
        else{
            html+="<br> <h1> WTF </h1>";
        }


       Enumeration en=req.getParameterNames();
        html+=" <br><table border=1>";
        while (en.hasMoreElements()){
            String value=en.nextElement().toString();
            html+="<tr><td> ["+value+"] </td><td>"+req.getParameter(value).toString()+"</td></tr>";
        }
        html+=" </table>";



        resp.getWriter().write(html);
    }

}
