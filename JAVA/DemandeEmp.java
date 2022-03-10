package obj;

import java.io.ObjectInputStream.GetField;

public class DemandeEmp {
    int iddemande;
    int idpersonne;
    int estvalide;

    DemandeEmp(int c_iddemande,int c_idpersonne,int c_valide){
        this.setEstvalide(c_valide);
        this.setIddemande(c_iddemande);
        this.setIdpersonne(c_idpersonne);    
    }

    public int getEstvalide() {
        return estvalide;
    }
    public int getIddemande() {
        return iddemande;
    }
    public int getIdpersonne() {
        return idpersonne;
    }
    public void setEstvalide(int estvalide) {
        this.estvalide = estvalide;
    }
    public void setIddemande(int iddemande) {
        this.iddemande = iddemande;
    }
    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }
       
}
