package se.lexicon.robincarl.data;

import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;

import java.util.Arrays;

public class TodoItems {
    private static Todo[] todo = new Todo[0];

    public int size() {
        return this.todo.length;
    }

    public Todo [] findTodo() {
        return this.todo;
    }

    public Todo findByTodoId(int todoId) {
        int index =-1;
        for(int i = 0; i < size(); i++){
            if(todo[i].getTodoId() == todoId){
                index = i;
            }
        }
        return this.todo[index];
    }

    public Todo addTicketToTodo(String description){
        Todo[] newTodo = Arrays.copyOf(this.todo, size()+1);
        Todo task = new Todo(TodoSequencer.nextTodoId(),description);
        newTodo[newTodo.length-1] = task;
        this.todo = newTodo;
        return task;
    }

    public void clear(){
        todo = Arrays.copyOf(todo,size() - size());
    }

    public static Todo[] findByDoneStatus(boolean doneStatus) {

        return todo;
    }
}
