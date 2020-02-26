package se.lexicon.robincarl;

import se.lexicon.robincarl.data.PersonSequencer;

public class App
{
    public static void main( String[] args )
    {
        for(int i = 0; i < 5;i++){
            System.out.println(PersonSequencer.nextPersonId());
        }
    }
}
