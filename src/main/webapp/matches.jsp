<%@ page import="com.ilyadudnikov.tennismatchscoreboard.models.Match.Match" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ilyadudnikov.tennismatchscoreboard.Config" %><%--
  Created by IntelliJ IDEA.
  User: ilyad
  Date: 10/15/2024
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Matches</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="matches-content">
    <form class="form-filter-by-player-name" action="${pageContext.request.contextPath}/matches" method="get">
        <label>Filter by player name
            <input class="input-for-player-name-filter" type="text" name="filter_by_player_name"
                   value="<%=request.getParameter("filter-by-player-name") != null ? request.getParameter("filter-by-player-name") : ""%>"
                   placeholder="Player name">
        </label>
        <button type="submit">Apply filter</button>
    </form>

    <table class="table-matches">
        <colgroup>
            <col>
            <col>
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>№ Match</th>
            <th>Player 1</th>
            <th>Player 2</th>
        </tr>
        </thead>
        <tbody>
        <% List<Match> matches = (List<Match>) request.getAttribute("matches");
        for (Match match : matches) { %>
        <tr>
            <td><%=match.getId()%></td>
            <td class="<%=match.getPlayer1() == match.getWinner() ? "table-winner" : "table-loser"%>">
                <%=match.getPlayer1().getName()%>
            </td>
            <td class="<%=match.getPlayer2() == match.getWinner() ? "table-winner" : "table-loser"%>">
                <%=match.getPlayer2().getName()%>
            </td>
        </tr>
        <% } %>
        <%--      <tr>--%>
        <%--        <td>2</td>--%>
        <%--        <td class="table-loser">tyu</td>--%>
        <%--        <td class="table-winner">ghj</td>--%>
        <%--      </tr>--%>
        </tbody>
    </table>

    <div class="pagination-block">
        <div class="pagination">

            <% int pageCount = (Integer) request.getAttribute("pageCount");
            int currentPage = (Integer) request.getAttribute("page");

            if ((currentPage - Config.VISIBLE_PAGE_RANGE) <= 1) { %>
                <div class="page-numbers">
                    <% for (int i = 1; i < currentPage; i++) { %>
                        <a class="page-number" href="${pageContext.request.contextPath}/matches?page=<%=i%><%=request.getParameter("filter_by_player_name") != null ? "&filter_by_player_name=" + request.getParameter("filter_by_player_name") : ""%>">
                            <%=i%>
                        </a>
                    <% } %>
                </div>
            <%
            } else {
            %>
                <div class="page-numbers">
                    <a class="page-number" href="${pageContext.request.contextPath}/matches?page=1<%=request.getParameter("filter_by_player_name") != null ? "&filter_by_player_name=" + request.getParameter("filter_by_player_name") : ""%>">
                        1
                    </a>
                </div>
                <div class="page-numbers">
                    <% for (int i = (currentPage - Config.VISIBLE_PAGE_RANGE); i < currentPage; i++) { %>
                        <a class="page-number" href="${pageContext.request.contextPath}/matches?page=<%=i%><%=request.getParameter("filter_by_player_name") != null ? "&filter_by_player_name=" + request.getParameter("filter_by_player_name") : ""%>">
                            <%=i%>
                        </a>
                    <% } %>
                </div>
            <%
            }
            %>

            <div class="page-numbers">
                <a class="current-page" href="${pageContext.request.contextPath}/matches?page=<%=currentPage%><%=request.getParameter("filter_by_player_name") != null ? "&filter_by_player_name=" + request.getParameter("filter_by_player_name") : ""%>">
                    <%=currentPage%>
                </a>
            </div>

            <div class="page-numbers">
                <% for (int i = currentPage + 1; (i <= pageCount) && (i <= currentPage + Config.VISIBLE_PAGE_RANGE); i++) { %>
                    <a class="page-number" href="${pageContext.request.contextPath}/matches?page=<%=i%><%=request.getParameter("filter_by_player_name") != null ? "&filter_by_player_name=" + request.getParameter("filter_by_player_name") : ""%>">
                        <%=i%>
                    </a>
                <% } %>
            </div>

            <% if ((currentPage + Config.VISIBLE_PAGE_RANGE) < pageCount) { %>
                <div class="page-numbers">
                    <a class="page-number" href="${pageContext.request.contextPath}/matches?page=<%=pageCount%><%=request.getParameter("filter_by_player_name") != null ? "&filter_by_player_name=" + request.getParameter("filter_by_player_name") : ""%>">
                        <%=pageCount%>
                    </a>
                </div>
            <% } %>

        </div>
    </div>

    <div class="flex-center">
        <a class="new-match-link" href="${pageContext.request.contextPath}/new-match">Start a new match</a>
    </div>
</div>


</body>
</html>
