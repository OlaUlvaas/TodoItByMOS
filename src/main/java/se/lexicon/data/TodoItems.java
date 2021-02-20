package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.util.Collection;

public interface TodoItems {

    Todo_Item create(Todo_Item todoItem);

    Todo_Item create2(Todo_Item todoItem);

    Collection<Todo_Item> findAll();

    Todo_Item findById(int id);

    Collection<Todo_Item> findByDoneStatus(boolean done);

    Collection<Todo_Item> findByAssignee(int id);

    Collection<Todo_Item> findByAssignee(Person person);

    Collection<Todo_Item> findByUnassignedTodoItems();

    Todo_Item update(Todo_Item todoItem);

    boolean deleteById(int id);

}
