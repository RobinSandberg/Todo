package se.lexicon.robincarl.data;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.robincarl.model.Person;

public class PeopleTest {

    @Test
    public void add_Person_To_People_Successfully(){
        Person[] people = new Person[0];
        String firstName = "Robin";
        String lastName = "Sandberg";
        int id = 1;

        People people1 = new People();
        people1.addPersonToPeople(people,firstName,lastName);


        Assert.assertEquals(id, people1.findById(1).getPersonId());
        Assert.assertEquals(firstName, people1.findById(1).getFirstName());
        Assert.assertEquals(lastName, people1.findById(1).getLastName());

    }
}
