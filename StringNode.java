
package socialnetwork;

import java.util.ArrayList;


public class StringNode {

	public StringNode(){
		
		posts = new ArrayList<Post>();
		left = null;
		right = null;
	}
	
	public void addNode(boolean l, StringNode toAdd){
		if (l){
			left = toAdd; 
		}
		else {
			right = toAdd;
		}
	}
	
	ArrayList<Post> posts;
	StringNode left;
	StringNode right;
	
	
}
