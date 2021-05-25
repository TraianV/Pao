package ro.unibuc.programare_cabinet_medical.et3;


import ro.unibuc.programare_cabinet_medical.Client;
import ro.unibuc.programare_cabinet_medical.Medic;
import ro.unibuc.programare_cabinet_medical.Programare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOClienti {
    private static Connection dbConnection;
    private static DAOClienti daoClienti;

    private DAOClienti(){
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
        final String query = "CREATE TABLE IF NOT EXISTS Clienti (\n" +
                "id INT PRIMARY KEY , \n" +
                "Name VARCHAR(80) NOT NULL, \n" +
                "data_nasterii VARCHAR(11) NOT NULL, \n" +
                "Adresa VARCHAR(30) NOT NULL)";
        try  {
            Statement statement = dbConnection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DAOClienti getDaoClienti(){
        if(daoClienti == null)
            daoClienti = new DAOClienti();
        return daoClienti;
    }

    private Client mapToClienti(ResultSet resultSet) throws SQLException {
        Client Clienti = new Client(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
        return Clienti;
    }

    public void read(){
        List<Client> Clienti  = new ArrayList<>();
        final String query = "SELECT * FROM Clienti";
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Clienti.add(mapToClienti(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong: ");
        }
    }

    public void write(Client Clienti) {

        final String query = "INSERT into Clienti(Id, Name, datan_nasterii, adresa) VALUES(?,?,?,?)";
        try {


            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, Clienti.getId());
            preparedStatement.setString(2, Clienti.getUserName());
            preparedStatement.setString(3, Clienti.getdatan());
            preparedStatement.setString(4, Clienti.getAdress());
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void delete(Programare Programare){
        final String query= "DELETE FROM Clienti WHERE ID=(?)";
        try {


            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, Programare.getId());
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
