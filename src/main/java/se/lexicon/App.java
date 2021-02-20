package se.lexicon;

import se.lexicon.data.People;
import se.lexicon.data.PeopleJDBC;
import se.lexicon.data.TodoItems;
import se.lexicon.data.TodoItemsJDBC;
import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        People dao = new PeopleJDBC();


        System.out.println("//////////// PERSON ////////////////////////////");
        System.out.println("---------- create() ----------");
//        Person newPerson1 = dao.create(new Person("Ola", "Ulvås"));
//        Person newPerson2 = dao.create(new Person("Donald", "Trump"));
//        Person newPerson3 = dao.create(new Person("Ronald", "Reagan"));
//        Person newPerson4 = dao.create(new Person("Richard", "Nixon"));
//        Person newPerson5 = dao.create(new Person("Eddie", "Meduza"));
//        Person newPerson6 = dao.create(new Person("George W", "Bush"));



        System.out.println("---------- findAll() ----------");
//        Collection<Person> presidents = dao.findAll();
//        presidents.forEach(System.out::println);


        System.out.println("---------- findById() ----------");
//        Person p = dao.findById(12);
//        System.out.println(p);


        System.out.println("---------- findByName() ----------");
//        Collection<Person> trump = dao.findByName("George W");
//        System.out.println(trump);


        System.out.println("---------- update() ----------");
//        Person p2 = new Person(11, "George W", "Bushhhh");
//        System.out.println(dao.update(p2));


        System.out.println("---------- deleteById() ----------");
//        boolean delete = dao.deleteById(10);
//        System.out.println(delete);


        TodoItems tdDao = new TodoItemsJDBC();

        System.out.println("//////////// TODO_ITEM ////////////////////////////");
        System.out.println("---------- create() ----------");
//        Todo_Item tdItem1 = tdDao.create(new Todo_Item("Go", "Slow walk",
//                LocalDate.of(2021,12,31), false,4));
//        Todo_Item tdItem2 = tdDao.create(new Todo_Item("Joking", "Telling jokes",
//                LocalDate.of(2021,7,1), false, 9));
//        Todo_Item tdItem3 = tdDao.create(new Todo_Item("Dance", "Shaking butt",
//                LocalDate.of(2021,2,19),false,1));
//        Todo_Item tdItem4 = tdDao.create(new Todo_Item("Exercise", "Playing Golf",
//                LocalDate.of(2021,2,20),false,1));
//        Todo_Item tdItem5 = tdDao.create(new Todo_Item("Exercise", "Surfing",
//                LocalDate.of(2022,4,30),false));
//        Todo_Item tdItem6 = tdDao.create(new Todo_Item("Rocking", "Play Guitar",
//                LocalDate.of(2021,2,17),true));
//        Todo_Item tdItem7 = tdDao.create(new Todo_Item("Rocking", "Play Guitar",
//                LocalDate.of(2021,2,17),true, 9));



        //public Collection<Todo_Item> findAll();
        System.out.println("---------- findAll() ----------");
//        Collection<Todo_Item> allItems = tdDao.findAll();
//        allItems.forEach(System.out::println);


        //public Todo_Item findById(int id)
        System.out.println("---------- findById() ----------");
//        Todo_Item theItem = tdDao.findById(29);
//        System.out.println(theItem);



        //public Collection<Todo_Item> findByDoneStatus(boolean done)
        System.out.println("---------- findByDoneStatus() ----------");
//        Collection<Todo_Item> status = tdDao.findByDoneStatus(true);
//        status.forEach(System.out::println);


        //public Collection<Todo_Item> findByAssignee(int assignee)
        System.out.println("---------- findByAssignee() ----------");//int
//        Collection<Todo_Item> todo1 = tdDao.findByAssignee(1);
//        todo1.forEach(System.out::println);


        //public Collection<Todo_Item> findByAssignee(Person person)
        System.out.println("---------- findByAssignee() ----------");//Person
//        Collection<Todo_Item> todo2 = tdDao.findByAssignee( new Person
//                (1, "Ola", "Ulvås"));
//        todo2.forEach(System.out::println);



        //public Collection<Todo_Item> findByUnassignedTodoItems()
        System.out.println("---------- findByUnassignedTodoItems() ----------");
//        Collection<Todo_Item> unassigned = tdDao.findByUnassignedTodoItems();
//        unassigned.forEach(System.out::println);


        //public Todo_Item update(Todo_Item todoItem)
        System.out.println("---------- update() ----------");
//        Todo_Item updateItem = new Todo_Item(31,"Exercise", "Playing Hockey",
//                LocalDate.parse("2021-02-20"),true,1);
//        Todo_Item updated = tdDao.update(updateItem);
//        System.out.println(updated);


        //public boolean deleteById(int id)
        System.out.println("---------- deleteById() ----------");
//        System.out.println(tdDao.deleteById(3));
    }
}
