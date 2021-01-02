package se.lexicon.dataTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.data.People;
import se.lexicon.model.Person;
public class PeopleTest {
    private Person[] testPeople1 = new Person[2];
    private Person testPeoplePerson1 = new Person();
    private Person testPeoplePerson2 = new Person();
    @Before
    public void setup (){
        testPeoplePerson1.getPERSONID();
        testPeoplePerson1.setFirstName("Mikael");
        testPeoplePerson1.setLastName("Aurell");
        testPeoplePerson2.getPERSONID();
        testPeoplePerson2.setFirstName("Ola");
        testPeoplePerson2.setLastName("Kula");
        testPeople1[0] = testPeoplePerson1;
        testPeople1[1] = testPeoplePerson2;
    }
    @Test
    public void testAddPerson(){
        People testPeople = new People();
        testPeople.addPerson(testPeoplePerson1);
        testPeople.addPerson(testPeoplePerson2);
        Person[] expectedTestArray = testPeople1;
        Person[] actualTestArray = testPeople.findAll();
        Assert.assertEquals(expectedTestArray[0].getPERSONID(), actualTestArray[0].getPERSONID());
    }
    @Test
    public void testFindAll(){
        People testPeople = new People();
        testPeople.addPerson(testPeoplePerson1);
        testPeople.addPerson(testPeoplePerson2);
        Person[] expectedTestArray = testPeople1;
        Person[] actualTestArray = testPeople.findAll();
        Assert.assertArrayEquals(expectedTestArray, actualTestArray);
    }
    @Test
    public void testClear(){
        People testClear = new People();
        testClear.addPerson(testPeoplePerson1);
        testClear.addPerson(testPeoplePerson2);
        testClear.clear();
        Assert.assertNull(null,testClear.findAll());
    }
}