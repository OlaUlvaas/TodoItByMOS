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
    public void remove(int removePerson_Id){
        int index = -1;
        for(int i = 0; i < peopleArray.length; i++){
            if(peopleArray[i].getPERSONID() == removePerson_Id){
                index = i;
                break;
            }
        }
        Person[] newArray = new Person[peopleArray.length - 1];

        for(int i = 0, k = 0; i < peopleArray.length; i++){
            if(i == index){
                continue;
            }
            newArray[k++] = peopleArray[i];
        }
        peopleArray = newArray;
    }


    public void clear (){
        peopleArray = null;
    }
}