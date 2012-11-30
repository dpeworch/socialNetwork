
package socialnetwork;

import java.util.ArrayList;


public class User {

	public User(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
            loggedIn = false;
	}
	
	int id;
	String username;
	String password;
	ArrayList<Integer> subscriptions;
	boolean loggedIn;
}
