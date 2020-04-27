package se.lexicon.robincarl.model;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private Person person;

    public Todo (String title ,String description, LocalDate deadline, boolean done) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
    }

    public Todo (int id,String title, String description, LocalDate deadline, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public int getTodoId(){
        return this.id;
    }

    public String getTitle(){
        return  this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDate getDeadline(){
        return this.deadline;
    }

    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }

    public boolean getDone(){
        return this.done;
    }

    public void setDone(boolean done){
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo Title = " + title +
                ", id = " + id +
                ", description = " + description +
                ", deadline = " + deadline +
                ", done = " + done +
                ", person = " + person;
    }
}
