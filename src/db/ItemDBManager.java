package db;

import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDBManager {
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

    public static List<Item> getItems(Integer limit) {
        List<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement = null;
            if (limit == null) {
                statement = connection.prepareStatement(
                        "SELECT * FROM \"itemShop\".items ORDER BY id"
                );
            } else {
                statement = connection.prepareStatement(
                        "SELECT * FROM \"itemShop\".items ORDER BY id limit ?"
                );
                statement.setInt(1, limit);
            }

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(Item item) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO \"itemShop\".items(name, description, price) " +
                            "VALUES(?, ?, ?)"
            );
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Item getItemById(Long id) {
        Item item = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM \"itemShop\".items WHERE id = ?"
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = new Item();
                item.setId(id);
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public static void editItemById(Item item) {
        if (item == null)
            return;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE \"itemShop\".items " +
                    "SET NAME = ?, DESCRIPTION = ?, PRICE = ? WHERE ID = ?"
            );
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteItemById(Long id) {
        if (id != null) {
            try {
                PreparedStatement statement = connection.prepareStatement(
                        "DELETE FROM \"itemShop\".items WHERE id = ?"
                );
                statement.setLong(1, id);
                statement.executeUpdate();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
