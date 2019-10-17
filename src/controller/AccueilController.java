package controller;

import bo.Classement;
import model.ClassementBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( name="AccueilController",urlPatterns = {"/accueil"} )
public class AccueilController extends HttpServlet {

    private static final String PAGE_ACCUEIL_JSP = "/WEB-INF/jsp/accueil.jsp";
    private static final String PAGE_JEU_JSP = "/jeu";

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
        HttpSession session = request.getSession( true );

        List<Classement> dataSession = ( List<Classement> ) session.getAttribute( "classement" );

        if ( null == dataSession ) {
            dataSession = new ArrayList<>();
            dataSession.add( new Classement() );
            dataSession.add( new Classement() );
            session.setAttribute( "persons", dataSession );
        }

        String action = request.getParameter( "action" );
        if ( null == action ) {
            request.getRequestDispatcher( PAGE_ACCUEIL_JSP ).forward( request, response );
        } else {
            int id;
            try {
                id = Integer.parseInt( request.getParameter( "id" ) );
            } catch ( Exception e ) {
                id = -1;
            }
            switch ( action ) {
                case "jeu":
                    Classement currentPerson;
                    if ( id >= 0 && id < dataSession.size() ) {
                        currentPerson = dataSession.get( id );
                    } else {
                        currentPerson = new Classement();
                    }
                    request.setAttribute( "currentPerson", currentPerson );
                    request.getRequestDispatcher( PAGE_JEU_JSP ).forward( request, response );
                    break;
                default:
                    response.sendRedirect( request.getContextPath() + "/accueil" );
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ( "DELETE".equals( request.getParameter( "form-method" ) ) ) {
            doDelete( request, response );
        } else {

            HttpSession session = request.getSession( true );
            List<Classement> dataSession = ( List<Classement> ) session.getAttribute( "persons" );

            ClassementBean model = new ClassementBean();

            int id = model.getClassement().getId();
            if ( id >= 0 && id < dataSession.size() ) {
                Classement currentPerson = dataSession.get( id );
                currentPerson.setNom( model.getClassement().getNom() );
                currentPerson.setRang( model.getClassement().getRang() );
            } else {
                model.getClassement().setId( dataSession.size() );
                dataSession.add( model.getClassement() );
            }
            response.sendRedirect( request.getContextPath() + "/jeu" );
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession( true );
        List<Classement> dataSession = ( List<Classement> ) session.getAttribute( "classement" );

        int id;
        try {
            id = Integer.parseInt( request.getParameter( "form-id" ) );
        } catch ( Exception e ) {
            id = -1;
        }
        if ( id >= 0 && id < dataSession.size() ) {
            dataSession.remove( id );
        }
        response.sendRedirect( request.getContextPath() + "/accueil" );
    }
}
