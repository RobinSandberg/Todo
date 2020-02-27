package se.lexicon.robincarl.model;

public class Todo {
    public final int todoId;
    public String description;
    public boolean done;
    public Person assignee;


    public Todo (int todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    public Person getPerson() {
        return this.assignee;
    }

    public void setPerson(Person person){
        this.assignee = person;
    }

    public int getTodoId(){
        return this.todoId;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean getDone(){
        return this.done;
    }

    public void setDone(boolean done){
        this.done = done;
    }


}
