package bo;

import java.io.Serializable;

public class Classement implements Serializable {

    private int id;
    private int rang;
    private String nom;

    public Classement() {}

    public Classement(int rang, String nom) {
        this.rang = rang;
        this.nom = nom;
    }

    public Classement(int id, int rang, String nom) {
        this.id = id;
        this.rang = rang;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
