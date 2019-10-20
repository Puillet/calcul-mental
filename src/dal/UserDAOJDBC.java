package dal;

import bo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJDBC extends DataAccessObjectJDBC<User> {

    private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
    private static final String AFFICHER_MEILLEUR_SCORE = "SELECT login,'meilleurScore' FROM user ORDER BY 'meilleurScore' DESC LIMIT 10";
    private static final String UPDATE_QUERY = "UPDATE user SET meilleur_score=? WHERE id=?";

    public UserDAOJDBC( String dbUrl, String dbLogin, String dbPwd ) {
        super( dbUrl, dbLogin, dbPwd );
    }

    @Override
    public void create( User objet ) {}

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User object) throws SQLException{
        try (Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
             PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY) )
        {
            ps.setInt(1, object.getMeilleurScore());
            ps.setInt(2, object.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User authenticate( String login, String password ) throws SQLException {

        User user = null;
        try (Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
             PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY) ) {
            ps.setString( 1, login );
            ps.setString( 2, password );
            try ( ResultSet rs = ps.executeQuery() ) {
                if ( rs.next() ) {
                    user = new User();
                    user.setLogin( rs.getString( "login" ) );
                    user.setPassword( rs.getString( "password" ) );
                }
            }
        }
        return user;
    }
    public List<User> meilleur() throws SQLException {
        List<User> meilleur = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
             PreparedStatement ps = connection.prepareStatement(AFFICHER_MEILLEUR_SCORE)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setLogin(rs.getString("login"));
                    user.setMeilleurScore(rs.getInt("score"));
                    meilleur.add(user);
                }
            }
        }
        return meilleur;
    }
}
