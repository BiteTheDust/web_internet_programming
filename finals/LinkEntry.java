package finals;

public class LinkEntry {
	private int id;
	private String title;
	private String link;
	private int upvote;
	private int downvote;
	private int count;
	
	public LinkEntry(int id, String title, String link, int upvote, int downvote, int count) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.upvote = upvote;
		this.downvote = downvote;
		this.count = count;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public int getUpvote() {
		return upvote;
	}
	
	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}
	
	public int getDownvote() {
		return downvote;
	}
	
	public void setDownvote(int downvote) {
		this.downvote = downvote;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
