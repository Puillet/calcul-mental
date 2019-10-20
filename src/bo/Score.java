package bo;

import java.io.Serializable;

public class Score implements Serializable {

    private int id;
    private int resultat;
    private int userId;

    public Score() {}

    public Score(int resultat, int userId) {
        this.resultat = resultat;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
