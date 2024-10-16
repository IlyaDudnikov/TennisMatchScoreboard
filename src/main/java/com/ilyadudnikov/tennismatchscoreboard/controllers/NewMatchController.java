package com.ilyadudnikov.tennismatchscoreboard.controllers;

import com.ilyadudnikov.tennismatchscoreboard.services.OngoingMatchesService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet("/new-match")
public class NewMatchController extends HttpServlet {
    OngoingMatchesService ongoingMatchesService;

    @Override
    public void init() {
        ongoingMatchesService = OngoingMatchesService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player1Name = req.getParameter("player1Name");
        String player2Name = req.getParameter("player2Name");

        Map<String, String> errors = new HashMap<>();
        if (player1Name.isBlank()) {
            errors.put("Player1", "Is blank");
        }
        if (player2Name.isBlank()) {
            errors.put("Player2", "Is blank");
        }
        if (player1Name.equals(player2Name)) {
            errors.put("PlayerNames", "Players cannot have the same name");
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("player1Name", player1Name);
            req.setAttribute("player2Name", player2Name);
            req.getRequestDispatcher("/new-match.jsp").forward(req, resp);
        } else {
            UUID uuid = ongoingMatchesService.add(player1Name, player2Name);
            resp.sendRedirect(req.getContextPath() + "/match-score?uuid=" + uuid.toString());
        }
    }
}
