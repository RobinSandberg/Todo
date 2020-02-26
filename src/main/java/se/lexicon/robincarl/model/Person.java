package se.lexicon.robincarl.model;

public class Person {
    private static int counter = 1;
    private final int personId;
    private String firstName;
    private String lastName;

    public Person(String firstName , String lastName){
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(){
        this.firstName = "Unknown first name";
        this.lastName = "Unknown last name";
        this.personId = counter++;
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
