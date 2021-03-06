package se.lexicon.robincarl.model;

public class Person {
    private final int personId;
    private String firstName;
    private String lastName;

    public Person(int personId,String firstName , String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId = personId;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getPersonId(){
        return personId;
    }

}
