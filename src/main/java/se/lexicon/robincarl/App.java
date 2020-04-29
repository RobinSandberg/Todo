package se.lexicon.robincarl;

import se.lexicon.robincarl.dao.PeopleDAOImpl;
import se.lexicon.robincarl.dao.TodoItemsDAOImpl;
import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;


import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        PeopleDAOImpl people = new PeopleDAOImpl();
        Person person = new Person("Robin","Sandberg");
        System.out.println(people.addPerson(person));
        List<Person> foundPeople = people.findByName("sand");
        foundPeople.forEach(System.out::println);
        TodoItemsDAOImpl todoItems = new TodoItemsDAOImpl();
        Todo todo = new Todo("Doom", "Finish the game Doom eternal.", Date.valueOf("2020-06-25"), false);
        System.out.println(todoItems.create(todo) != null);
        todo = new Todo("Warframe", "Farm for Titania prime.", Date.valueOf("2020-05-20"), false);
        System.out.println(todoItems.create(todo) != null);
        todo = new Todo("Dinner", "Pick up pizza.", Date.valueOf("2020-05-28"), true);
        System.out.println(todoItems.create(todo) != null);
        List<Todo> foundTodoList;
        person = people.findById(1);
        foundTodoList = todoItems.findByAssignee(person);
        foundTodoList.forEach(System.out::println);
        Todo foundTodo = todoItems.findById(15);
        System.out.println(foundTodo);
        foundTodo.setAssignee_id(person);
        System.out.println(todoItems.update(foundTodo));

    }
}
