package se.lexicon.robincarl;

import se.lexicon.robincarl.data.PeopleDAOImpl;
import se.lexicon.robincarl.model.Person;

public class App
{
    public static void main( String[] args )
    {
        PeopleDAOImpl peopleDAOImpl = new PeopleDAOImpl();
        Person person = new Person("Robin","Sandberg");
        System.out.println(peopleDAOImpl.addPerson(person));
    }
}
