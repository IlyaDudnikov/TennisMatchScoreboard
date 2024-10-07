<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
%>

<% if (errors != null && !errors.isEmpty()) { %>
    <div class="errors">
        <ul>
        <% for (String errorReason: errors.keySet()) {
            String errorMessage = errors.get(errorReason);
        %>

            <li>
                <span class="errorReason"><%=errorReason%></span>:
                <span class="errorMessage"><%=errorMessage%></span>
            </li>
        <%
        }
        %>
        </ul>
    </div>
<%
}
%>
