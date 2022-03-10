package obj;

import java.sql.Date;

public class Personne{
    int idpersonne;
    int idsexe;
    int idposte;
    String nom;
    String prenom;
    Date datenaissance;
    String adresse;
    String CIN;
    String contact;
    String CV;
    
    Personne(int c_idpers,int c_idsex,int c_idpost,String c_nom,String c_prenom,Date c_datenaissance
    ,String c_adresse,String c_CIN,String c_contact,String c_CV){
        this.setAdresse(c_adresse);
        this.setCIN(c_CIN);
        this.setCV(c_CV);
        this.setContact(c_contact);
        this.setDatenaissance(c_datenaissance);
        this.setIdpersonne(c_idpers);
        this.setIdposte(c_idpost);
        this.setIdsexe(c_idsex);
        this.setNom(c_nom);
        this.setPrenom(c_prenom);
    }
    Personne(){ }
    public int getIdpersonne() {
        return idpersonne;
    }
    public int getIdsexe() {
        return idsexe;
    }
    public int getIdposte() {
        return idposte;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public Date getDatenaissance() {
        return datenaissance;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getCIN() {
        return CIN;
    }
    public String getCV() {
        return CV;
    }
    public String getContact() {
        return contact;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }
    public void setIdsexe(int idsexe) {
        this.idsexe = idsexe;
    }
    public void setIdposte(int idposte) {
        this.idposte = idposte;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setCIN(String cIN) {
        CIN = cIN;
    }
    public void setCV(String cV) {
        CV = cV;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

}