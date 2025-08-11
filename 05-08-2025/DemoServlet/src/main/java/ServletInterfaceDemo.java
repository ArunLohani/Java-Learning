import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servlet")
public class ServletInterfaceDemo implements Servlet {

    ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("Servlet is Starting ..........");

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        out.println("Servlet Interface");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is Closing ..........");

    }

    @Override
    public String getServletInfo() {
        return "This Servlet is created by Arun.";
    }
}
