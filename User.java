
package socialnetwork;

import java.util.ArrayList;
import java.util.Iterator;

public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private ArrayList<Integer> subscriptions;

    public User(int id, String username, String password, String email, ArrayList<Integer> subscriptions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.subscriptions = subscriptions;
    }

    /**
     * Access the user's ID.
     * @return the user's ID
     */
    public int getUserId() {
        return id;
    }

    /**
     * Access the user's username.
     * @return the user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Access the user's password.
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Access the user's email address.
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Access the user's subscriptions.
     * @return the user's subscriptions, as an ArrayList
     */
    public ArrayList<Integer> getSubsAsArrayList() {
        return subscriptions;
    }

    /**
     * Access the user's subscriptions.
     * @param numSubs the number of subscriptions wanted (takes most recent)
     * @return the user's subscriptions, as an array
     */
    public int[] getSubsAsArray(int numSubs) {
        int[] allSubs = new int[subscriptions.size()];
        int counter = allSubs.length - 1;
        Iterator<Integer> i = subscriptions.listIterator();
        while (i.hasNext()) {
            allSubs[counter] = i.next();
            counter --;
        }
        int[] subs = new int[numSubs];
        while (counter < numSubs && counter < allSubs.length) {
            subs[counter] = allSubs[counter];
            counter ++;
        }
        return subs;
    }

    /**
     * Determines if the user has subscribed to a specified user.
     * @param userID the specified user's ID
     * @return true if the user has subscribed to the specified user, otherwise false
     */
    public boolean subscribesTo(int userID) {
        Iterator<Integer> i = subscriptions.listIterator();
        while (i.hasNext()) {
            if (i.next() == userID) {
                return true;
            }
        }
        return false;
    }

    //moved to database
    public void addSub(int subid){
        subscriptions.ensureCapacity(subscriptions.size() + 1);
        subscriptions.add(subid);
    }

    //moved to database
    public void addManySubs(int[] subids){
        subscriptions.ensureCapacity(subscriptions.size() + subids.length);
        for(int i=0; i<subids.length; i++){
            subscriptions.add(subids[i]);
        }
    }
}