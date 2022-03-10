package obj;

import connect.*;
import java.sql.Driver.*;
import java.io.IOException;
import java.sql.*;

public class Poste {
    int idposte;
    String nomposte;

    Poste(int c_idposte,String c_nomposte){
        this.setIdposte(c_idposte);
        this.setNomposte(c_nomposte);
    }

    public int getIdposte() {
        return idposte;
    }
    public String getNomposte() {
        return nomposte;
    }
    public void setIdposte(int idposte) {
        this.idposte = idposte;
    }
    public void setNomposte(String nomposte) {
        this.nomposte = nomposte;
    }

    /*public ArrayList<Poste> getAllPoste()throws IOException {
        ConnectDB con= null;
        Statement req= null;
        ResultSet res = null;
        try {
            String sql="select * from Poste";
            req = con.getConnectDB("rh", "rh").createStatement();
            res= req.executeQuery(sql);
            System.out.println(sql);
        } catch (IOException exc) {
            throw exc;       
        }
        finally{
            if (res!= null) res.close();
            if (req!= null) req.close();
            if (con!= null) con.close();  
        }
    }*/
}
