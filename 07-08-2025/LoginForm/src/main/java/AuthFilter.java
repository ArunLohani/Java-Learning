import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebFilter("/home.jsp")
public class AuthFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp , FilterChain chain) throws ServletException, IOException {



    HttpServletRequest request  =(HttpServletRequest) req;
    HttpSession session = request.getSession();

    boolean loggedIn = session!=null && session.getAttribute("user_name")!=null;


    if(loggedIn){
        chain.doFilter(req,resp);
    }
    else {
        RequestDispatcher rd = request.getRequestDispatcher("login.html");
        rd.forward(req,resp);
    }




    }
}
