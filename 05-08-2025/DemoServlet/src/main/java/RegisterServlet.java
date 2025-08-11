import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();


        out.println("<h1>Welcome to our Page</h1>");

        String name = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String email = req.getParameter("user_email");
        String gender = req.getParameter("user_gender");
        String course = req.getParameter("user_course");
        String checked = req.getParameter("condition");


        if(checked != null){

            out.println("<h2> Name : " + name + "</h2>");
            out.println("<h2> Password : " + password + "</h2>");
            out.println("<h2> Email : " + email + "</h2>");
            out.println("<h2> Gender : " + gender + "</h2>");
            out.println("<h2> Course : " + course + "</h2>");


            RequestDispatcher rd = req.getRequestDispatcher("SuccessServlet");
            rd.forward(req,resp);



        }
        else {
            out.println("<h2>You did not agree to T&C</h2>");

            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req,resp);

        }


    }
}
