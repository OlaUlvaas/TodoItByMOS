package se.lexicon.model;
import se.lexicon.data.PersonSequencer;
public class Person {
    private final int PERSONID;
    private String firstName;
    private String lastName;
    public Person() {
        PERSONID = PersonSequencer.nextPersonId();
    }
    public int getPERSONID() {
        return PERSONID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}