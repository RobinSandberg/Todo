package se.lexicon.robincarl.data;

import se.lexicon.robincarl.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeopleDAOImpl implements PeopleDAO{

    private static final String FIND_ALL_STRING = "SELECT * FROM person";
    private static final String FIND_BY_ID_STRING = "SELECT * FROM person WHERE person_id = ?";
    private static final String FIND_By_NAME_STRING = "SELECT * FROM person WHERE first_name LIKE ? OR last_name LIKE ?";
    private static final String CHECK_FOR_NAME_STRING = "SELECT * FROM person WHERE first_name LIKE ? AND last_name LIKE ?";
    private static final String CREATE_PERSON_STRING = "INSERT INTO person (first_name, last_name) VALUES (?,?)";
    private static final String UPDATE_PERSON_STRING = "UPDATE person SET first_name = ? , last_name = ? WHERE person_id = ?";
    private static final String DELETE_PERSON_STRING = "SELECT * FROM person WHERE person_id = ?";
    private static ResultSet resultSet = null;

    @Override
    public List<Person> findAll(){
        List<Person> allPeople = new ArrayList<>();
        try(Connection connection = ConnectionOpener.getConnection(); PreparedStatement findAllPeople = connection.prepareStatement(FIND_ALL_STRING)){
            resultSet = findAllPeople.executeQuery();
            while (resultSet.next()){
                allPeople.add(new Person(resultSet.getInt("person_id"),resultSet.getString("first_name"),
                        resultSet.getString("last_name")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return allPeople;
    }

    @Override
    public Person findById(int personId){
        Person foundPerson = null;
        try(Connection connection = ConnectionOpener.getConnection(); PreparedStatement findById = connection.prepareStatement(FIND_BY_ID_STRING)){
            findById.setInt(1,personId);
            resultSet = findById.executeQuery();
            while (resultSet.next()){
                foundPerson = new Person(resultSet.getInt("person_id"),resultSet.getString("first_name"),
                        resultSet.getString("last_name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return foundPerson;
    }

    @Override
    public List<Person> findByName(String PersonName){
        List<Person> foundPeople = new ArrayList<>();
        try(Connection connection = ConnectionOpener.getConnection(); PreparedStatement findByName = connection.prepareStatement(FIND_By_NAME_STRING)){
            findByName.setString(1, PersonName+"%");
            findByName.setString(2, PersonName+"%");
            resultSet = findByName.executeQuery();
            while (resultSet.next()){
                foundPeople.add(new Person(resultSet.getInt("person_id"),resultSet.getString("first_name"),
                        resultSet.getString("last_name")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return foundPeople;
    }

    @Override
    public boolean addPerson(Person person){
        boolean successfullyAdded = false;
        try(Connection connection = ConnectionOpener.getConnection(); PreparedStatement createPerson = connection.prepareStatement(CREATE_PERSON_STRING)){
            Person foundPerson = CheckForPerson(person.getFirstName(),person.getLastName());
            if(foundPerson == null){
                createPerson.setString(1,person.getFirstName());
                createPerson.setString(2,person.getLastName());
                createPerson.executeUpdate();
                successfullyAdded = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return successfullyAdded;
    }

    @Override
    public Person updatePerson(Person person){
        try(Connection connection = ConnectionOpener.getConnection(); PreparedStatement updatePerson = connection.prepareStatement(UPDATE_PERSON_STRING)){
            updatePerson.setString(1,person.getFirstName());
            updatePerson.setString(2,person.getLastName());
            updatePerson.setInt(3, person.getPersonId());
            updatePerson.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return findById(person.getPersonId());
    }

    @Override
    public boolean deletePerson(int personId){
        boolean successfullyDeleted = false;
        try(Connection connection = ConnectionOpener.getConnection(); PreparedStatement deleteById = connection.prepareStatement(DELETE_PERSON_STRING)){
            deleteById.setInt(1,personId);
            deleteById.executeUpdate();
            successfullyDeleted = true;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return successfullyDeleted;
    }

    public Person CheckForPerson(String first_name,String last_name){
        Person foundPerson = null;
        try(Connection connection = ConnectionOpener.getConnection(); PreparedStatement findByName = connection.prepareStatement(CHECK_FOR_NAME_STRING)){
            findByName.setString(1, first_name);
            findByName.setString(2, last_name);
            resultSet = findByName.executeQuery();
            while (resultSet.next()){
                foundPerson = new Person(resultSet.getInt("person_id"),resultSet.getString("first_name"),
                        resultSet.getString("last_name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return foundPerson;
    }

}
