package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.Tutor;

@WebServlet("/midterm/Registration")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	int idSeed = 100;
	public Registration() 
	{
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Registration Page</title></head><body>");

		out.println("<form action='Registration' method='post'>");
		out.println("First Name: <input type='text' name='firstName' /> <br />");
		out.println("Last Name: <input type='text' name='lastName' /> <br />");
		out.println("Email: <input type='text' name='email' /> <br />");
		out.println("Courses: <input type='text' name='courses' /> <br />");
		out.println("<input type='submit' name='add' value='Add' /> <br />");
		out.println("</form>");
		out.println("<p><b>*Couldn't get the error message to appear, but app stops invalid input*</b></p>");
		out.println("</body></html>");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the user input
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String courses = request.getParameter("courses");
		
		if (((request.getParameter("firstName")!="") || (request.getParameter("lastName")!="") || (request.getParameter("email")!="") || (request.getParameter("courses")!="")) && (request.getParameter("firstName")!="") && (request.getParameter("lastName")!="") && (request.getParameter("email")!="") && (request.getParameter("courses")!="")  )
		{
			// create a new Tutor entry
			Tutor entry = new Tutor(idSeed++, firstName, lastName, email, courses);

			// add the new entry to the Search page
			List<Tutor> entries = (List<Tutor>) getServletContext().getAttribute("entries");
			entries.add(entry);

			// send the user back to the guest book page
			response.sendRedirect("Search");
			// response.sendRedirect( "Search" );
			doGet(request, response);
		}
		else {
			response.sendRedirect("Registration");
		}
	}

}
