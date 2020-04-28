package se.lexicon.robincarl.model;

import java.sql.Date;
import java.time.LocalDate;

public class Todo {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean done;
    private int assignee_id;

    public Todo (String title ,String description, Date deadline, boolean done) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
    }

    public Todo (int id,String title, String description, Date deadline, boolean done , int assignee_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee_id = assignee_id;
    }

    public int getAssignee_id() {
        return this.assignee_id;
    }

    public void setAssignee_id(Person assignee_id){
        this.assignee_id = assignee_id.getPersonId();
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

    public Date getDeadline(){
        return this.deadline;
    }

    public void setDeadline(Date deadline){
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
                ", person = " + assignee_id;
    }
}
