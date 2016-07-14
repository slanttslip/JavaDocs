package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Adrian.Calancea on 7/13/16.
 */
public class HeadersLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        Enumeration list=((HttpServletRequest)servletRequest).getHeaderNames();
        while (list.hasMoreElements()){
            String value=list.nextElement().toString();
            LogFileWriter.logHeader(value,((HttpServletRequest)servletRequest).getHeader(value));
        }
    }

    @Override
    public void destroy() {

    }
}
