package bo;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String login;
    private String password;
    private int meilleurScore;

    public User() {}

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, int meilleurScore) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.meilleurScore = meilleurScore;
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

    public int getMeilleurScore() {
        return meilleurScore;
    }

    public void setMeilleurScore(int meilleurScore) {
        this.meilleurScore = meilleurScore;
    }
}
