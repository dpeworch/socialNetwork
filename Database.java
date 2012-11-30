
package socialnetwork;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

// I am a database
public class Database {

    String filename = "C://Users/David/NetBeansProjects/socialNetwork/src/socialnetwork/users.txt";
    int maxID = -1;

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

    public void addNewUser(String username, String password) {
        maxID ++;
        users.add(new User(maxID, username, password));
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(maxID + " " + username + " " + password);
            out.close();
        }
        catch (Exception e) {
            
        }
    }
    
    public int findUser(String username, String password) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String currentLine = br.readLine();
            while (!currentLine.equals("")) {
                Scanner s = new Scanner(currentLine).useDelimiter(" ");
                int id = Integer.valueOf(s.next());
                if(s.next().equals(username) && s.next().equals(password)) {
                    return id;
                }
                else {
                    currentLine = br.readLine();
                }
                //System.out.println(s.next() + " " + s.next() + " " + s.next());
            }
            return -1;
        }
        catch (Exception e) {
            return -1;
        }
    }

    ArrayList<Post> posts;
    ArrayList<User> users;
    BinaryStringSearchTree tags;
}
