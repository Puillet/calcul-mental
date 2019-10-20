package bo;

import java.io.Serializable;

public class Score implements Serializable {

    private int id;
    private int score;
    private int idUser;

    public Score() {}

    public Score(int score, int idUser) {
        this.score = score;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
