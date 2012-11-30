
package socialnetwork;

import java.util.ArrayList;

// I am a database
public class Database {

	public Database() {
		
		posts = new ArrayList<Post>();
		users = new ArrayList<User>();
		tags = new BinaryStringSearchTree();
		
	}
	
	// GUI should contain who is currently logged in
	// GUI will pull content string from form
	// timestamp is from system clock
	public void addNewPost(String contentFromGUI, int userIDFromGUI,  int timestamp) {
		
		Post newPost = new Post(contentFromGUI,userIDFromGUI, timestamp);
		posts.add(newPost);
		
	}
	
	public String[] parseForTags(String content){
		int i = 0; // change when you have actual values
		String[] tags = new String[i];
		return tags;
	}
	
	public void addNewUser(){
		
	}
	
	
	
	
	ArrayList<Post> posts;
	ArrayList<User> users;
	BinaryStringSearchTree tags;
}
