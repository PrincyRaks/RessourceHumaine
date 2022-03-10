package obj;

import tool.*;
import java.sql.Date;
import java.sql.*;
import java.util.*;

import connect.ConnectDB;

public class Employe {
    private ConnectDB con= null;
    //int idEmployer;
    int idPoste;
    int idContrat;
    String nom;
    Date naissance;
    String sexe;
    Date embauche;
    String adresse;
    String mdp;
    String photo;

    public Employe(int CidPoste,int CidContrat,String Cnom,Date Cnaissance,
    String Csexe,Date Cembauche,String Cadresse,String Cmdp,String Cphoto){
        //this.setIdEmployer(CidEmployer);
        this.setIdPoste(CidPoste);
        this.setIdContrat(CidContrat);
        this.setNom(Cnom);
        this.setNaissance(Cnaissance);
        this.setSexe(Csexe);
        this.setEmbauche(Cembauche);
        this.setAdresse(Cadresse);
        this.setMdp(Cmdp);
        this.setPhoto(Cphoto);
    }
    public Employe(){ }

    public String getAdresse() {
        return adresse;
    }
    public Date getEmbauche() {
        return embauche;
    }
    public int getIdContrat() {
        return idContrat;
    }
    /*public int getIdEmployer() {
        return idEmployer;
    }*/
    public int getIdPoste() {
        return idPoste;
    }
    public String getMdp() {
        return mdp;
    }
    public Date getNaissance() {
        return naissance;
    }
    public String getNom() {
        return nom;
    }
    public String getPhoto() {
        return photo;
    }
    public String getSexe() {
        return sexe;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmbauche(Date embauche) {
        this.embauche = embauche;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }

   /* public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    } */

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void AjoutEmploye()throws Exception {
        Connection c = null;
        Statement req= null;
        ResultSet res = null;
        try {
            String sql= "insert into employee(idposte,idcontrat,nom,datenaissance,sexe,dateembauche,adresse,mdp,photo) values ("+ this.getIdPoste() +" , "+this.getIdContrat() 
            +" , '"+ this.getNom() +"' , '"+ this.getNaissance() +"' , '"+ this.getSexe() +"' , '" + this.getEmbauche()+"' , '"+ this.getAdresse()+"' , '" + 
            this.getMdp()+"' , '"+ this.getPhoto() + "')";
            c = con.getConnectDB("rh", "rh");
            req = c.createStatement();
            res = req.executeQuery(sql);
            System.out.println( sql);
        } catch (Exception e) {
            throw e;
        }
        finally{
            c.commit();
            if (res!= null) res.close();
            if (req!= null) req.close();
            if (c!= null) c.close();   
        }
    }
    
    public ArrayList<Employe> getAllEmploye() throws Exception{
        Connection c = null;
        Statement req= null;
        ResultSet res = null;
        try {
            c = con.getConnectDB("rh", "rh");
            Object[] employe=Reflector.select(new Employe(), " nom, nomposte,typecontrat ", "listeEmploye", c, "idemployee");
            ArrayList<Employe> list = new ArrayList<Employe>();
            for (int i = 0; i < employe.length; i++) {
                list.add((Employe)employe[i]);
            }
            return list;     
        } catch (Exception e) {
            throw e;
        }
        finally{
            if (res!= null) res.close();
            if (req!= null) req.close();
            if (c!= null) c.close();   
        }
    }

//Modifier!!!!!!!!
    /*public void ModifierEmploye() throws Exception{
        Connection c = null;
        Statement req= null;
        ResultSet res = null;
        try {
            String sql="Update employe set "+
        } catch (Exception e) {
            throw e;
        }
        finally{
            c.commit();
            if (res!= null) res.close();
            if (req!= null) req.close();
            if (c!= null) c.close();
        }
    }*/

}
