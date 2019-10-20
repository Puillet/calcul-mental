package controller;


import bo.Jeu;
import model.JeuBean;
import model.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( name="JeuController",urlPatterns = {"/question"} )
public class JeuController extends HttpServlet {

    private static final String PAGE_JEU_JSP = "/WEB-INF/jsp/question.jsp";
    private static final String PAGE_LOGIN_JSP = "/login";
    private static final String PAGE_RESULTAT_JSP = "/resultat";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean model = new LoginBean();
        if(model.isConnected(request)){
            HttpSession session = request.getSession();
            //si le nombre de question traité est supérieur à 10 montre la page des résultat
            if((int) session.getAttribute("nbQuestion") >= 10){
                response.sendRedirect(request.getContextPath() + PAGE_RESULTAT_JSP);
            }
            //sinon on repose un calcul à l'utilisateur
            else {
                Jeu jeu = new Jeu();
                jeu.expression(5);
                request.setAttribute("jeu", jeu);
                session.setAttribute("pile", jeu.getPile());
                request.getRequestDispatcher(PAGE_JEU_JSP).forward(request, response);
            }
        }
        else {
            response.sendRedirect(request.getContextPath() + PAGE_LOGIN_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JeuBean model = new JeuBean();
        model.verifReponse(request);
        request.setAttribute("answer", model);
        doGet(request, response);
    }
}
