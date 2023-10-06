package db;

import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;

    static
    {
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

    public static List<Item> getItems(){
        List<Item> items = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"itemShop\".items"
            );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

//    public static void addItem(Item item){
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                    "INSERT INTO \"itemShop\".items(name, description, price) " +
//                            "VALUES(?, ?, ?)"
//            );
//            preparedStatement.setString(1, item.getName());
//            preparedStatement.setString(2, item.getDescription());
//            preparedStatement.setString(2, item.getPrice());
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
