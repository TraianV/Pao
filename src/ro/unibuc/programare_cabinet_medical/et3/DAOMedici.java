package ro.unibuc.programare_cabinet_medical.et3;


        import ro.unibuc.programare_cabinet_medical.Medic;
        import ro.unibuc.programare_cabinet_medical.Programare;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;

public class DAOMedici {
    private static Connection dbConnection;
    private static DAOMedici daoMedici;

    private DAOMedici(){
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
        final String query = "CREATE TABLE IF NOT EXISTS Medici (\n" +
                "id INT PRIMARY KEY , \n" +
                "Name VARCHAR(80) NOT NULL, \n" +
                "loc VARCHAR(100) NOT NULL, \n" +
                "Nrtel VARCHAR(13) NOT NULL,\n" +
                "salariu Double NOT NULL)";
        try  {
            Statement statement = dbConnection.createStatement();
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DAOMedici getDaoMedici(){
        if(daoMedici == null)
            daoMedici = new DAOMedici();
        return daoMedici;
    }

    private Medic mapToMedici(ResultSet resultSet) throws SQLException {
        Medic medici = new Medic(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
        return medici;
    }

    public void read(){
        List<Medic> Medici  = new ArrayList<>();
        final String query = "SELECT * FROM Medici";
        try{
            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Medici.add(mapToMedici(resultSet));
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Something went wrong: ");
        }
    }

    public void write(Medic Medici) {

        final String query = "INSERT into Medici(Id, Name, loc, Nrtel, salariu) VALUES(?,?,?,?,?)";
        try {


            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, Medici.getId());
            preparedStatement.setString(2, Medici.getnume());
            preparedStatement.setString(3, Medici.getloc());
            preparedStatement.setString(4, Medici.getNrtel());
            preparedStatement.setDouble(5, Medici.getSalariu());
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void delete(Programare Programare){
        final String query= "DELETE FROM Medici WHERE ID=(?)";
        try {


            PreparedStatement preparedStatement = dbConnection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
            preparedStatement.setInt(1, Programare.getId());
            preparedStatement.execute();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
