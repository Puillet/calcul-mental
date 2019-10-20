package model;

import bo.Jeu;
import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Stack;


public class JeuBean implements Serializable {
    private static final String reponse="reponse";

    private Double reponseUser;

    public Double getReponseUser() {
        return reponseUser;
    }

    public void setReponseUser(Double reponseUser) {
        this.reponseUser = reponseUser;
    }

    public JeuBean() {
    }

    public void verifReponse(HttpServletRequest request){
        reponseUser = Double.valueOf(request.getParameter(reponse));
        HttpSession session = request.getSession();
        Stack<Double> correctAnswer = (Stack<Double>) session.getAttribute("pile");
        if (Math.abs(reponseUser - correctAnswer.pop()) < 0.01) {
            System.out.println("Résultat Correct");
            session.setAttribute("nbCorrect", (int) session.getAttribute("nbCorrect") + 1);
        }
        session.setAttribute("nbQuestions", (int) session.getAttribute("nbQuestions") + 1);
    }

    public void verifMeilleurScore(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        User user = (User) session.getAttribute("isConnected");
        if(user.getMeilleur_score() < (int) session.getAttribute("nbCorrect")){
            try {
                JeuBean jeuBean = new JeuBean();
                user.setMeilleur_score((Integer) session.getAttribute("nbCorrect"));
                System.out.println("id user" + user.getId());
                dao.update(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
