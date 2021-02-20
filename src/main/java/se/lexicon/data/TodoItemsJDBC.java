package se.lexicon.data;

import se.lexicon.data.dao.MySqlConnection;
import se.lexicon.model.Person;
import se.lexicon.model.Todo_Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemsJDBC implements TodoItems{
    @Override
    public Todo_Item create(Todo_Item item) {
        String query = "insert into todo_item (title, description, deadline, done, assignee_id) values (?, ?, ?, ?, ?)";
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {

            preparedStatement.setString(1, item.getTitle());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setDate(3, Date.valueOf(item.getDeadline()));
            preparedStatement.setBoolean(4, item.isDone());
            preparedStatement.setInt(5, item.getAssignee_id());

            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Created" : "Not created");
            ResultSet rs = preparedStatement.getGeneratedKeys();

            int idKey = 0;
            while(rs.next()){
                idKey = rs.getInt(1);

            }
            item.setTodo_id(idKey);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return item;



    }
    public Todo_Item create2(Todo_Item item) {
        String query = "insert into todo_item (title, description, deadline, done) values (?, ?, ?, ?)";
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {

            preparedStatement.setString(1, item.getTitle());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setDate(3, Date.valueOf(item.getDeadline()));
            preparedStatement.setBoolean(4, item.isDone());
            //preparedStatement.setInt(5, item.getAssignee_id());

            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Created" : "Not created");
            ResultSet rs = preparedStatement.getGeneratedKeys();

            int idKey = 0;
            while(rs.next()){
                idKey = rs.getInt(1);

            }
            item.setTodo_id(idKey);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Collection<Todo_Item> findAll() {
        String query = "select * from todo_item";
        List<Todo_Item> items = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                items.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Todo_Item findById(int id) {
        String query = "select * from todo_item where todo_id=?";
        Todo_Item item = new Todo_Item();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                item.setTodo_id(resultSet.getInt("todo_id"));
                item.setTitle(resultSet.getString("title"));
                item.setDescription(resultSet.getString("description"));
                item.setDeadline(resultSet.getDate("deadline").toLocalDate());
                item.setDone(resultSet.getBoolean("done"));
                item.setAssignee_id(resultSet.getInt("assignee_id"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public Collection<Todo_Item> findByDoneStatus(boolean status) {
        String query = "select * from todo_item where done=?";
        List<Todo_Item> items = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setBoolean(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                items.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    @Override
    public Collection<Todo_Item> findByAssignee(Person assignee) {
        String query = "select * from todo_item where assignee_id=?";
        List<Todo_Item> items = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1, assignee.getPerson_Id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                items.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;

    }


    @Override
    public Collection<Todo_Item> findByAssignee(int assignee) {
        String query = "select * from todo_item where assignee_id=?";
        List<Todo_Item> items = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1, assignee);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                items.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;


    }

    @Override
    public Collection<Todo_Item> findByUnassignedTodoItems() {
        String query = "select * from todo_item where assignee_id is null";
        Collection <Todo_Item> items = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                items.add(new Todo_Item(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getBoolean(5)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Todo_Item update(Todo_Item item) {
        String query = "update todo_item set title = ?, description = ?, " +
                "deadline = ?, done = ?, assignee_id = ? where todo_id = ?";
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setString(1, item.getTitle());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setString(3,item.getDeadline().toString());
            preparedStatement.setBoolean(4,item.isDone());
            preparedStatement.setInt(5,item.getAssignee_id());
            preparedStatement.setInt(6, item.getTodo_id());


            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Updated" : "Not updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "delete from todo_item where todo_id = ?";
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1, id);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Deleted" : "Not deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
