package se.lexicon.robincarl.data;

import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;

import java.util.Arrays;

public class TodoItems {
    private static Todo[] todoList = new Todo[0];

    public int size() {
        return this.todoList.length;
    }

    public Todo[] findAllTodo() {
        return this.todoList;
    }

    public Todo findByTodoId(int todoId) {
        int index =-1;
        for(int i = 0; i < size(); i++){
            if(todoList[i].getTodoId() == todoId){
                index = i;
            }
        }
        return this.todoList[index];
    }

    public Todo addTicketTodolist(String description){
        Todo[] newTodo = Arrays.copyOf(this.todoList, size()+1);
        Todo task = new Todo(TodoSequencer.nextTodoId(),description);
        newTodo[newTodo.length-1] = task;
        this.todoList = newTodo;
        return task;
    }

    public void clear(){
 /*       todoList = Arrays.copyOf(todoList,size() - size());*/
        todoList = new Todo[0];
    }

    //---10a------------------------------------------------------------------------------------------------------------
    public Todo[] findByDoneStatus(boolean doneStatus) {
        Todo[] newStatus = new Todo[0];
        int index = 0;
        for (int i=0; i<size(); i++) {
            if (todoList[i].getDone() == doneStatus){
                newStatus = Arrays.copyOf(newStatus, newStatus.length+1);
                newStatus[index] = todoList[i];
                index++;
            }
        }
        return newStatus;
    }
    //---10b------------------------------------------------------------------------------------------------------------
    public Todo[] findByAssignee(int personId) {
        Todo[] assignedTasks = new Todo[0];
        int index = 0;
        for (int i=0; i<size(); i++) {
            if (todoList[i].getPerson() != null) {
                if (todoList[i].getPerson().getPersonId() == personId) {
                    assignedTasks = Arrays.copyOf(assignedTasks, assignedTasks.length + 1);
                    assignedTasks[index] = todoList[i];
                    index++;
                }
            }
        }
        return assignedTasks;
    }
    //---10c------------------------------------------------------------------------------------------------------------
    public Todo[] findByAssignee(Person assignee) {
        Todo[] findAssignee = new Todo[0];
        int index = 0;
        for (int i=0; i<size(); i++) {
            if (todoList[i].getPerson() == assignee) {
                findAssignee = Arrays.copyOf(findAssignee, findAssignee.length+1);
                findAssignee[index] = todoList[i];
                index++;
            }
        }
        return findAssignee;
    }
    //---10d------------------------------------------------------------------------------------------------------------
    public Todo[] findUnassignedTodoItems() {
        Todo[] newUnassigned = new Todo[0];
        int index = 0;
        for (int i=0; i<size(); i++) {
            if (todoList[i].getPerson() == null) {
                newUnassigned = Arrays.copyOf(newUnassigned, newUnassigned.length+1);
                newUnassigned[index] = todoList[i];
                index++;
            }
        }
        return newUnassigned;
    }
}
