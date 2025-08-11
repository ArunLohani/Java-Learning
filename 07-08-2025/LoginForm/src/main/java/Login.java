import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet  {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url="jdbc:postgresql://localhost:5432/authdb";
        String user ="postgres";
        String pass = "argusadmin";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try(Connection conn = DriverManager.getConnection(url,user,pass)){


            String email = req.getParameter("email");
            String password = req.getParameter("password");


            String emailExistsQuery = "Select email , password , name from users where email = ?";

            PreparedStatement st = conn.prepareStatement(emailExistsQuery);
            st.setString(1,email);
            ResultSet rs = st.executeQuery();

            if(!rs.next()){

                out.println("<h2 style='color : red'>Email not exists.</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req,resp);
                return;

            }


            if(!rs.getString(2).equals(password)){
                out.println("<h2 style='color : red'>Incorrect Password.</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req,resp);
                return;
            }

            String name = rs.getString(3);
            HttpSession oldSession = req.getSession();
            if(oldSession!=null) oldSession.invalidate();
            HttpSession newSession = req.getSession();
            newSession.setAttribute("user_name",name);
            newSession.setAttribute("user_email",email);


            resp.sendRedirect("home.jsp");


        } catch (Exception e) {
            out.println("<h2 style='color : red'>Something went wrong " + e.getMessage() + e.getCause() +"</h2>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req,resp);
            ;
        }


    }
}
