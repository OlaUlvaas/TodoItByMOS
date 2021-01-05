package se.lexicon.data;


import java.lang.Comparable;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;
import java.util.Arrays;

import static java.util.Arrays.*;

public class TodoItems {
    private static Todo[] todoItemsArray = new Todo[0];

    public int size() {
        return todoItemsArray.length;
    }

    public Todo[] findAllThingsTodo() {
        return todoItemsArray;
    }

    public Todo findByTodoId(int todo_Id) {
        Todo findTodo = new Todo();
        int tempTODOID = 0;
        for (int i = 0; i < todoItemsArray.length; i++) {
            tempTODOID = todoItemsArray[i].getTODOID();
            if (tempTODOID == todo_Id) {
                findTodo = todoItemsArray[i];
            }
        }
        return findTodo;
    }

    public void addTodo(Todo newThingTodo) {
        Todo[] newtodoItemsArray = copyOf(todoItemsArray, todoItemsArray.length + 1);
        newtodoItemsArray[newtodoItemsArray.length - 1] = newThingTodo;
        todoItemsArray = newtodoItemsArray;
    }

    public void clear() {
        todoItemsArray = null;
    }

    public Todo[] findByDoneStatus(boolean doneStatus) {
        int countDone = 0;
        int countUnDone = 0;
        for (int i = 0; i < todoItemsArray.length; i++) {
            if (todoItemsArray[i].isDone() == true) {
                countDone++;
            } else {
                countUnDone++;
            }
        }

        Todo[] done = new Todo[countDone];
        Todo[] unDone = new Todo[countUnDone];

        int j = 0;
        int k = 0;

        for (int i = 0; i < todoItemsArray.length; i++) {
            if (todoItemsArray[i].isDone() == true) {
                if (countDone != 0) {
                    done[j] = todoItemsArray[i];
                    countDone--;
                    j++;
                }
            } else {
                if (countUnDone != 0) {
                    unDone[k] = todoItemsArray[i];
                    countUnDone--;
                    k++;
                }
            }
        }

        if (doneStatus == true) {
            return done;
        } else {
            return unDone;
        }
    }

    public Todo[] findByAssignee(int personId) {
        int counter = 0;

        for (int i = 0; i < todoItemsArray.length; i++) {
            if (todoItemsArray[i].getAssignee().getPERSONID() == personId) {
                counter++;
            }
        }
            Todo[] thingsIShouldDo = new Todo[counter];
            int k = 0;
            for (int j = 0; j < todoItemsArray.length; j++) {
                if (todoItemsArray[j].getAssignee().getPERSONID() == personId) {
                    thingsIShouldDo[k] = todoItemsArray[j];
                    k++;
                }
            }
        return thingsIShouldDo;
        }


    public Todo[] findByAssignee2(Person assignee){
        int counter = 0;

        for (int i = 0; i < todoItemsArray.length; i++) {
            if (todoItemsArray[i].getAssignee().getPERSONID() == assignee.getPERSONID()) {
                counter++;
            }
        }
        Todo[] thingsIShouldDo = new Todo[counter];
        int k = 0;
        for (int j = 0; j < todoItemsArray.length; j++) {
            if (todoItemsArray[j].getAssignee().getPERSONID() == assignee.getPERSONID()) {
                thingsIShouldDo[k] = todoItemsArray[j];
                k++;
            }
        }
        return thingsIShouldDo;
    }
    public Todo[] findUnassignedTodoItems(){
        int counter = 0;

        for (int i = 0; i < todoItemsArray.length; i++) {
            if (todoItemsArray[i].getAssignee() == null) {
                counter++;
            }
        }
        Todo[] thingsIShouldDo = new Todo[counter];
        int k = 0;
        for (int j = 0; j < todoItemsArray.length; j++) {
            if (todoItemsArray[j].getAssignee() == null) {
                thingsIShouldDo[k] = todoItemsArray[j];
                k++;
            }
        }
        return thingsIShouldDo;
    }

    public void removeTodo(int removePerson_Id){
        int index = -1;
        for(int i = 0; i < todoItemsArray.length; i++){
            if(todoItemsArray[i].getTODOID() == removePerson_Id){
                index = i;
                break;
            }
        }
        Todo[] newArray = new Todo[todoItemsArray.length - 1];

        for(int i = 0, k = 0; i < todoItemsArray.length; i++){
            if(i == index){
                continue;
            }
            newArray[k++] = todoItemsArray[i];
        }
        todoItemsArray = newArray;
    }

}
