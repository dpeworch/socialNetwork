
package socialnetwork;

import java.util.ArrayList;

/**
 * 
 * @author Elisabeth
 * This is a container class for a binary tree that holds a string.
 */
public class StringNode {
	String tag;
	ArrayList<Post> data;
	StringNode left;
	StringNode right;
	
	
	/**
	 * The default constructor.
	 */
	public StringNode(){
		data = new ArrayList<Post>();
		left = null;
		right = null;
	}
	
	public StringNode(String s){
		tag = s;
		data = new ArrayList<Post>();
		left = null;
		right = null;
	}
	
	public void addPost(Post post){
		data.add(post);
	}
}
