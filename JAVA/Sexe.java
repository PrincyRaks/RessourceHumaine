package obj;

public class Sexe {
    int idsexe;
    String nomsexe;

    Sexe(int c_id,String c_nom){
        this.setIdsexe(c_id);
        this.setNomsexe(c_nom);
    }

    public int getIdsexe() {
        return idsexe;
    }
    public String getNomsexe() {
        return nomsexe;
    }
    public void setIdsexe(int idsexe) {
        this.idsexe = idsexe;
    }
    public void setNomsexe(String nomsexe) {
        this.nomsexe = nomsexe;
    }

}

