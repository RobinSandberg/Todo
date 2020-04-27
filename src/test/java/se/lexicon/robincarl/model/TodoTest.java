package se.lexicon.robincarl.model;

import org.junit.Assert;
import org.junit.Test;

public class TodoTest {

    @Test
    public void create_Todo_item_Successfully() {
        int todoId = 1;
        String description = "Beskrivning";

        Todo todo1 = new Todo(todoId, description);

        Assert.assertEquals(todoId, todo1.getTodoId());
        Assert.assertEquals(description, todo1.getDescription());
    }
}
