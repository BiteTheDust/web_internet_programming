package finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Final/Downvote")
public class Downvote extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	if (request.getParameter("id") != null &&
    		request.getParameter("id").trim().length() > 0)
    	{
    		try
    		{
    			int id = Integer.parseInt(request.getParameter("id").trim());
    			String[] dbinfo = (String[])getServletContext().getAttribute("dbinfo");
    			Connection c = DriverManager.getConnection(dbinfo[0], dbinfo[1], dbinfo[2]);
    			
    			PreparedStatement ps = c.prepareStatement("UPDATE articles SET downvote=downvote+1, count=upvote-downvote WHERE id=?");
    			ps.setInt(1, id);
    			ps.executeUpdate();
    			
    			c.close();
    		}
    		catch( SQLException e )
    		{
    			throw new ServletException( e );
    		}
    	}
    	
    	response.sendRedirect("Articles");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
