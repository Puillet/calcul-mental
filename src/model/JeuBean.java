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
        System.out.println("Check answer");
        reponseUser = Double.valueOf(request.getParameter(reponse));
        System.out.println("User Answer : " + reponseUser);
        HttpSession session = request.getSession();
        Stack<Double> correctAnswer = (Stack<Double>) session.getAttribute("pile");
        System.out.println("Correct Answer : " + correctAnswer);
        //test pour valider le résultat de l'utilisateur, il peux rentrer une valeur arrondi à 0.0001 près
        //ce test à du être mis en place ) cause de la conversion et de l'arrondi de l'ordinateur des valeurs
        //et surtout à la longeur des résultat fournis
        if (Math.abs(reponseUser - correctAnswer.pop()) < 0.01){
            System.out.println("Résultat Correct");
            //si le résultat est correct on incrémente de 1 le nombre de bonnes
            session.setAttribute("nbVictoire", (int) session.getAttribute("nbVictoire") + 1);
        }else {
            System.out.println("Résultat incorrect");
        }
        //dans tous les cas on incrémente de 1 le nombre de question traitée
        session.setAttribute("nbQuestion", (int) session.getAttribute("nbQuestion") + 1);
        System.out.println("Nombre total de question éffectué : " + session.getAttribute("nbQuestion"));
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
