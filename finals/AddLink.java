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

@WebServlet(urlPatterns = "/Final/AddLink")
public class AddLink extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	if (request.getParameter("title") != null && request.getParameter("title").trim().length() > 0 && //input for the title
    		request.getParameter("url") != null && request.getParameter("url").trim().length() > 0) //input for the url
    	{
    		try //attempt to put the entry from parameter into db
    		{
    			String[] dbinfo = (String[])getServletContext().getAttribute("dbinfo");
    			Connection c = DriverManager.getConnection(dbinfo[0], dbinfo[1], dbinfo[2]);
    			
    			PreparedStatement ps = c.prepareStatement("INSERT INTO articles (title, link, upvote, downvote) VALUES (?, ?, 0, 0)");
    			ps.setString(1, request.getParameter("title").trim());
    			ps.setString(2, request.getParameter("url").trim());
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
