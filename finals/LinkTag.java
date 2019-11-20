package finals;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LinkTag extends SimpleTagSupport {
	LinkEntry link;
	
    public LinkTag()
    {
    	link = null;
    }
    
    public void setVar(LinkEntry link)
    {
    	this.link = link;
    }
    
    @Override
    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        out.println("<div class=\"link link-container\">");
        out.println("<span class=\"count link-point\">" + link.getCount() + "</span>");
        out.println("<div class=\"link-content\">");
        out.println("<a href=\"" + link.getLink() + "\"><span style=\"color:#000000; font-weight:bold; font-size:2vw;\">" + link.getTitle() + "</span></a>");
        out.println("<br>");
        out.println("<span style=\"color:#a0a0a0; vertical-align:top;\">(" + link.getLink() + ")</span>");
        out.println("<br>");
        out.println("<br>");
        out.println("<a href=\"Upvote?id=" + link.getId() + "\" class=\"btn btn-success btn-sm\"><span class=\"glyphicon glyphicon-arrow-up\"></span> " + link.getUpvote() + " Upvote(s)</a>");
        out.println("<a href=\"Downvote?id=" + link.getId() + "\" class=\"btn btn-danger btn-sm\"><span class=\"glyphicon glyphicon-arrow-down\"></span> " + link.getDownvote() + " Downvote(s)</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("<br>");
    }

}
