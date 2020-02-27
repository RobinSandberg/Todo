package se.lexicon.robincarl;

import se.lexicon.robincarl.data.People;
import se.lexicon.robincarl.data.PersonSequencer;
import se.lexicon.robincarl.model.Person;

public class App
{
    public static void main( String[] args )
    {
        for(int i = 0; i < 5;i++){
            System.out.println(PersonSequencer.nextPersonId());
        }

        PersonSequencer.reset();
        People test = new People();
        System.out.println(test.size());
        //test.addPersonToPeople(test.findAll(),"test","now");
        System.out.println(test.size());
        //System.out.println(test.findById(1).getFirstName());


    }
}
