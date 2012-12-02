
package socialnetwork;

import java.util.ArrayList;
import java.util.Iterator;

public class User {

    private int id;
    private String username;
    private String password;
    private ArrayList<Integer> subscriptions;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        subscriptions = new ArrayList<Integer>();
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
    
    public void addSub(int subid){
        subscriptions.ensureCapacity(subscriptions.size() + 1);
        subscriptions.add(subid);
    }
    
    public void addManySubs(int[] subids){
        subscriptions.ensureCapacity(subscriptions.size() + subids.length);
        for(int i=0; i<subids.length; i++){
            subscriptions.add(subids[i]);
        }
    }
}