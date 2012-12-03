
package socialnetwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

// I am a database
public class Database {

    private String filename = "C://Users/David/NetBeansProjects/socialNetwork/src/socialnetwork/users.txt"; //or whatever the path is
    private String filename2 = "posts.txt";
    private int maxID = -1;
    
    private int searchIndex; // index for searches spanning multiple function calls, used for getting posts, then getting more posts, then more, etc.

    private ArrayList<Post> posts;
    private ArrayList<User> users;
    private BinaryStringSearchTree tags;
    private User currentUser;

    public Database() {
        posts = new ArrayList<Post>();
        users = new ArrayList<User>();
        tags = new BinaryStringSearchTree();
        currentUser = null;
        addExistingUsers();
    }

    public void addExistingPosts(){
    	try {
            BufferedReader br = new BufferedReader(new FileReader(filename2));
            String currentLine = br.readLine();
            while (!currentLine.equals("")) {
                Scanner scanner = new Scanner(currentLine).useDelimiter(",");
                int uid = Integer.valueOf(scanner.next());
                int pid = Integer.valueOf(scanner.next());
                String hashtags = scanner.next();
                String usertags = scanner.next();
                String visibility = scanner.next();
                int timestamp = Integer.valueOf(scanner.next());
                scanner.useDelimiter("\r");
                String content = scanner.next();
                
                // get rid of the comma at the beginning of the string
                content = content.substring(1);
                
                String[] htags;
                String[] utags;

                
                Scanner htagScanner = new Scanner(hashtags).useDelimiter(" ");
                ArrayList<String> htagAlist = new ArrayList<String>();
                while (htagScanner.hasNext()) {
                	htagAlist.ensureCapacity(htagAlist.size() + 1);
                    htagAlist.add(htagScanner.next());
                }
                
                Scanner utagScanner = new Scanner(usertags).useDelimiter(" ");
                ArrayList<String> utagAlist = new ArrayList<String>();
                while (utagScanner.hasNext()) {
                	utagAlist.ensureCapacity(utagAlist.size() + 1);
                    utagAlist.add(utagScanner.next());
                }
                
                
                htags = new String[htagAlist.size()];
                utags = new String[utagAlist.size()];
                for(int i=0; i<htagAlist.size(); i++){
                	htags[i] = htagAlist.get(i);
                }
                
                for(int i=0; i<utagAlist.size(); i++){
                	utags[i] = utagAlist.get(i);
                }
                
                Post toAdd = new Post(content, uid, timestamp, htags, utags, pid, visibility);
                
                posts.ensureCapacity(posts.size() + 1);
                posts.add(toAdd);
                currentLine = br.readLine();
            }
        }
        catch (Exception e) {

        }
    }
    
    // GUI should contain who is currently logged in
    // GUI will pull content string from form
    // timestamp is from system clock
    public void addNewPost(String contentFromGUI, int userIDFromGUI,  int timestamp, String visibilityFromGUI) {
        String[] hashTags = parseForTags(contentFromGUI, "#");
        String[] atTags = parseForTags(contentFromGUI, "@");
        int postID = posts.size() + 1;
    	Post newPost = new Post(contentFromGUI,userIDFromGUI, timestamp, hashTags, atTags, postID, visibilityFromGUI);
        posts.ensureCapacity(posts.size() + 1);
        posts.add(newPost);
        
        String toFile = "" + userIDFromGUI + "," + postID + ",";
        for(int i=0; i<hashTags.length; i++){
        	if(i == 0){
        		toFile = toFile + hashTags[i];
        	} else {
        		toFile = toFile + " " + hashTags[i];
        	}
        }
        
        toFile = toFile + ",";
        for(int i=0; i<atTags.length; i++){
        	if(i == 0){
        		toFile = toFile + atTags[i];
        	} else {
        		toFile = toFile + " " + atTags[i];
        	}
        }
        toFile = toFile + "," + visibilityFromGUI + "," + timestamp + "," + contentFromGUI + "\r";
        
        try {
            PrintWriter fstream = new PrintWriter(new FileWriter(filename2, true));
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(toFile);
            out.close();
        }
        catch (Exception e) {
            
        }
        
        
    }
    
    public String[] parseForTags(String content, String tagDelimiter){
    	ArrayList<String> parsedTags = new ArrayList<String>();
    	if(content.contains(tagDelimiter)){
    		int start = 0;
    		int next = -1;
    		start = content.indexOf(tagDelimiter);
    		while(start >= 0){
    			next = content.indexOf(" ", start);
    			parsedTags.ensureCapacity(parsedTags.size() + 1);
    			if(next > 0){
    				parsedTags.add(content.substring(start + 1, next));
    			} else {
    				parsedTags.add(content.substring(start + 1));
    			}

    			start = content.indexOf(tagDelimiter, start + 1);
    		}
    		
    	} else {
    		return new String[0];
    	}
        String[] outputTags = new String[parsedTags.size()];
        for(int i=0; i<outputTags.length; i++){
        	outputTags[i] = parsedTags.get(i);
        }
        return outputTags;
    }
    
    
    public Post getSinglePost(int postID){
    	for(int i=0; i<posts.size(); i++){
    		if(posts.get(i).postID == postID){
    			if(posts.get(i).pub){
    				return posts.get(i);
    			} else {
    				// if user is subscribed to the user who posted the post
    				if(currentUser != null && findUser(currentUser.getUsername()).getSubsAsArrayList().contains(posts.get(i).userID)){
    					return posts.get(i);
    				} else {
    					return null;
    				}
    			}
    		}
    	}
    	
    	return null;
    }
    
