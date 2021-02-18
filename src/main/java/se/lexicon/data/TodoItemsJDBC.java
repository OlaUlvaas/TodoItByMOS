package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import java.util.Collection;

public class TodoItemsJDBC implements TodoItems{
    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
