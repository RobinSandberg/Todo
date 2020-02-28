package se.lexicon.robincarl.data;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.robincarl.model.Person;

public class PeopleTest {

    People people;

    @Before
    public void before(){
        people = new People();
        people.addPersonToPeople( "Robin", "Sandberg");
        people.addPersonToPeople( "Bengt", "Svensson");
        people.addPersonToPeople( "Adam", "Codemasters");
        people.addPersonToPeople( "Carl", "Jensen");
        people.addPersonToPeople( "vera", "wings");
    }

    @After
    public void after(){
        PersonSequencer.reset();
        people.clear();
    }

    @Test
    public void add_Person_To_People_Successfully(){
        String firstName = "Robin";
        String lastName = "Sandberg";
        int id = 6;

        people.addPersonToPeople(firstName,lastName);
        Person[] tempPeople = people.findAll();

        Assert.assertEquals(id, tempPeople[tempPeople.length-1].getPersonId());
        Assert.assertEquals(firstName, tempPeople[tempPeople.length-1].getFirstName());
        Assert.assertEquals(lastName, tempPeople[tempPeople.length-1].getLastName());
    }

    @Test
    public void clear_The_people_Array_successfully() {
        int expected = 0;

        people.clear();

        Assert.assertEquals(expected, people.size());
    }

    @Test
    public void size_Check_Successfully(){
        int expected = 5;

        Assert.assertEquals(expected, people.size());
    }

    @Test
    public void find_By_Id_Successfully(){

        Assert.assertEquals("Bengt", people.findById(2).getFirstName());
        Assert.assertEquals("Svensson", people.findById(2).getLastName());
    }

    @Test
    public void find_All_Successfully(){
        int expected = 5;

        Assert.assertEquals(expected, people.findAll().length);
    }

    @Test
    public void remove_Person_Successfully(){
        int expected = 4;

        people.removePersonFromPeople(2);

        Assert.assertEquals(expected, people.size());
        Assert.assertNull(people.findById(2));
    }
}
