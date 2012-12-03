
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

    public int getUserId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Integer> getSubsAsArrayList() {
        return subscriptions;
    }

    public int[] getSubsAsArray(int num) {
        int[] allSubs = new int[subscriptions.size()];
        int counter = allSubs.length - 1;
        Iterator<Integer> i = subscriptions.listIterator();
        while (i.hasNext()) {
            allSubs[counter] = i.next();
            counter --;
        }
        int[] subs = new int[num];
        while (counter < num && counter < allSubs.length) {
            subs[counter] = allSubs[counter];
            counter ++;
        }
        return subs;
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