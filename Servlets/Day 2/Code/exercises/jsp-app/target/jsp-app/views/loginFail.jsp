<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ro.teamnet.zth.web.HttpSessionZTH" %>

<html>
<head>
    <title>Http Session</title>
    <%
        HttpSession httpSession = (HttpSession) session.getAttribute("session");
        String username = (String) session.getAttribute("user");
    %>
</head>
<body>
    Username <b><%=username%></b> or password is invalid! Please try again.
    <br>
Your session id is <%=httpSession.getId()%>
</body>
</html>
