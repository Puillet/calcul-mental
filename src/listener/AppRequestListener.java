package listener;

import dal.DAOFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed( ServletRequestEvent sre ) {

    }

    @Override
    public void requestInitialized( ServletRequestEvent sre ) {

    }
}
