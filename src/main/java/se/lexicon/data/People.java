package se.lexicon.data;
import se.lexicon.model.Person;
import java.util.Arrays;
public class People {
    private static Person[] peopleArray = new Person[0];
    public int size() {
        return peopleArray.length;
    }
    public Person[] findAll() {
        return peopleArray;
    }
    public Person findById(int person_Id) {
        Person findPerson = new Person();
        int tempPERSONID = 0;
        for (int i = 0; i < peopleArray.length; i++) {
            tempPERSONID = peopleArray[i].getPERSONID();
            if (tempPERSONID == person_Id) {
                findPerson = peopleArray[i];
            }
        }
        return findPerson;
    }
    public void addPerson(Person newPerson) {
        Person[] newPeopleArray = Arrays.copyOf(peopleArray, peopleArray.length + 1);
        newPeopleArray[newPeopleArray.length - 1] = newPerson;
        peopleArray = newPeopleArray;
    }
    public void clear (){
        peopleArray = null;
        //Arrays.fill(peopleArray, null);
    }
}