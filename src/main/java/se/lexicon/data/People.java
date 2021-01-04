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

    public void remove(int removePerson_Id) {
        System.out.println("removePerson_Id = " + removePerson_Id);
        int index = 0;
        for (int i = 0; i < peopleArray.length; i++) {
            if(peopleArray[i].getPERSONID() == removePerson_Id) {
                index = i;
                // break;
            }
        }
        System.out.println("index = " + index);
        Person[] beforeIndex = Arrays.copyOfRange(peopleArray, 0, index);
        System.out.println("beforeIndex.length = " + beforeIndex.length);
        Person[] afterIndex = Arrays.copyOfRange(peopleArray, index + 1, peopleArray.length);
        System.out.println("afterIndex.length = " + afterIndex.length);
        Person[] withoutIndex = new Person[peopleArray.length - 1];
        System.out.println("withoutIndex.length = " + withoutIndex.length);

        for(int i = 0; i < beforeIndex.length; i ++){
            withoutIndex[i] = beforeIndex[i];
        }
        for(int i = 0; i < afterIndex.length; i++){
            withoutIndex[i + beforeIndex.length] = afterIndex[i];
        }
    }
    public void clear (){
        peopleArray = null;
    }
}