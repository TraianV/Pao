package ro.unibuc.programare_cabinet_medical.et3;

import ro.unibuc.programare_cabinet_medical.audit;

import java.sql.*;

public class DatabaseConfig{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection databaseConnection;

    private DatabaseConfig() {

        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }

    }
    private void createdatabase(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            final String query = "CREATE DATABASE IF NOT EXISTS Cabinet";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        finally {
            try{
                if (connection!= null){
                    connection.close();
                }
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
