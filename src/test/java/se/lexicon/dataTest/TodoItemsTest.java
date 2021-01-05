package se.lexicon.dataTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.data.People;
import se.lexicon.data.TodoItems;
import se.lexicon.model.Todo;
import se.lexicon.model.Person;
public class TodoItemsTest {
    private Todo[] testMissions = new Todo[3];
    private Todo[] testMissions2 = new Todo[3];
    private Todo[] testMissions3 = new Todo[3];
    private Todo testMission1 = new Todo();
    private Todo testMission2 = new Todo();
    private Todo testMission3 = new Todo();
    private Todo testMission4 = new Todo();
    private Person person1 = new Person();
    private Person person2 = new Person();
    private Person person3 = new Person();

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
        testMission1.setAssignee(person1);

        testMission2.getTODOID();
        testMission2.setDescription("Buy a new Car");
        testMission2.setDone(false);
        testMission2.setAssignee(person2);

        testMission3.getTODOID();
        testMission3.setDescription("Buy a new Porsche");
        testMission3.setDone(true);
        testMission3.setAssignee(person3);

        testMission4.getTODOID();
        testMission4.setDescription("Buy a new Porsche");
        testMission4.setDone(true);


        testMissions[0] = testMission1;
        testMissions[1] = testMission2;
        testMissions[2] = testMission3;

        testMissions2[0] = testMission1;
        testMissions2[1] = testMission2;
        testMissions2[2] = testMission3;

        testMissions3[0] = testMission1;
        testMissions3[1] = testMission2;
        testMissions3[2] = testMission3;

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


    @Test
    public void testFindByDoneStatusDynamic() {
        TodoItems testDoneStatusDynamic = new TodoItems();
        testDoneStatusDynamic.addTodo(testMission1);
        testDoneStatusDynamic.addTodo(testMission2);
        testDoneStatusDynamic.addTodo(testMission3);
        Assert.assertEquals(testMission3.getTODOID(), testDoneStatusDynamic.findByDoneStatus(true)[1].getTODOID());
    }

    @Test
    public void testFindByAssigneeWithPersonId(){
        TodoItems testFindByAssignee = new TodoItems();
        testFindByAssignee.addTodo(testMission1);
        testFindByAssignee.addTodo(testMission2);
        testFindByAssignee.addTodo(testMission3);
        Assert.assertEquals("Catch the Mouse",testFindByAssignee.findByAssignee(1)[0].getDescription());
        }
    @Test
    public void testFindByAssigneeWithAssignee(){
        TodoItems testFindByAssignee = new TodoItems();
        testFindByAssignee.addTodo(testMission1);
        testFindByAssignee.addTodo(testMission2);
        testFindByAssignee.addTodo(testMission3);
        Assert.assertEquals("Buy a new Porsche",testFindByAssignee.findByAssignee2(person3)[0].getDescription());
    }
    @Test
    public void testFindByUnAssignee(){
        TodoItems testFindByUnAssignee = new TodoItems();
        testFindByUnAssignee.addTodo(testMission1);
        testFindByUnAssignee.addTodo(testMission2);
        testFindByUnAssignee.addTodo(testMission3);
        testFindByUnAssignee.addTodo(testMission4);
        Assert.assertNull(null, (testFindByUnAssignee.findUnassignedTodoItems()[0].getAssignee()));
    }
    @Test
    public void testRemoveTodo() {
        TodoItems testRemoveTodo = new TodoItems();  //Index
        testRemoveTodo.addTodo(testMission1); //0 Catch the Mouse
        testRemoveTodo.addTodo(testMission2); //1 Buy a new Car
        testRemoveTodo.addTodo(testMission3); //2 Buy a new Porsche
        System.out.println("testRemovePerson.size() = " + testRemoveTodo.size());
        testRemoveTodo.removeTodo(2);
        System.out.println("testRemovePerson.size() = " + testRemoveTodo.size());

        int expectedLength = 2;
        int actualLength = testRemoveTodo.size();
        Assert.assertEquals(expectedLength, actualLength);

    }
}