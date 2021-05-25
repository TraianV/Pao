package ro.unibuc.programare_cabinet_medical.et3;


import ro.unibuc.programare_cabinet_medical.Programare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOProgramare {
    private static Connection dbConnection;
    private static DAOProgramare daoProgramare;

    private DAOProgramare(){
        try{
            if (dbConnection == null || dbConnection.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cabinet", "root", "root");
                createTable();
            }
        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void createTable() {
        final String query = "CREATE TABLE IF NOT EXISTS Programari (\n" +
                "id INT PRIMARY KEY , \n" +
                "Data VARCHAR(11) NOT NULL, \n" +
                "loc VARCHAR(80) NOT NULL, \n" +
                "Client VARCHAR(50) NOT NULL,\n" +
                "Medic VARCHAR(50) NOT NULL)";
        try  {
            Statement statement = dbConnection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DAOProgramare getDaoProgramare(){
        if(daoProgramare == null)
            daoProgramare = new DAOProgramare();
        return daoProgramare;
    }

    private Programare mapToProgramare(ResultSet resultSet) throws SQLException {
        Programare Programare = new Programare(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
        return Programare;
    }

    public void read(){
        List<Programare> Programare  = new ArrayList<>();
        final String query = "SELECT * FROM Programari";
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Programare.add(mapToProgramare(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong: ");
        }
    }

    public void write(Programare Programare) {

        final String query = "INSERT into Programari(Id, data, loc, Client, Medic) VALUES(?,?,?,?,?)";
        try {


            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, Programare.getId());
            preparedStatement.setString(2, Programare.getdata());
            preparedStatement.setString(3, Programare.getLoc());
            preparedStatement.setString(4, Programare.getClient());
            preparedStatement.setString(5, Programare.getMedic());
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void delete(Programare Programare){
        final String query= "DELETE FROM Programari WHERE ID=(?)";
        try {


            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, Programare.getId());
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

