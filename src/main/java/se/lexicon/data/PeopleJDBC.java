package se.lexicon.data;

import com.mysql.cj.MysqlConnection;
import se.lexicon.data.dao.MySqlConnection;
import se.lexicon.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PeopleJDBC implements People{

    @Override
    public Person create(Person person) {

        String query = "insert into person (first_Name, last_Name) values (?, ?)";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {

            preparedStatement.setString(1, person.getFirst_Name());
            preparedStatement.setString(2, person.getLast_Name());



            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Created" : "Not created");
            ResultSet rs = preparedStatement.getGeneratedKeys();

            int idKey = 0;
            while(rs.next()){
                idKey = rs.getInt(1);
            }
            person.setPerson_Id(idKey);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        String query = "select * from person";
        List<Person> presidents = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                presidents.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return presidents;
    }

    @Override
    public Person findById(int id) {

        String query = "select * from person where person_id=?";
        Person person = new Person();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                person.setPerson_Id(resultSet.getInt("person_id"));
                person.setFirst_Name(resultSet.getString("first_name"));
                person.setLast_Name(resultSet.getString("last_name"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Collection<Person> findByName(String president) {

        String query = "select * from person where first_name=?";
        List <Person> presidents = new ArrayList<>();
        try(
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ) {
            preparedStatement.setString(1, president);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                presidents.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return presidents;
    }

    @Override
    public Person update(Person person) {

        String query = "update person set first_name=?, last_name=? where person_id= ?";

        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
        ){
            preparedStatement.setString(1, person.getFirst_Name());
            preparedStatement.setString(2, person.getLast_Name());
            preparedStatement.setInt(3, person.getPerson_Id());


            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Updated" : "Not updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "delete from person where person_id= ?";
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
