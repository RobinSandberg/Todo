package se.lexicon.robincarl.data;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.robincarl.model.Todo;

public class TodoSequencerTest {

    @Test
    public void todoIdIncrease(){
        int reset = 0;

        Assert.assertEquals(reset, TodoSequencer.reset());
        int[] ids = new int[5];
        for (int i=0; i<5; i++){
            Assert.assertEquals(i, TodoSequencer.nextTodoId());
        }

    }

}
