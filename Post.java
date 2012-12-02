
package socialnetwork;

public class Post {
	
	public Post(String newContent, int newUserID, int time, String[] htags, String[] aTags){
		content = newContent;
		userID = newUserID;
		timestamp = time;
		hashtags = htags;
		atTags = aTags;
		
	}
	
	public void setHashTags(String pullFrom){
//		String[] newhashtags = 
	}
	
	public void setAtTags(String pullFrom){
		
	}
	

	
	String content;
	int userID;
	String[] hashtags;
	String[] atTags;
	int timestamp;
	boolean pub;
	
}
