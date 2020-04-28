package se.lexicon.robincarl.dao;

import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;

import java.sql.*;
import java.util.List;

import static se.lexicon.robincarl.dao.DatabaseConnection.getConnection;

public class TodoItemsDAOImpl implements TodoItemsDAO{

    //todo_id, title , description , deadline, done, assignee_id
    private static final String FIND_ALL_STRING = "SELECT * FROM todo_item";
    private static final String FIND_BY_ID_STRING = "SELECT * FROM todo_item WHERE todo_id = ?";
    private static final String FIND_By_DONE_STATUS_STRING = "SELECT * FROM todo_item WHERE first_name LIKE ? OR last_name LIKE ?";
    private static final String FIND_BY_ASSIGNEE_STRING = "SELECT * FROM todo_item WHERE assignee_id = ?";
    private static final String FIND_BY_UNASSIGNED_STRING = "SELECT * FROM todo_item WHERE assignee_id = ?";
    private static final String CHECK_FOR_TITLE_STRING = "SELECT * FROM todo_item WHERE title LIKE ?";
    private static final String CREATE_TODO_STRING = "INSERT INTO todo_item (title, description, deadline, done) VALUES (?,?,?,?)";
    private static final String UPDATE_TODO_STRING = "UPDATE todo_item SET title = ? , description = ?, deadline = ?" +
            ", done = ? , assignee_id = ? WHERE todo_id = ?";
    private static final String DELETE_TODO_STRING = "DELETE FROM todo_item WHERE todo_id = ?";
    private static ResultSet resultSet = null;


    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int Id) {
        Todo foundTodo = null;
        try(Connection connection = getConnection(); PreparedStatement findById = connection.prepareStatement(FIND_BY_ID_STRING)){
            findById.setInt(1, Id);
            resultSet = findById.executeQuery();
            if(resultSet.next()){
                foundTodo = new Todo(resultSet.getInt("todo_id"),resultSet.getString("title"),
                        resultSet.getString("description"),resultSet.getDate("deadline"),
                        resultSet.getBoolean("done"),resultSet.getInt("assignee_id"));
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
        return foundTodo;
    }

    @Override
    public List<Todo> findByDoneStatus(boolean Status) {

        return null;
    }

    @Override
    public List<Todo> findByAssignee(int personId) {

        return null;
    }

    @Override
    public List<Todo> findByAssignee(Person person) {

        return null;
    }

    @Override
    public List<Todo> findByUnassignedTodoItems() {

        return null;
    }

    @Override
    public Todo create(Todo todo){
        Todo addedTodo = null;
        try(Connection connection = getConnection(); PreparedStatement createTodo = connection.prepareStatement(CREATE_TODO_STRING, Statement.RETURN_GENERATED_KEYS)){
            Todo foundTodo = CheckForTodo(todo.getTitle());
            if(foundTodo == null){
                createTodo.setString(1,todo.getTitle());
                createTodo.setString(2,todo.getDescription());
                createTodo.setDate(3,todo.getDeadline());
                createTodo.setBoolean(4,todo.getDone());
                createTodo.executeUpdate();
                resultSet = createTodo.getGeneratedKeys();
                if(resultSet.next()){
                    addedTodo = findById(resultSet.getInt(1));
                }
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
        return addedTodo;
    }

    @Override
    public boolean deleteById(int Id){
        boolean successfullyDeleted = false;
        try(Connection connection = getConnection(); PreparedStatement deleteTodo = connection.prepareStatement(DELETE_TODO_STRING)){
            deleteTodo.setInt(1,Id);
            deleteTodo.executeUpdate();
            successfullyDeleted = true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return successfullyDeleted;
    }

    public Todo CheckForTodo(String title){
        Todo foundTodo = null;
        try(Connection connection = getConnection(); PreparedStatement findByTitle = connection.prepareStatement(CHECK_FOR_TITLE_STRING)){
            findByTitle.setString(1, title);
            resultSet = findByTitle.executeQuery();
            while (resultSet.next()){
                foundTodo = new Todo(resultSet.getInt("todo_id"),resultSet.getString("title"),
                        resultSet.getString("description"), resultSet.getDate("deadline"),
                        resultSet.getBoolean("done"),resultSet.getInt("assignee_id"));
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
        return foundTodo;
    }
}
