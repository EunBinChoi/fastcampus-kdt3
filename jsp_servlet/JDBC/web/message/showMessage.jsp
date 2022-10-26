<%@ page import="me.java.util.Status" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.IOException" %>

<%!
    public void showMessage(HttpServletRequest request, HttpServletResponse response, String attributeName, Status status) throws IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        if (session.getAttribute(attributeName) != null) {
            if (session.getAttribute(attributeName) == status) {
                String msg = makeMessage(attributeName, status).toUpperCase();
                out.write("<script>alert('" + msg + "!' )</script>");
                session.removeAttribute(attributeName);
            }

        }

    }
%>

<%!
    public String makeMessage(String attributeName, Status status) {
        return attributeName + " " + status.toString();
    }
%>
