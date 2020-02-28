package se.lexicon.robincarl.data;

import se.lexicon.robincarl.model.Person;

import java.util.Arrays;

public class People {
    private static Person[] people = new Person[0];

    public int size(){
        return this.people.length;
    }

    public Person[] findAll(){
        return this.people;
    }

    // Running a index to save what index the id have in the for loop to return.
    // It will return null if the Id don't exist.
    public Person findById(int personId){
        int index = -1;
        for(int i = 0; i < size(); i++){
            if(this.people[i].getPersonId() == personId){
                index = i;
            }
        }
        if (index == -1){
            return null;
        }
        return this.people[index];
    }
    // Adding a new person to the people list using only the name. The Id get called in creation.
    public Person addPersonToPeople(String firstName, String lastName){
        Person[] newPeople = Arrays.copyOf(this.people, size()+1);
        Person person = new Person(PersonSequencer.nextPersonId(),firstName,lastName);
        newPeople[newPeople.length-1] = person;
        this.people = newPeople;
        return person;
    }
    // Making a new array to get a clear one.
    public void clear(){
        people = new Person[0];
    }
    // Similar to add but finding a persons Id and remove him from array and shorten the array
    // with 1 only if the person is removed.
    public void removePersonFromPeople(int personId){
        Person[] newPeople = Arrays.copyOf(this.people, size());
        int index = 0;
        for(int i = 0; i < size();i++){
            if(people[i].getPersonId() ==  personId){
                newPeople = Arrays.copyOf(newPeople, size()-1);
            }else if (people[i].getPersonId() != personId){
                newPeople[index] = people[i];
                index++;
            }
        }
        this.people = newPeople;
    }

}
