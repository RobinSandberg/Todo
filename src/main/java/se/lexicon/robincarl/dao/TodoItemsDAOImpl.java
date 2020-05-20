package se.lexicon.robincarl.dao;

import se.lexicon.robincarl.model.Person;
import se.lexicon.robincarl.model.Todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static se.lexicon.robincarl.dao.DatabaseConnection.getConnection;

public class TodoItemsDAOImpl implements TodoItemsDAO{

    private static final String FIND_ALL_STRING = "SELECT * FROM todo_item";
    private static final String FIND_BY_ID_STRING = "SELECT * FROM todo_item WHERE todo_id = ?";
    private static final String FIND_By_DONE_STATUS_STRING = "SELECT * FROM todo_item WHERE done = ?";
    private static final String FIND_BY_ASSIGNEE_STRING = "SELECT * FROM todo_item WHERE assignee_id = ?";
    private static final String FIND_BY_UNASSIGNED_STRING = "SELECT * FROM todo_item WHERE assignee_id IS NULL";
    private static final String CHECK_FOR_TODO_STRING = "SELECT * FROM todo_item WHERE title LIKE ? AND description LIKE ?" +
            "AND deadline = ? AND done = ?";
    private static final String CREATE_TODO_ASSIGNEE_STRING = "INSERT INTO todo_item (title, description, deadline, done, assignee_id) VALUES (?,?,?,?,?)";
    private static final String UPDATE_TODO_STRING = "UPDATE todo_item SET title = ? , description = ?, deadline = ?" +
            ", done = ? , assignee_id = ? WHERE todo_id = ?";
    private static final String DELETE_TODO_STRING = "DELETE FROM todo_item WHERE todo_id = ?";
    private static ResultSet resultSet = null;


    @Override
    public List<Todo> findAll() {
        List<Todo> foundTodoList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement findAll = connection.prepareStatement(FIND_ALL_STRING)){
            resultSet = findAll.executeQuery();
            while (resultSet.next()){
                foundTodoList.add(new Todo(resultSet.getInt("todo_id"),resultSet.getString("title"),
                        resultSet.getString("description"),resultSet.getDate("deadline"),
                        resultSet.getBoolean("done"),resultSet.getInt("assignee_id")));
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
        return foundTodoList;
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
    public List<Todo> findByDoneStatus(boolean status) {
        List<Todo> foundTodoList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement findByDoneStatus = connection.prepareStatement(FIND_By_DONE_STATUS_STRING)){
            findByDoneStatus.setBoolean(1,status);
            resultSet = findByDoneStatus.executeQuery();
            while (resultSet.next()){
                foundTodoList.add(new Todo(resultSet.getInt("todo_id"),resultSet.getString("title"),
                        resultSet.getString("description"),resultSet.getDate("deadline"),
                        resultSet.getBoolean("done"),resultSet.getInt("assignee_id")));
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
        return foundTodoList;
    }

    @Override
    public List<Todo> findByAssignee(int personId) {
        List<Todo> foundTodoList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement findByAssigneeId = connection.prepareStatement(FIND_BY_ASSIGNEE_STRING)){
            findByAssigneeId.setInt(1,personId);
            resultSet = findByAssigneeId.executeQuery();
            while (resultSet.next()){
                foundTodoList.add(new Todo(resultSet.getInt("todo_id"),resultSet.getString("title"),
                        resultSet.getString("description"),resultSet.getDate("deadline"),
                        resultSet.getBoolean("done"),resultSet.getInt("assignee_id")));
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
        return foundTodoList;
    }

    @Override
    public List<Todo> findByAssignee(Person person) {
        List<Todo> foundTodoList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement findByAssignee = connection.prepareStatement(FIND_BY_ASSIGNEE_STRING)){
            findByAssignee.setInt(1,person.getPersonId());
            resultSet = findByAssignee.executeQuery();
            while (resultSet.next()){
                foundTodoList.add(new Todo(resultSet.getInt("todo_id"),resultSet.getString("title"),
                        resultSet.getString("description"),resultSet.getDate("deadline"),
                        resultSet.getBoolean("done"),resultSet.getInt("assignee_id")));
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
        return foundTodoList;
    }

    @Override
    public List<Todo> findByUnassignedTodoItems() {
        List<Todo> foundTodoList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement findByUnassigned = connection.prepareStatement(FIND_BY_UNASSIGNED_STRING)){
            resultSet = findByUnassigned.executeQuery();
            while (resultSet.next()){
                foundTodoList.add(new Todo(resultSet.getInt("todo_id"),resultSet.getString("title"),
                        resultSet.getString("description"),resultSet.getDate("deadline"),
                        resultSet.getBoolean("done"),resultSet.getInt("assignee_id")));
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
        return foundTodoList;
    }

    @Override
    public Todo create(Todo todo){
        Todo addedTodo = null;
        try(Connection connection = getConnection(); PreparedStatement createTodo = connection.prepareStatement(CREATE_TODO_ASSIGNEE_STRING, Statement.RETURN_GENERATED_KEYS)){
            Todo foundTodo = CheckForTodo(todo);
            if(foundTodo == null){
                createTodo.setString(1,todo.getTitle());
                createTodo.setString(2,todo.getDescription());
                createTodo.setDate(3,todo.getDeadline());
                createTodo.setBoolean(4,todo.getDone());
                if(todo.getAssignee_id() > 0){
                    PeopleDAOImpl people = new PeopleDAOImpl();
                    Person person = people.findById(todo.getAssignee_id());
                    if(person != null) {
                        createTodo.setInt(5, person.getPersonId());
                    }else{
                        createTodo.setNull(5, java.sql.Types.INTEGER);
                    }
                }else{
                    createTodo.setNull(5, java.sql.Types.INTEGER);
                }
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

    public Todo update(Todo todo){
        try(Connection connection = getConnection(); PreparedStatement updateTodo = connection.prepareStatement(UPDATE_TODO_STRING)){
            updateTodo.setString(1,todo.getTitle());
            updateTodo.setString(2,todo.getDescription());
            updateTodo.setDate(3,todo.getDeadline());
            updateTodo.setBoolean(4,todo.getDone());
            updateTodo.setInt(5,todo.getAssignee_id());
            updateTodo.setInt(6,todo.getTodoId());
            updateTodo.executeUpdate();
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
        return findById(todo.getTodoId());
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

    public Todo CheckForTodo(Todo todo){
        Todo foundTodo = null;
        try(Connection connection = getConnection(); PreparedStatement findByTitle = connection.prepareStatement(CHECK_FOR_TODO_STRING)){
            findByTitle.setString(1, todo.getTitle());
            findByTitle.setString(2, todo.getDescription());
            findByTitle.setDate(3, todo.getDeadline());
            findByTitle.setBoolean(4, todo.getDone());
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
