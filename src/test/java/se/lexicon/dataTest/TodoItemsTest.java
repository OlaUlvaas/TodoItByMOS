package se.lexicon.dataTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.data.TodoItems;
import se.lexicon.model.Todo;
import se.lexicon.model.Person;
public class TodoItemsTest {
    private Todo[] testMissions = new Todo[2];
    private Todo testMission1 = new Todo();
    private Todo testMission2 = new Todo();
    @Before
    public void setupTodo (){
        person1.getPERSONID();
        person1.setFirstName("Sebastian");
        person1.setLastName("Bocaciu");

        person2.getPERSONID();
        person2.setFirstName("Mikael");
        person2.setLastName("Aurell");

        person3.getPERSONID();
        person3.setFirstName("Ola");
        person3.setLastName("Ulvås");

        testMission1.getTODOID();
        testMission1.setDescription("Catch the Mouse");
        testMission1.setDone(true);
        testMission1.setAssignee(testMission1.getAssignee()); // ???
        testMission2.getTODOID();
        testMission2.setDescription("Buy a new Car");
        testMission2.setDone(false);
        testMission2.setAssignee(testMission2.getAssignee()); // ???
        testMissions[0] = testMission1;
        testMissions[1] = testMission2;
    }
    @Test
    public void testAddTodo(){
        TodoItems testTodoItems = new TodoItems();
        testTodoItems.addTodo(testMission1);
        testTodoItems.addTodo(testMission2);
        Todo[] expectedTestArray = testMissions;
        Todo[] actualTestArray = testTodoItems.findAllThingsTodo();
        Assert.assertEquals(expectedTestArray[0].getTODOID(), actualTestArray[0].getTODOID());
    }
    @Test
    public void testFindAllThingsTodo(){
        TodoItems testTodoItems = new TodoItems();
        testTodoItems.addTodo(testMission1);
        testTodoItems.addTodo(testMission2);
        Todo[] expectedTestArray = testMissions;
        Todo[] actualTestArray = testTodoItems.findAllThingsTodo();
        Assert.assertArrayEquals(expectedTestArray, actualTestArray);
    }
    @Test
    public void testClearTodo(){
        TodoItems testClear = new TodoItems();
        testClear.addTodo(testMission1);
        testClear.addTodo(testMission2);
        testClear.clear();
        Assert.assertNull(null,testClear.findAllThingsTodo());
    }
}