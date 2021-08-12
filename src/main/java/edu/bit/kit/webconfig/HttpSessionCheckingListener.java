package edu.bit.kit.webconfig;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebListener
public class HttpSessionCheckingListener implements HttpSessionListener{
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    static private int activeSessions = 0;
    
    public static int getActiveSessions() {
        return activeSessions;
    }
    
    public void sessionCreated(HttpSessionEvent event) {
        activeSessions++;
        log.info("SessionCnt: " + activeSessions + "Session ID " .concat(event.getSession().getId()).concat(" created at ").concat(new Date().toString()));
    }
    
    public void sessionDestroyed(HttpSessionEvent event) {
        activeSessions--;
        logger.debug("SessionCnt:" + activeSessions + "Session ID " .concat(event.getSession().getId()).concat("destroyed at ").concat(new Date().toString()));
    }
}
