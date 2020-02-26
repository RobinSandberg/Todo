package se.lexicon.robincarl.model;

import org.junit.Assert;
import org.junit.Test;

public class TodoTest {

    @Test
    public void dethärtestetgickbra() {
        int todoId = 1;
        String description = "Beskrivning";

        Todo todo1 = new Todo(todoId, description);

        Assert.assertEquals(todoId, todo1.getTotoId());
        Assert.assertEquals(description, todo1.getDescription());
    }
}
