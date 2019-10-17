package controller;


import bo.Jeu;
import model.JeuBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( name="JeuController",urlPatterns = {"/jeu"} )
public class JeuController extends HttpServlet {

    private static final String PAGE_JEU_JSP = "/WEB-INF/jsp/jeu.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession( true );

        List<Jeu> dataSession = ( List<Jeu> ) session.getAttribute( "classement" );

        if ( null == dataSession ) {
            dataSession = new ArrayList<>();
            dataSession.add( new Jeu() );
            dataSession.add( new Jeu() );
            session.setAttribute( "persons", dataSession );
        }

        String action = request.getParameter( "action" );
        if ( null == action ) {
            request.getRequestDispatcher( PAGE_JEU_JSP ).forward( request, response );
        } else {
            int id;
            try {
                id = Integer.parseInt( request.getParameter( "id" ) );
            } catch ( Exception e ) {
                id = -1;
            }
            switch ( action ) {
                case "jeu":
                    Jeu currentJeu;
                    if ( id >= 0 && id < dataSession.size() ) {
                        currentJeu = dataSession.get( id );
                    } else {
                        currentJeu = new Jeu();
                    }
                    request.setAttribute( "currentJeu", currentJeu );
                    request.getRequestDispatcher( PAGE_JEU_JSP ).forward( request, response );
                    break;
                default:
                    response.sendRedirect( request.getContextPath() + "/jeu" );
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ( "DELETE".equals( request.getParameter( "form-method" ) ) ) {
            doDelete( request, response );
        } else {

            HttpSession session = request.getSession( true );
            List<Jeu> dataSession = ( List<Jeu> ) session.getAttribute( "persons" );

            JeuBean model = new JeuBean();

            int id = model.getJeu().getId();
            if ( id >= 0 && id < dataSession.size() ) {
                Jeu currentPerson = dataSession.get( id );
                currentPerson.setQuestion( model.getJeu().getQuestion() );
            } else {
                model.getJeu().setId( dataSession.size() );
                dataSession.add( model.getJeu() );
            }
            response.sendRedirect( request.getContextPath() + "/jeu" );
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession( true );
        List<Jeu> dataSession = ( List<Jeu> ) session.getAttribute( "jeu" );

        int id;
        try {
            id = Integer.parseInt( request.getParameter( "form-id" ) );
        } catch ( Exception e ) {
            id = -1;
        }
        if ( id >= 0 && id < dataSession.size() ) {
            dataSession.remove( id );
        }
        response.sendRedirect( request.getContextPath() + "/jeu" );
    }
}
