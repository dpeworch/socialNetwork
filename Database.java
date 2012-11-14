/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

/**
 *
 * @author dpeworch
 */
public class Database {
    
    String username;
    String password;
    String email;
    String[] posts = new String[3];
    
    public Database() {
        posts[0] = "I'm going to the mall! #mall";
        posts[1] = "I'm going to the beer! #mall";
        posts[2] = "BEER #beermall";
    }
        
    public String[] getPosts(int userID) {
        return posts;
    }
    
    public void setPosts(String post, int userID) {
        System.out.println("Printing " + post + " to " + userID + "'s wall!");
    }
}
