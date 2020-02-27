package se.lexicon.robincarl.data;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.robincarl.model.Todo;

public class TodoItemsTest {
    @Test
    public void sizeCheck(){
        TodoItems todoItems = new TodoItems();
        todoItems.addTicketTodolist("Beskrivning");
        todoItems.addTicketTodolist("Nummer 2");
        int expected = 2;

        Assert.assertEquals(expected, todoItems.size());
    }

    @Test
    public void findAllTodo(){
        String beskrivning1 = "Beskrivning";
        String beskrivning2 = "Nummer 2";
        TodoItems todoItems = new TodoItems();
        todoItems.addTicketTodolist(beskrivning1);
        todoItems.addTicketTodolist(beskrivning2);
        int expected = 2;

        Assert.assertEquals(expected, todoItems.findAllTodo().length);

    }

    @Test
    public void findByTodoId(){
        String beskrivning1 = "Beskrivning";
        String beskrivning2 = "Nummer 2";
        TodoItems todoItems = new TodoItems();
        todoItems.addTicketTodolist(beskrivning1);
        todoItems.addTicketTodolist(beskrivning2);

        Assert.assertEquals(beskrivning2, todoItems.findByTodoId(2).getDescription());

    }

    @Test
    public void addTicketTodolist(){
        String beskrivning1 = "Beskrivning";
        int id = 1;
        TodoItems todoItems = new TodoItems();
        todoItems.addTicketTodolist(beskrivning1);

        Assert.assertEquals(id, todoItems.findByTodoId(1).getTodoId());
        Assert.assertEquals(beskrivning1, todoItems.findByTodoId(1).getDescription());
    }

    @Test
    public void clear() {
        String beskrivning1 = "Beskrivning";
        String beskrivning2 = "Nummer 2";
        TodoItems todoItems = new TodoItems();
        todoItems.addTicketTodolist(beskrivning1);
        todoItems.addTicketTodolist(beskrivning2);
        int expected = 0;
        todoItems.clear();

        Assert.assertEquals(expected, todoItems.size());

    }
}
