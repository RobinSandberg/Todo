package se.lexicon.robincarl.data;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.robincarl.model.Todo;

import java.util.Arrays;

public class TodoItemsTest {

    TodoItems todoItems;
    @Before
    public void before(){
        todoItems = new TodoItems();
        todoItems.addTicketTodolist("Beskrivning");
        todoItems.addTicketTodolist("Nummer 2");
    }

    @After
    public void after(){
        TodoSequencer.reset();
        todoItems.clear();
    }

    @Test
    public void sizeCheck(){

        int expected = 2;

        Assert.assertEquals(expected, todoItems.size());
    }

    @Test
    public void findAllTodo(){

        int expected = 2;

        Assert.assertEquals(expected, todoItems.findAllTodo().length);

    }

    @Test
    public void findByTodoId(){
        String beskrivning2 = "Nummer 2";

        Assert.assertEquals(beskrivning2, todoItems.findByTodoId(2).getDescription());

    }

    @Test
    public void addTicketTodolist(){
        String beskrivning1 = "Beskrivning";
        int id = 3;

        todoItems.addTicketTodolist(beskrivning1);

        Todo[] tempTodoList = todoItems.findAllTodo();

        Assert.assertEquals(id, tempTodoList[tempTodoList.length-1].getTodoId());
        Assert.assertEquals(beskrivning1, tempTodoList[tempTodoList.length-1].getDescription());
    }

    @Test
    public void clear() {
        int expected = 0;

        todoItems.clear();

        Assert.assertEquals(expected, todoItems.size());
    }

    @Test
    public void findByDoneStatus(){
        todoItems.findByTodoId(1).setDone(true);
        todoItems.findByTodoId(2).setDone(false);
        int expected = 1;

        Todo[] temp = todoItems.findByDoneStatus(true);

        Assert.assertEquals(expected, temp.length);
    }
}
