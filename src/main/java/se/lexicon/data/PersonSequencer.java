package se.lexicon.data;
public class PersonSequencer {
    private static int sequencer = 0;
    public static int nextPersonId(){
        return ++sequencer;
    }
    public static void reset(int sequencer){
        sequencer = 0;
    }
}