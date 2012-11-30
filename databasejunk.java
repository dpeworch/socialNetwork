
package socialnetwork;

public class databasejunk {
    public boolean contains(int[] ID, Post post) {
            for (int i = 0; i < ID.length; i++){
                    if (post.userID == ID[i]) {
                            return true;
                    }
            }
            return false;
    }

    public Post[] makeArrayListofSubs(User user) {

        // iterate posts
        // grab posts where post.contains ids
        // grab last 10.
        // return last 10.
        return null;
    }
}
