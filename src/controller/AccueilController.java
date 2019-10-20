package controller;

import model.AccueilBean;
import model.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( name="AccueilController",urlPatterns = {"/accueil"} )
public class AccueilController extends HttpServlet {

    private static final String PAGE_ACCUEIL_JSP = "/WEB-INF/jsp/accueil.jsp";
    private static final String PAGE_JEU_JSP = "/jeu";
    private static final String PAGE_LOGIN_JSP ="/login";

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean model = new LoginBean();
        if(model.isConnected(request)){
            AccueilBean accueilBean = new AccueilBean();
            accueilBean.getUsers();
            request.setAttribute("accueilBean", accueilBean);
            request.getRequestDispatcher(PAGE_ACCUEIL_JSP).forward(request, response);
            HttpSession session = request.getSession();
            session.setAttribute("nbQuestions",0);
            session.setAttribute("nbCorrect",0);
        }
        else {
            response.sendRedirect(request.getContextPath() + PAGE_LOGIN_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
