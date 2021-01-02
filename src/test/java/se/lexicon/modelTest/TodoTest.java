package se.lexicon.modelTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;
public class TodoTest {
    private Todo testTodo1;
    private Todo testTodo2;
    @Before
    public void setupTestTodo() {
        //Testing constructor "public Todo(){}"
        testTodo1 = new Todo();
        //testTodo1.getTODOID();
        testTodo1.setDescription("Description1");
        testTodo1.setDone(false);
        Person assignee1 = new Person();
        assignee1.setFirstName("Sebastian");
        assignee1.setLastName("Bocaciu");
        // assignee1.getPERSONID();
        testTodo1.setAssignee(assignee1);
        //Testing constructor "public Todo(int TODOID, String description){}"
        testTodo2 = new Todo("Description2");
    }
    @Test
    public void testTODOID1() {
        int expectedTODOID1 = 1;
        int actualTODOID1 = testTodo1.getTODOID();
        Assert.assertEquals(expectedTODOID1, actualTODOID1);
    }
    @Test
    public void testTodo1Assignee1(){
        Person personExpectedResult = new Person();
        personExpectedResult.setFirstName("Sebastian");
        personExpectedResult.setLastName("Bocaciu");
        Person personActualResult = testTodo1.getAssignee();
        Assert.assertEquals(personExpectedResult.getFirstName(), personActualResult.getFirstName());
        Assert.assertEquals(personExpectedResult.getLastName(), personActualResult.getLastName());
    }
    @Test
    public void testTodo2() {
        String expectedTestTodo2 = "Description2";
        String actualTestTodo2 = testTodo2.getDescription();
        Assert.assertEquals(expectedTestTodo2, actualTestTodo2);
    }
    @Test
    public void testTODOID2() {
        int expectedTODOID2 = 2;
        int actualTODOID2 = testTodo2.getTODOID();
        Assert.assertEquals(expectedTODOID2, actualTODOID2);
    }
    @Test
    public void testBoolean1 () {
        boolean expectedBoolean1 = false;
        boolean actualBoolean1 = testTodo1.isDone();
        Assert.assertEquals(expectedBoolean1, actualBoolean1);
    }
    @Test
    public void testAssignee (){
        Person expectedAssignee1 = new Person();
        expectedAssignee1.getPERSONID();
        expectedAssignee1.setFirstName("Sebastian");
        expectedAssignee1.setLastName("Bocaciu");
        Person actualAssignee1 = testTodo1.getAssignee();
        Assert.assertEquals(expectedAssignee1.getFirstName(), testTodo1.getAssignee().getFirstName());
    }
}