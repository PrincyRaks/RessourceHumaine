package obj;

import java.util.*;
import java.sql.Driver.*;
import java.sql.*;
import connect.*;
import java.lang.reflect.*;
import tool.*;

class Admin {
    String nomlog;
    String mdplog;
    ConnectDB con= null;

    Admin(String c_nom,String c_mdp){
        this.setMdplog(c_mdp);
        this.setNomlog(c_nom);
    }
    public Admin(){ }

    public String getMdplog() {
        return mdplog;
    }
    public String getNomlog() {
        return nomlog;
    }

    public void setMdplog(String mdplog) {
        this.mdplog = mdplog;
    }

    public void setNomlog(String nomlog) {
        this.nomlog = nomlog;
    }

    public ArrayList<Admin> getAllAdmin() throws Exception{
        ArrayList<Admin> list = new ArrayList<Admin>();
        Connection c = null;
        Statement req= null;
        ResultSet res = null;
        try {
            c = con.getConnectDB("rh", "rh");
            Object[] admin= Reflector.select(new Admin(),"login,mdp","rh",c,null);
            for (int i = 0; i < admin.length; i++) {
                list.add((Admin) admin[i]);
            }
            return list;
        } catch (Exception exc) {
            throw exc;       
        }
        finally{
            if (res!= null) res.close();
            if (req!= null) req.close();
            if (c!= null) c.close();  
        }
    }
}
