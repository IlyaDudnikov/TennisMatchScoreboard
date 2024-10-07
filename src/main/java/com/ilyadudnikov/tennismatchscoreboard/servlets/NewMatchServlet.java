package com.ilyadudnikov.tennismatchscoreboard.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player1 = req.getParameter("player1");
        String player2 = req.getParameter("player2");

        Map<String, String> errors = new HashMap<>();
        if (player1.isBlank()) {
            errors.put("Player1", "Is blank");
        }
        if (player2.isBlank()) {
            errors.put("Player2", "Is blank");
        }
        if (player1.equals(player2)) {
            errors.put("PlayerNames", "Players cannot have the same name");
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("player1", player1);
            req.setAttribute("player2", player2);
            req.getRequestDispatcher("/new-match.jsp").forward(req, resp);
        } else {
            /*createNewMatch(player1, player2);
            resp.sendRedirect("/new-score?uuid=");*/

        }
    }
}
