package com.ilyadudnikov.tennismatchscoreboard.controllers;

import com.ilyadudnikov.tennismatchscoreboard.exeptions.MatchNotFoundException;
import com.ilyadudnikov.tennismatchscoreboard.models.Match.Match;
import com.ilyadudnikov.tennismatchscoreboard.services.MatchScoreCalculationService;
import com.ilyadudnikov.tennismatchscoreboard.services.OngoingMatchesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/match-score")
public class MatchScoreController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String uuidString = req.getParameter("uuid");
            UUID uuid = convertToUuidFromString(uuidString);
            Match match = OngoingMatchesService.getInstance().getCurrentMatch(uuid);
            req.setAttribute("match", match);
            req.getRequestDispatcher("/match-score.jsp").forward(req, resp);
        } catch (MatchNotFoundException e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        } catch (IllegalArgumentException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String uuidString = req.getParameter("uuid");
            String idString = req.getParameter("id");
            UUID uuid = convertToUuidFromString(uuidString);
            long idPlayerWhoWonPoint = getIdFromString(idString);
            Match match = OngoingMatchesService.getInstance().getCurrentMatch(uuid);
            MatchScoreCalculationService.updateScore(match, idPlayerWhoWonPoint);
            req.setAttribute("match", match);
            req.setAttribute("uuid", uuid);
            req.getRequestDispatcher("/match-score.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }
    }

    private UUID convertToUuidFromString(String uuidString) {
        try {
            return UUID.fromString(uuidString);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid UUID: " + uuidString);
        }
    }

    private long getIdFromString(String idString) {
        try {
            return Long.parseLong(idString);
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid UUID: " + idString);
        }
    }
}
