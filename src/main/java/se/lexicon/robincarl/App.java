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


        People people1 = new People();
        people1.addPersonToPeople( "Robin", "Sandberg");
        people1.addPersonToPeople( "Bengt", "Svensson");

        System.out.println(people1.size());
        System.out.println(people1.findAll()[1].getPersonId());
        System.out.println(people1.findById(2).getFirstName());
    }
}
