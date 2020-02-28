package se.lexicon.robincarl;

import se.lexicon.robincarl.data.People;
import se.lexicon.robincarl.data.PersonSequencer;
import se.lexicon.robincarl.model.Person;

public class App
{
    public static void main( String[] args )
    {
        /*for(int i = 0; i < 5;i++){
            System.out.println(PersonSequencer.nextPersonId());
        }*/


        People people = new People();
        people.addPersonToPeople( "Robin", "Sandberg");
        people.addPersonToPeople( "Bengt", "Svensson");
/*
        System.out.println(people.size());
        System.out.println(people.findAll()[1].getPersonId());
        System.out.println(people.findById(2).getFirstName());
        */
        people.removePersonFromPeople(5);
        Person[] test = people.findAll();
        for(int i = 0; i < people.size(); i++){
            System.out.println(test[i].getPersonId());
            System.out.println(test[i].getFirstName());
        }

    }
}
