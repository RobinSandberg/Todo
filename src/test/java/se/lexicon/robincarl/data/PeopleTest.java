package se.lexicon.robincarl.data;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.robincarl.model.Person;

public class PeopleTest {

    @Test
    public void add_Person_To_People_Successfully(){
        String firstName = "Robin";
        String lastName = "Sandberg";
        int id = 1;

        People people = new People();
        people.addPersonToPeople(firstName,lastName);

        Person[] tempPeople = people.findAll();


        Assert.assertEquals(id, tempPeople[0].getPersonId());
        Assert.assertEquals(firstName, tempPeople[0].getFirstName());
        Assert.assertEquals(lastName, tempPeople[0].getLastName());

    }

    @Test
    public void clear_The_people_Array_successfully() {
        People people = new People();
        people.addPersonToPeople( "Robin", "Sandberg");
        people.addPersonToPeople( "Bengt", "Svensson");
        int expected = 0;

        people.clear();

        Assert.assertEquals(expected, people.size());

    }

    @Test
    public void size_Check_Successfully(){
        People people = new People();
        people.addPersonToPeople( "Robin", "Sandberg");
        people.addPersonToPeople("Bengt", "Svensson");
        int expected = 2;

        Assert.assertEquals(expected, people.size());
    }

    @Test
    public void find_By_Id_Successfully(){
        People people = new People();
        people.addPersonToPeople( "Robin", "Sandberg");
        people.addPersonToPeople( "Bengt", "Svensson");

        Assert.assertEquals("Bengt", people.findById(2).getFirstName());
        Assert.assertEquals("Svensson", people.findById(2).getLastName());

    }

    @Test
    public void find_All_Successfully(){
        People people = new People();
        people.addPersonToPeople( "Robin", "Sandberg");
        people.addPersonToPeople( "Bengt", "Svensson");
        people.addPersonToPeople( "Adam", "Codemasters");
        people.addPersonToPeople( "Carl", "Jensen");
        people.addPersonToPeople( "vera", "wings");
        int expected = 5;

        Assert.assertEquals(expected, people.findAll().length);

    }

    @Test
    public void remove_Person_Successfully(){
        People people = new People();
        people.addPersonToPeople( "Robin", "Sandberg");
        people.addPersonToPeople( "Bengt", "Svensson");
        people.addPersonToPeople( "Adam", "Codemasters");
        people.addPersonToPeople( "Carl", "Jensen");
        people.addPersonToPeople( "vera", "wings");
        int expected = 4;

        people.removePersonFromPeople(2);
        Assert.assertEquals(expected, people.findAll().length);

        Assert.assertNull(people.findById(2));
    }
}
