package db;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/shop-db?currentSchema=itemShop",
                    "postgres",
                    "postgres"
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> getUsers(){
        List<User> users = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"itemShop\".USERS"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                users.add(user);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static User authorizationUser(String email, String password){
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"itemShop\".users WHERE EMAIL = ? AND PASSWORD = ?"
            );
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void editUser(User user){
        if(user == null){
            return;
        }
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE \"itemShop\".users " +
                            "SET EMAIL = ?, PASSWORD = ?, FULL_NAME = ? " +
                            "WHERE ID = ?"
            );
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setLong(4, user.getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static User getUserById(Long id){
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"itemShop\".USERS WHERE ID = ?"
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("fuLL_name"));
                user.setPassword(resultSet.getString("password"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
