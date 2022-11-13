package org.example.overview.sessions;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class SessionMgr {

    private static String mustSessionAttrWhenLogin = "SESSION_ID";

    public SessionMgr() {}


    public void create(HttpSession session, String value) {
        if (session.getAttribute(mustSessionAttrWhenLogin) == null) {
            session.setMaxInactiveInterval(1800); // 30분
            session.setAttribute(mustSessionAttrWhenLogin, value);
        }
    }

    public void create(HttpSession session, String name, String value) {
        if (session.getAttribute(name) == null) {
            session.setMaxInactiveInterval(1800); // 30분
            session.setAttribute(name, value);
        }
    }

    public void set(HttpSession session, String name, String value) {
        session.setAttribute(name, value);
    }

    public void set(HttpSession session, String value) {
        session.setAttribute(mustSessionAttrWhenLogin, value);
    }

    public String get(HttpSession session, String name) {
        return (String) session.getAttribute(name);
    }

    public String get(HttpSession session) {
        if (session.getAttribute(mustSessionAttrWhenLogin) != null) {
            return (String) session.getAttribute(mustSessionAttrWhenLogin);
        }
        return null;
    }

    public void delete(HttpSession session) {
        delete(session, mustSessionAttrWhenLogin);
    }

    public void delete(HttpSession session, String name) {
        if (session.getAttribute(name) != null) {
            session.removeAttribute(name);
        }
        session.invalidate();
    }
}