    public Post[] getPostsByUser(int uid, int page){ // page should start at 1
    	return null;
    }
    
    public Post[] getPostsFromSubs(int page){ // page should start at 1
    	return null;
    }
    

    /**
     * Reads users.txt so it can add into the ArrayList all users that were already
     * in the system before the current run of the program.
     */
    private void addExistingUsers() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String currentLine = br.readLine();
            while (!currentLine.equals("")) {
                Scanner scanner = new Scanner(currentLine).useDelimiter("\t");
                maxID ++;
                int id = Integer.valueOf(scanner.next());
                String username = scanner.next();
                String password = scanner.next();
                String email = scanner.next();
                String subscriptions = scanner.next();
                Scanner subsScanner = new Scanner(subscriptions).useDelimiter(",");
                ArrayList<Integer> subs = new ArrayList<Integer>();
                while (subsScanner.hasNext()) {
                    subs.add(Integer.parseInt(subsScanner.next()));
                }
                users.ensureCapacity(users.size() + 1);
                users.add(new User(id, username, password, email, subs));
                currentLine = br.readLine();
            }
        }
        catch (Exception e) {

        }
    }

    /**
     * Adds a new user into the system.  Both the ArrayList and users.txt are updated.
     * @param username The new user's username.
     * @param password The new user's password.
     * @param email The new user's email address.
     */
    public void addNewUser(String username, String password, String email) {
        maxID ++;
        users.ensureCapacity(users.size() + 1);
        users.add(new User(maxID, username, password, email, new ArrayList<Integer>()));
        try {
            PrintWriter fstream = new PrintWriter(new FileWriter(filename, true));
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(maxID + "\t" + username + "\t" + password + "\t" + email + "\t" + "," + "\r");
            out.close();
        }
        catch (Exception e) {
            
        }
    }

    /**
     * Finds a user in the system with the specified username.
     * @param username The username of the user being searched for.
     * @return the user with the intended username, or null if none are found
     */
    public User findUser(String username) {
        User current = null;
        Iterator<User> i = users.listIterator();
        while (i.hasNext()) {
            current = i.next();
            if (current.getUsername().equals(username)) {
                return current;
            }
        }
        return null;
    }

    public User findUser(String username, String password) {
        User current = null;
        Iterator<User> i = users.listIterator();
        while (i.hasNext()) {
            current = i.next();
            if (current.getUsername().equals(username) && current.getPassword().equals(password)) {
                return current;
            }
        }
        return null;
    }

    //don't think this function is needed
    public User findUser(int uid) {
        User current = null;
        Iterator<User> i = users.listIterator();
        while (i.hasNext()) {
            current = i.next();
            if (current.getUserId() == uid) {
                return current;
            }
        }
        return null;
    }

    /**
     * Validates the user's registration info so the user can be added into the system.
     * @param username The user's username.
     * @param password The user's password.
     * @param email The user's email address.
     * @return
     * 0 if they left any fields blank;
     * 1 if they entered a username that was already in the system;
     * 2 if their username contained a space;
     * 3 if their password contained a space;
     * 4 if their email was in the incorrect form;
     * 5 if their registration info passed all requirements
     */
    public int validateRegistrationInfo(String username, String password, String email) {
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            return 0;
        }
        else if (findUser(username) != null) {
            return 1;
        }
        else if (!username.matches("^[A-Za-z0-9]+$")) {
            return 2;
        }
        else if (!password.matches("^[A-Za-z0-9]+$")) {
            return 3;
        }
        else if (!email.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z]{2,})$")) {
            return 4;
        }
        else {
            return 5;
        }
    }

    public void login(User user) {
        currentUser = user;
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addSubscription(User subscriber, int userID) {
        subscriber.getSubsAsArrayList().add(userID);
        User current = null;
        Iterator<User> i = users.listIterator();
        try {
            FileOutputStream erasor = new FileOutputStream(filename);
            erasor.write((new String()).getBytes());
            erasor.close();
            PrintWriter fstream = new PrintWriter(new FileWriter(filename, true));
            BufferedWriter out = new BufferedWriter(fstream);
            while (i.hasNext()) {
                current = i.next();
                out.write(current.getUserId() + "\t" + current.getUsername() + "\t" + current.getPassword() + "\t" + current.getEmail() + "\t" + ",");
                for (int j = 0; j < current.getSubsAsArrayList().size(); j++) {
                    if (j != 0) {
                        out.write(",");
                    }
                    out.write(current.getSubsAsArrayList().get(j).toString());
                }
                out.write("\r");
            }
            out.close();
        }
        catch (Exception e) {

        }
    }
}