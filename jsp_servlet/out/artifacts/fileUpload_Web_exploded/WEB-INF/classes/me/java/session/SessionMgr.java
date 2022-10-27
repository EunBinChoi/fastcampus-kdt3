package me.java.session;

import javax.servlet.http.HttpSession;

public class SessionMgr {
    private static SessionMgr session = null;

    private SessionMgr() {}

    public static SessionMgr getInstance() {
        if (session == null) {
            session = new SessionMgr();
        }
        return session;
    }

    public void create(HttpSession session, String value) {
        if (session.getAttribute("SESSION_ID") == null) {
            session.setMaxInactiveInterval(1800); // 30분
            session.setAttribute("SESSION_ID", value);
        }
    }

    public void create(HttpSession session, String name, String value) {
        if (session.getAttribute(name) == null) {
            session.setMaxInactiveInterval(1800); // 30분
            session.setAttribute(name, value);
        }
    }

    public void delete(HttpSession session) {
        delete(session, "SESSION_ID");
    }

    public void delete(HttpSession session, String name) {
        if (session.getAttribute(name) != null) {
            session.removeAttribute(name);
        }
        session.invalidate();
    }
}
