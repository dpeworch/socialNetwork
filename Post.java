
package socialnetwork;


public class Post {
	
	// this post is for return values, such as when a user searches
	//for a post and no post with that id is found, this empty post is returned.
	public Post(){
		content = "Post not found.";
		postID = -1;
	}
	
	
	public Post(String newContent, int newUserID, int time, String[] htags, String[] aTags, int pID, String visibility){
		content = newContent;
		userID = newUserID;
		timestamp = time;
		hashtags = htags;
		atTags = aTags;
		postID = pID;
		if(visibility.equals("pub")){
			pub = true;
		} else {
			pub = false;
		}
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
	int postID;
	boolean pub;
	
}
