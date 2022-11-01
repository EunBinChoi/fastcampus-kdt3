package org.example.overview.cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieMgr {
    private static CookieMgr cookie = null;
    private static String[] mustCookiesWhenLogin = {"COOKIE_ID", "AUTO_LOGIN"};

    private CookieMgr() {}

    public static CookieMgr getInstance() {
        if (cookie == null) {
            cookie = new CookieMgr();
        }
        return cookie;
    }

    public void create(HttpServletResponse response, String[] values) {
        create(response, mustCookiesWhenLogin, values);
    }

    public void create(HttpServletResponse response, String[] names, String[] values) {
        if (names.length != values.length) return;

        for (int i = 0; i < names.length; i++) {
            create(response, names[i], values[i]);
        }
    }

    public void create(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(24 * 60 * 60); // 초 단위,  24 시간
        cookie.setPath("/"); // / 경로 이하에 모두 쿠키 전달

        response.addCookie(cookie);
    }

    public String[] get(HttpServletRequest request) {
        return get(request, mustCookiesWhenLogin);
    }

    public String[] get(HttpServletRequest request, String[] names) {
        String[] values = new String[names.length];


        if (names == null) return null;

        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;

        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) continue; 

            for (Cookie cookie: cookies) {
                if (cookie.getName() == null) continue;
                if (names[i].equals(cookie.getName())) {
                    values[i] = cookie.getValue();
                }
            }
        }
        return values;
    }

    public String get(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName() != null) {
                    if (cookie.getName().equals(name)) {
                        return cookie.getValue();
                    }
                }
            }
        }
        return null;
    }

    public void set(HttpServletRequest request, HttpServletResponse response, String name, String value) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName() != null) {
                    if (cookie.getName().equals(name)) {
                        cookie.setValue(value);
                        response.addCookie(cookie);
                    }
                }
            }
        }
    }

    public int delete(HttpServletRequest request, HttpServletResponse response) {
        return delete(request, response, mustCookiesWhenLogin);
    }

    public int delete(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();

        int count = 0;
        for (Cookie cookie: cookies) {
            if (name != null) {
                if (cookie.getName().equals(name)) {
                    count++;
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
        return count;
    }

    public int delete(HttpServletRequest request, HttpServletResponse response, String[] names) {
        Cookie[] cookies = request.getCookies();

        int count = 0;
        for (Cookie cookie: cookies) {
            if (names != null) {
                for (int i = 0; i < names.length; i++) {
                    if (cookie.getName().equals(names[i])) {
                        count++;
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }
        }
        return count;
    }
}
