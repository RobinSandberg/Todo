package se.lexicon.robincarl;

import se.lexicon.robincarl.dao.PeopleDAOImpl;
import se.lexicon.robincarl.model.Person;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        PeopleDAOImpl peopleDAOImpl = new PeopleDAOImpl();
        Person person = new Person("Robin","Sandberg");
        System.out.println(peopleDAOImpl.addPerson(person));
        List<Person> foundPeople = peopleDAOImpl.findByName("sand");
        foundPeople.forEach(System.out::println);
    }
}
