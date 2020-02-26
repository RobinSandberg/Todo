package se.lexicon.robincarl.model;

public class Todo {
    public final int totoId;
    public String description;
    public boolean done;
    public Person person;


    public Todo (int totoId, String description, boolean done, Person person) {
        this.totoId = totoId;
        this.description = description;
    }

    public int getTotoId(){
        return this.totoId;
    }

    public void setTotoId(){
        this.totoId = totoId;
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
