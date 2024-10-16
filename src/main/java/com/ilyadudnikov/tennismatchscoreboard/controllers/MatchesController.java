package com.ilyadudnikov.tennismatchscoreboard.controllers;

import com.ilyadudnikov.tennismatchscoreboard.exeptions.DatabaseException;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;
import com.ilyadudnikov.tennismatchscoreboard.services.MatchPaginationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class MatchesController extends HttpServlet {
    private MatchPaginationService matchPaginationService;

    @Override
    public void init() {
        matchPaginationService = new MatchPaginationService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int page = getPage(req);
            String playerNameForFilter = req.getParameter("filter_by_player_name");
            List<Match> matches;
            int pageCount;
            if (playerNameForFilter == null || playerNameForFilter.isEmpty()) {
                matches = matchPaginationService.getMatchesForPage(page);
                pageCount = matchPaginationService.getCountPagesForAllMatches();
            } else {
                matches = matchPaginationService.getMatchesByPlayerNameForPage(playerNameForFilter, page);
                pageCount = matchPaginationService.getCountPagesForMatchesByPlayerName(playerNameForFilter);
            }

            req.setAttribute("page", page);
            req.setAttribute("matches", matches);
            req.setAttribute("pageCount", pageCount);
            req.getRequestDispatcher("matches.jsp").forward(req, resp);
        } catch (DatabaseException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }


    }

    private Integer getPage(HttpServletRequest req) {
        try {
            String pageString = req.getParameter("page");
            if (pageString == null) {
                return 1;
            }
            return Integer.parseInt(pageString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid page number: " + req.getParameter("page"));
        }

    }
}
