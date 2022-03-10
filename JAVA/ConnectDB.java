package connect;

import java.sql.Connection;
import java.sql.DriverManager.*;
import java.sql.SQLException;
import java.sql.*;

public class ConnectDB{
    private Connection con=null;
    
    public Connection getConnectDB(String user,String mdp){
        try {
            System.out.println("Mande");
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/rh", user, mdp);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return con;
    }
    
    public void CloseConnectDB() throws SQLException{
        con.close();
    }

    /*public static void main(String[] args) {
            ConnectDB conn=new ConnectDB();
            System.out.println(conn.getConnectDB("rh","rh"));
    }*/
}