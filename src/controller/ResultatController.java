package controller;

import model.JeuBean;
import model.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (urlPatterns = "/resultat")
public class ResultatController extends HttpServlet {
    private static final String PAGE_RESULTAT_JSP = "/WEB-INF/jsp/resultat.jsp";
    private static final String PAGE_LOGIN_JSP = "/login";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean loginBean = new LoginBean();
        HttpSession session = request.getSession();
        if(loginBean.isConnected(request) && (int) session.getAttribute("nbQuestion") >= 10){
            request.setAttribute("nbCorrect", session.getAttribute("nbCorrect"));
            request.setAttribute("nbQuestion", session.getAttribute("nbQuestion"));
            request.getRequestDispatcher(PAGE_RESULTAT_JSP).forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath() + PAGE_LOGIN_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
