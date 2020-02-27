package se.lexicon.robincarl.data;

public class TodoSequencer {
    private static int todoId = 0;

    public static int nextTodoId() {
        todoId++;
        return todoId;
    }

    public static int reset(){
        return todoId = 0;
    }
}
