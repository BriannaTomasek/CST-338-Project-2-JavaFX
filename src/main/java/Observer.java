/**
 * This class creates and edits the Observer.
 * @author Vincent Marinello-Sweeney
 * created 4/22/26
 * @since 4/22/26
 * @version 1.0
 */

import java.util.List;
//Implement the interface when component would like
//to respond to changes in the list of users
public interface Observer {
    // Call when list changes
    //userList is the updated list of all users
    void onListChanged(List<String> userList);
}
