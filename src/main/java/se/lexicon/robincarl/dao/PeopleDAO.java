package se.lexicon.robincarl.dao;

import se.lexicon.robincarl.model.Person;

import java.util.List;

public interface PeopleDAO {

    List<Person> findAll();
    Person findById(int personId);
    List<Person> findByName(String PersonName);
    boolean addPerson(Person person);
    Person updatePerson(Person person);
    boolean deletePerson(int personId);
}
