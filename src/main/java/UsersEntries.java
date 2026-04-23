/**
 * This class creates and edits an entry in the userList/a row in Users table.
 * @author Vincent Marinello-Sweeney
 * created 4/22/26
 * @since 4/22/26
 * @version 2.0
 */


public class UsersEntries {
    private final int userId;
    private final String name;
    private boolean done;

    public UsersEntries(int userId, String name, boolean done){
        this.userId = userId;
        this.name = name;
        this.done = done;
    }

    public int getUserId(){
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean isDone(){
        return done;
    }

    @Override
    public String toString(){
        return (done ? "done" : "incomplete ") + name;
    }
}
