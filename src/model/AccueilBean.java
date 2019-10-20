package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import java.sql.SQLException;
import java.util.List;

public class AccueilBean {

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
