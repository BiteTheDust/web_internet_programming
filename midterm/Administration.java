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

@WebServlet("/midterm/Administration")
public class Administration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Administration() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Tutor> entries = new ArrayList<Tutor>();
		getServletContext().setAttribute("entries", entries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Tutor> entries = (List<Tutor>) getServletContext().getAttribute("entries");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Tutor App</title></head><body>");
		out.println("<h1>Welcome Admin! Delete a Tutor.</h1>");
		out.println("<table border='1'>");
		out.println(
				"<tr><th>Full Name</th><th>Email</th><th>Courses</th><th><br /></th></tr>");

		for (Tutor entry : entries) {
			out.println("<tr><td>" + entry.getfirstName() + " "
					+ entry.getlastName() + "</td><td>" + entry.getEmail() + "</td><td>" + entry.getCourses()
					+ "</td><td><a href='DeleteTutor?id=" + entry.getId() + "'>Delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("<p><a href='Search'>Back to Search</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
