package model;

import bo.Classement;

import javax.servlet.http.HttpServletRequest;

public class ClassementBean {

    private Classement classement;

    public ClassementBean() {}

    public Classement getClassement() {
        return classement;
    }

    public void setClassement( Classement classement ) {
        this.classement = classement;
    }

}
