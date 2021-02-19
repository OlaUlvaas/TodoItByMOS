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

        //////////// PERSON ////////////////////////////
        System.out.println("---------- create() ----------");
        //Person newPerson1 = dao.create(new Person("Ola", "Ulvås"));
        //Person newPerson2 = dao.create(new Person("Donald", "Trump"));
        //Person newPerson3 = dao.create(new Person("Ronald", "Reagan"));
        //Person newPerson4 = dao.create(new Person("Richard", "Nixon"));



        System.out.println("---------- findAll() ----------");
        Collection<Person> presidents = dao.findAll();
        //presidents.forEach(System.out::println);


        System.out.println("---------- findById() ----------");
        Person p = dao.findById(7);
        System.out.println(p);


        System.out.println("---------- findByName() ----------");
        Collection<Person> trump = dao.findByName("Donald");
        System.out.println(trump);


        System.out.println("---------- update() ----------");
//        Person p2 = new Person(4, "Donald", "Trumpp");
//        System.out.println(dao.update(p2));


        System.out.println("---------- deleteById() ----------");
        boolean delete = dao.deleteById(5);
        System.out.println(delete);


        //title, description, deadline, done, assignee_id)

        TodoItems tdDao = new TodoItemsJDBC();

        //////////// TODO_ITEM ////////////////////////////
        System.out.println("---------- create() ----------");
        Todo_Item tdItem1 = tdDao.create(new Todo_Item("Build", "Build the wall", LocalDate.of(2021,12,31), false,4));
        Todo_Item tdItem2 = tdDao.create(new Todo_Item("Drain", "Drain the swamp", LocalDate.of(2021,7,1), false,6));


    }
}
