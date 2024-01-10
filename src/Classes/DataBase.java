
package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    
    private final String user = "user";
    private final String pass = "password";
    private final String connection_string = "jdbc:mysql://localhost:3306/cotizationapp";
    private static Connection Connection;

    public DataBase() {
        setConnection();
    }
    
    
    private void setConnection(){
        try {
            // Load and register sql dtriver.
            Class.forName("com.mysql.jdbc.Driver");
            // Create connection.
            this.Connection = DriverManager.getConnection(connection_string, user, pass);
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection(){
        try {
            this.Connection.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertClient(Client Client){        
        try {
            String query = "INSERT INTO `client` (`name`, `cellphone`, `email`) VALUES ('"
                    + Client.getName() +"', '"
                    + Client.getCellphone()+"', '"
                    + Client.getEmail()+"')";
            Statement statement = Connection.createStatement();
            int rows_affected = statement.executeUpdate(query);
            return rows_affected > 0;
        }
        catch (SQLException ex) {
            // Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean insertCase(Case Case){        
        try {
            String query = "INSERT INTO `exercise` (`client`, `type`, `language`, `exercise_number`, `days`, `price`) VALUES ('"
                    +Case.getClient()+"',"
                    + " '"+Case.getType()+"',"
                    + " '"+Case.getLanguage()+"',"
                    + " '"+Case.getExercise_number()+"',"
                    + " '"+Case.getDays()+"',"
                    + " '"+Case.getPrice()+"')";
            Statement statement = Connection.createStatement();
            int rows_affected = statement.executeUpdate(query);
            return rows_affected > 0;
        }
        catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
    public ResultSet listClients(){
        try{
            String query = "SELECT * FROM client ORDER BY name ASC";
            Statement statement = Connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            
            return resultset;
        }
        catch(SQLException ex){
            System.out.println("ex = " + ex);
        }
        return null;
    }
    
    public ResultSet listTelcodes(){
        try{
            String query = "SELECT code FROM telcodes ORDER BY country ASC";
            Statement statement = Connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);
            
            return resultset;
        }
        catch(SQLException ex){
            System.out.println("ex = " + ex);
        }
        return null;
    }
    
    public ResultSet searchClient(String mail){
        try{
            String query = "SELECT * FROM client WHERE email = '"+mail+"'";
            Statement statement = Connection.createStatement();
            ResultSet resultset = statement.executeQuery(query);            
            return resultset;
        }
        catch(SQLException ex){
            System.out.println("ex = " + ex);
        }
        return null;
    }
}
