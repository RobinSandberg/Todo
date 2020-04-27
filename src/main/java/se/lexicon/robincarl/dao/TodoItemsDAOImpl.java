package se.lexicon.robincarl.dao;

import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;

import java.util.List;

public class TodoItemsDAOImpl implements TodoItemsDAO{

    @Override
    public Todo create(Todo todo){

        return null;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int Id) {

        return null;
    }

    @Override
    public List<Todo> findByDoneStatus(boolean Status) {

        return null;
    }

    @Override
    public List<Todo> findByAssignee(int personId) {

        return null;
    }

    @Override
    public List<Todo> findByAssignee(Person person) {

        return null;
    }

    @Override
    public List<Todo> findByUnassignedTodoItems() {

        return null;
    }

    @Override
    public boolean deleteById(int Id){

        return false;
    }
}
