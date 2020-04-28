package se.lexicon.robincarl;

import se.lexicon.robincarl.dao.PeopleDAOImpl;
import se.lexicon.robincarl.dao.TodoItemsDAOImpl;
import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;


import java.sql.Date;
import java.time.LocalDate;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
       /* PeopleDAOImpl people = new PeopleDAOImpl();
        Person person = new Person("Robin","Sandberg");
        System.out.println(people.addPerson(person));
        List<Person> foundPeople = people.findByName("sand");
        foundPeople.forEach(System.out::println);*/
        TodoItemsDAOImpl todoItems = new TodoItemsDAOImpl();
        Todo todo = new Todo("Doom", "Finish the game Doom eternal.", Date.valueOf("2020-06-25"), false);
        System.out.println(todoItems.create(todo));
        //System.out.println(todoItems.deleteById(4));

    }
}
