package se.lexicon.robincarl.data;

public class PersonSequencer {
    private static int personId = 0;

    public static int nextPersonId(){
       return personId = personId++;
    }

    public static int reset(){
        return personId = 0;
    }
}
