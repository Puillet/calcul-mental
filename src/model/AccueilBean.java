package model;

import bo.Question;
import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccueilBean implements Serializable {

    private List<User> listUsers;

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public AccueilBean() {
    }

    public void getUsers(){
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        listUsers = dao.findAll();
    }


}

