/**
 * This class creates and edits a row in the todos table.
 * @author Vincent Marinello-Sweeney
 * created 4/22/26
 * @since 4/22/26
 * @version 1.0
 */


public class TodoItem {
    private final int id;
    private final String title;
    private boolean done;

    public TodoItem(int id, String title, boolean done){
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone(){
        return done;
    }

    @Override
    public String toString(){
        return (done ? "✓" : "○ ") + title;
    }
}
