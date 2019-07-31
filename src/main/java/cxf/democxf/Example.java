package cxf.democxf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * example of using annotation to create a servlet
 * 
 * it is required to add @ServletComponentScan for the spring boot bootstrap
 *
 */
@WebServlet(
	name = "AnnotationExample",
	description = "Example Servlet Using Annotations",
	urlPatterns = {"/example"}
)
public class Example extends HttpServlet {  
  
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
  
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World!</p>");
    }
}