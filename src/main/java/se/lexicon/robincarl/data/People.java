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

    public Person findById(int personId){
        int index =-1;
        for(int i = 0; i < size(); i++){
            if(this.people[i].getPersonId() == personId){
                index = i;
            }
        }
        return this.people[index];
    }

    public Person[] addPersonToPeople(Person[] people ,String firstName, String lastName){
        Person[] newPeople = Arrays.copyOf(people, size()+1);
        Person person = new Person(PersonSequencer.nextPersonId(),firstName,lastName);
        newPeople[newPeople.length-1] = person;
        this.people = newPeople;
        return this.people;
    }

    public void clear(){
        people = Arrays.copyOf(people,size() - size());
    }

}
