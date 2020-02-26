package se.lexicon.robincarl.model;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void create_Person_Successfully(){

        String firstName = "Robin";
        String lastName = "Sandberg";
        int id = 1;
        int result;


        Person person1 = new Person(firstName,lastName);

        result = person1.getPersonId();

        Assert.assertEquals(id,result);
        Assert.assertEquals(firstName, person1.getFirstName());
        Assert.assertEquals(lastName, person1.getLastName());
    }
}
