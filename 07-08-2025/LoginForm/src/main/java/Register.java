import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/register")
public class Register extends HttpServlet  {


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


            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String city = req.getParameter("city");
            String gender = req.getParameter("gender");

           if(gender.equals("male")){
               gender = "Male";
           }
           else {
               gender = "Female";
           }

            String emailExistsQuery = "Select * from users where email = ?";

            PreparedStatement st = conn.prepareStatement(emailExistsQuery);
            st.setString(1,email);
            ResultSet rs = st.executeQuery();

            if(rs.next()){

                out.println("<h2 style='color : red'>A User with this email already exists.Try again with new Email.</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/register.html");
                rd.include(req,resp);
                return;

            }
            String insertSQL = "INSERT INTO users(name, email, password, gender,city) " +
                    "VALUES(?, ?, ?, ?,?)";
            PreparedStatement pst = conn.prepareStatement(insertSQL);
            pst.setString(1,name);
            pst.setString(2,email);
            pst.setString(3,password);
            pst.setString(4,gender);
            pst.setString(5,city);


            int insertSuccess = pst.executeUpdate();

            if(insertSuccess == 1)

            {
                out.println("<h2 style='color : green;'>You have successfully registered. Login now to enjoy the app. </h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/");
                rd.include(req,resp);
                return;
            }

            else{

                out.println("<h2 style='color : red;'>Something went wrong</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("/register.html");
                rd.include(req,resp);

            }



        } catch (Exception e) {
            out.println("<h2 style='color : red'>Something went wrong " + e.getMessage() + e.getCause() +"</h2>");
            RequestDispatcher rd = req.getRequestDispatcher("/register.html");
            rd.include(req,resp);
      ;
        }


    }
}
