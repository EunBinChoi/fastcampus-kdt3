package org.example.overview.sessions;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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

    public void set(HttpSession session, String name, String value) {
        session.setAttribute(name, value);
    }

    public void set(HttpSession session, String value) {
        session.setAttribute("SESSION_ID", value);
    }

    public String get(HttpSession session, String name) {
        return (String) session.getAttribute(name);
    }

    public String get(HttpSession session) {
        if (session.getAttribute("SESSION_ID") != null) {
            return (String) session.getAttribute("SESSION_ID");
        }
        return null;
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
