package finals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Final/Articles")
public class Articles extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
            String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs3220stu74";
			String username = "cs3220stu74";
			String password = "*****"; //edited out password
			
			String[] dbinfo = {url, username, password};
            
			getServletContext().setAttribute("dbinfo", dbinfo);
			
			Connection c = DriverManager.getConnection(dbinfo[0], dbinfo[1], dbinfo[2]);
            c.createStatement().execute("CREATE TABLE IF NOT EXISTS articles (id INT NOT NULL AUTO_INCREMENT, title VARCHAR(256) NOT NULL, link VARCHAR(256) NOT NULL, upvote INT, downvote INT, count INT, PRIMARY KEY (id))");
            
            c.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] dbinfo = (String[])getServletContext().getAttribute("dbinfo");
			Connection c = DriverManager.getConnection(dbinfo[0], dbinfo[1], dbinfo[2]);
			ResultSet rs = c.createStatement().executeQuery("SELECT * FROM articles ORDER BY count DESC, title ASC");
			
			List<LinkEntry> links = new ArrayList<LinkEntry>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String link = rs.getString("link");
				int upvote = rs.getInt("upvote");
				int downvote = rs.getInt("downvote");
				int count = rs.getInt("count");
				
				links.add(new LinkEntry(id, title, link, upvote, downvote, count));
			}
			
			c.close();
			request.setAttribute("links", links);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
		
		request.getRequestDispatcher("/WEB-INF/List.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

