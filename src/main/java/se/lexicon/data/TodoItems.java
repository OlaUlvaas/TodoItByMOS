package se.lexicon.data;

/**
 *          10.Add the following methods to TodoItems class
 *          a.public Todo[] findByDoneStatus(boolean doneStatus)
 *          –Returns array with objects that has a matching done status.
 *          b.public Todo[] findByAssignee(int personId)
 *          –Returns array with objects that has an assignee with a personId matching.
 *          c.public Todo[] findByAssignee(Person assignee)
 *          –Returns array with objects that has sent in Person.
 *          d.public Todo[] findUnassignedTodoItems()
 *          –Returns an array of objects that does not have an assignee set.
 *          e.Unit test changes
 *          f.Commit.
 *
 *          11.Add the following to TodoItems AND People class.
 *          a.Functionality to remove object from array.(not nulling)
 *          First:you need to find the correct array index of the object.
 *          Second: You need to rebuild array by excluding the object on found index.
 *          b.Unit test changes
 *          c.Commit and Push to GitHub
 */
import java.lang.Comparable;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;
import java.util.Arrays;
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
        Todo[] newtodoItemsArray = Arrays.copyOf(todoItemsArray, todoItemsArray.length + 1);
        newtodoItemsArray[newtodoItemsArray.length - 1] = newThingTodo;
        todoItemsArray = newtodoItemsArray;
    }
    public void clear (){
        todoItemsArray = null;
        //Arrays.fill(peopleArray, null);
    }

    // Uppgift 10 a
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

        Todo[] done = new Todo[countDone]; //3
        Todo[] unDone = new Todo[countUnDone];
        int lengthDone = countDone;
        int lengthUnDone = countUnDone;//2
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

    // 10 b
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

    // 10 c
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
    public int remove(int removePerson_Id) {
        int index = 0;
        for(int i = 0; i < todoItemsArray.length ; i++){
          If(todoItemsArray[i].getAssignee().getPERSONID() == removePerson_Id){
              index = i;
            }
        }
        return index;
        /*Person[] newPeopleArray = Arrays.copyOf(peopleArray, peopleArray.length + 1);
        newPeopleArray[newPeopleArray.length - 1] = newPerson;
        peopleArray = newPeopleArray;*/
    }
    /*Hitta index
    splitta före index spara i array
    splitta efter index spara i array
    merga båda arrayerna

     */
}
