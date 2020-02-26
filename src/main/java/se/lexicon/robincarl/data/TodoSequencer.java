package se.lexicon.robincarl.data;

public class TodoSequencer {
    private static int todoID = 0;

    public static int nextTodoId() {
        return todoID++;
    }

    public static int reset(){
        return todoID = 0;
    }
}
