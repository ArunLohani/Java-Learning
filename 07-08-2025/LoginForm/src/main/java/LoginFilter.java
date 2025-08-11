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

@WebFilter({"/login.html" , "/login" , "/register.html","/register","/index.html"})
public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp , FilterChain chain) throws ServletException, IOException {



        HttpServletRequest request  =(HttpServletRequest) req;
        HttpSession session = request.getSession();


        HttpServletResponse response  =(HttpServletResponse) resp;


        boolean loggedIn = session!=null && session.getAttribute("user_name")!=null;


        if(loggedIn){
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        }
        else {
            chain.doFilter(req,resp);
        }




    }
}
