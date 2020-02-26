package se.lexicon.robincarl.model;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void create_Person_Successfully(){

        String firstName = "Robin";
        String lastName = "Sandberg";
        int id = 1;


        Person person1 = new Person(id,firstName,lastName);

        Assert.assertEquals(id,person1.getPersonId());
        Assert.assertEquals(firstName, person1.getFirstName());
        Assert.assertEquals(lastName, person1.getLastName());
    }
}
