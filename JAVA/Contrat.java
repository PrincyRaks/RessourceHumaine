package obj;

public class Contrat {
    int idcontrat;
    String typecontrat;
    String duree;

    Contrat(int c_idcont,String c_typecont,String c_duree){
        this.setDuree(c_duree);
        this.setIdcontrat(c_idcont);
        this.setTypecontrat(c_typecont);
    }

    public String getDuree() {
        return duree;
    }
    public int getIdcontrat() {
        return idcontrat;
    }
    public String getTypecontrat() {
        return typecontrat;
    }
    public void setDuree(String duree) {
        this.duree = duree;
    }
    public void setIdcontrat(int idcontrat) {
        this.idcontrat = idcontrat;
    }
    public void setTypecontrat(String typecontrat) {
        this.typecontrat = typecontrat;
    }

}
