package bo;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String login;
    private String password;
    private int meilleur_score;

    public User() {}

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, int meilleur_score) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.meilleur_score = meilleur_score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMeilleur_score() {
        return meilleur_score;
    }

    public void setMeilleur_score(int meilleur_score) {
        this.meilleur_score = meilleur_score;
    }
}
