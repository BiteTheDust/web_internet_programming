package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.Tutor;

@WebServlet("/midterm/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Search() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Tutor> entries = new ArrayList<Tutor>();
		// stored the data somewhere that can be accessed by this servlet
		// and other servlets.
		getServletContext().setAttribute("entries", entries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the data
		@SuppressWarnings("unchecked")
		List<Tutor> entries = (List<Tutor>) getServletContext().getAttribute("entries");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Tutor App</title></head><body>");
		out.println("<h1>Welcome to the Tutor App! Please search for a tutor.</h1>");
		// search function
		out.println("<form action=Search method=GET align=center>"
				+ "<input name='query' type='text' id='st-search-input' class='st-search-input search-field' />"
				+ "<input value='Search' type='submit'>" + "</form>");
		String query = request.getParameter("query");
		out.println("");
		out.println("<table border='1' class='table table-striped' align=center>");
		out.println("<tr><th>Full Name</th><th>E-Mail</th><th>Courses</th></tr>");
		for (Tutor entry : entries) {
			// Check if search query is null or empty
			if (query != null && !query.trim().isEmpty()) {

				// Search if search query is in name or message, print if it present
				if (entry.getfirstName().toLowerCase().contains(query.toLowerCase())
						|| entry.getlastName().toLowerCase().contains(query.toLowerCase())
						|| entry.getCourses().toLowerCase().contains(query.toLowerCase())) {

					out.println("<tr><td>" + entry.getfirstName() + " " + entry.getlastName() + "</td><td>"
							+ entry.getCourses() + "</td></tr>");
				}
			} else { // In case if search query is empty then return all results
				out.println("<tr><td>" + entry.getfirstName() + " " + entry.getlastName() + "</td><td>"+ entry.getEmail() +"</td><td>"
						+ entry.getCourses() + "</td></tr>");
			}
		}

		out.println("</table>");

		out.println("<p>Are you a tutor? <a href='Registration'>Register here!</a></p>");
		out.println("<p>Are you an admin? <a href='Administration'>Make edits!</a></p>");
		
		out.println("<p><b>**PLEASE READ** This page has a bug. Please go to the 'admin' hyperlink and then click on the 'back to search' hyperlink to use the program as intended</b></p>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
