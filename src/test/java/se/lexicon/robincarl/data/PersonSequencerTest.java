package se.lexicon.robincarl.data;

import org.junit.Assert;
import org.junit.Test;

public class PersonSequencerTest {

    @Test
    public void increase_Id_Successfully(){
        int reset = 0;

        Assert.assertEquals(reset, PersonSequencer.reset());

        int[] ids = new int[5];
        for (int i = 0; i < ids.length; i++){
            Assert.assertEquals(i+1,PersonSequencer.nextPersonId());
        }
    }

}
