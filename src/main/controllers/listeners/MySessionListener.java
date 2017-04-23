package main.controllers.listeners;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by admin on 20.04.2017.
 */
public class MySessionListener implements HttpSessionListener {

    private static final Logger LOGGER = Logger.getLogger(MySessionListener.class);

    public void sessionCreated(HttpSessionEvent se) {
        LOGGER.debug("Session id = " + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
