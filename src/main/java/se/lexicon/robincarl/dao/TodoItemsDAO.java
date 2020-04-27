package se.lexicon.robincarl.dao;

import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;

import java.util.List;

public interface TodoItemsDAO {

    Todo create(Todo todo);
    List<Todo> findAll();
    Todo findById(int id);
    List<Todo> findByDoneStatus(boolean Status);
    List<Todo> findByAssignee(int id);
    List<Todo> findByAssignee(Person person);
    List<Todo> findByUnassignedTodoItems();
    boolean deleteById(int id);
}
