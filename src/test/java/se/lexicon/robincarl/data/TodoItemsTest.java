package se.lexicon.robincarl.data;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;

import java.util.Arrays;

public class TodoItemsTest {

    TodoItems todoItems;
    People people;
    @Before
    public void before(){
        todoItems = new TodoItems();
        todoItems.addTicketTodolist("Beskrivning");
        todoItems.addTicketTodolist("Nummer 2");
        todoItems.addTicketTodolist("Nummer 3");
        todoItems.addTicketTodolist("Nummer 4");

        people = new People();
        people.addPersonToPeople("Robin", "Sandberg");
        people.addPersonToPeople("Bengt", "Svensson");
        people.addPersonToPeople("Erik", "Medeltal");
    }

    @After
    public void after(){
        TodoSequencer.reset();
        todoItems.clear();
        PersonSequencer.reset();
        people.clear();
    }

    @Test
    public void sizeCheck(){

        int expected = 4;

        Assert.assertEquals(expected, todoItems.size());
    }

    @Test
    public void findAllTodo(){

        int expected = 4;

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
        int id = 5;

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
//------------------10b-------------------------------------------------------------------------------------------------
    @Test
    public void find_By_Assignee_Id_Successfully(){
        int id = 1;
        int expected = 1;
        Todo[] tempTodoItems = todoItems.findAllTodo();
        Person[] tempPeople = people.findAll();

        tempTodoItems[0].setPerson(tempPeople[0]);
        tempTodoItems[1].setPerson(tempPeople[1]);

        Assert.assertEquals(expected,todoItems.findByAssignee(id).length);
    }
//------------------10c-------------------------------------------------------------------------------------------------
    @Test
    public void find_By_Assignee_Person_Successfully(){

        int expected = 2;
        Todo[] tempTodo = todoItems.findAllTodo();
        Person[] tempPerson = people.findAll();

        tempTodo[0].setPerson(tempPerson[0]);
        tempTodo[1].setPerson(tempPerson[1]);
        tempTodo[2].setPerson(tempPerson[2]);
        tempTodo[3].setPerson(tempPerson[2]);

        Assert.assertEquals(expected, todoItems.findByAssignee(tempPerson[2]).length);


    }
//------------------10d-------------------------------------------------------------------------------------------------
    @Test
    public void find_Unassigned_TodoItems(){

        int expected=3;

        Todo[] tempTodo = todoItems.findAllTodo();
        Person[] tempPerson = people.findAll();

        tempTodo[0].setPerson(tempPerson[0]);

        Assert.assertEquals(expected, todoItems.findUnassignedTodoItems().length);



    }
//------------------11--------------------------------------------------------------------------------------------------
    @Test
    public void removeTaskFromTodo(){
        int expected = 3;

        todoItems.removeTaskFromTodo(2);

        Assert.assertEquals(expected, todoItems.size());
        Assert.assertNull(todoItems.findByTodoId(2));
    }
}
