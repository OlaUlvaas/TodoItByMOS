package se.lexicon.model;
import java.util.Scanner;
import se.lexicon.data.TodoSequencer;
public class Todo {
    private final int TODOID;
    private String description;
    private boolean done;
    private Person assignee;

    public Todo() {
        TODOID = TodoSequencer.nextTodoId();
    }
    public Todo(String description) {
        this.description = description;
        TODOID = TodoSequencer.nextTodoId();
    }
    public int getTODOID() {
        return TODOID;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public Person getAssignee() {

        return assignee;
    }
    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }
}