package se.lexicon.robincarl.model;

public class Todo {
    public final int todoId;
    public String description;
    public boolean done;
    public Person person;


    public Todo (int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    public int getTotoId(){
        return this.todoId;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(){
        this.description = description;
    }

    public boolean getDone(){
        return this.done;
    }

    public void setDone(){
        this.done = done;
    }


}
