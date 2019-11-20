package midterm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import midterm.Tutor;

@WebServlet("/midterm/DeleteTutor")
public class DeleteTutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteTutor() {
        super();
    }


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   Integer id = Integer.valueOf( request.getParameter( "id" ) );
	        List<Tutor> entries = (List<Tutor>) getServletContext().getAttribute(
	            "entries" );
	        for( Tutor entry : entries )
	            if( entry.getId().equals( id ) )
	            {
	                entries.remove( entry );
	                break;
	            }

	        response.sendRedirect( "Administration" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
