import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class HttpServletDemo extends HttpServlet {

    public void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {



        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();


        out.println("<h1>HttpServletDemo</h1>");
        String title = "Using GET Method to Read Form Data";
        out.println( "<html>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                    "<h1 align = \"center\">" + title + "</h1>\n" +
                    "<ul>\n" +
                        "<li><b>First Name</b>: "
                        +req.getParameter("first_name") + "\n" +
                        "<li><b>Last Name</b>: "
                        +req.getParameter("last_name") + "\n" +
                    "</ul>\n" +
                "</body>" +
                "</html>");


    }


}
