package com.ilyadudnikov.tennismatchscoreboard.services.score;

public class RegularGameScore extends Score<RegularGamePlayerPoints> {
    @Override
    protected RegularGamePlayerPoints getZeroScore() {
        return RegularGamePlayerPoints.ZERO;
    }

    @Override
    public State pointWon(int playerNumber) {
        RegularGamePlayerPoints playerPoints = getPlayerScore(playerNumber);

        if (playerPoints.ordinal() <= RegularGamePlayerPoints.THIRTY.ordinal()) {
            // 0:X, 15:X, 30:X
            setPlayerScore(playerNumber, playerPoints.next());
        } else if (playerPoints.ordinal() == RegularGamePlayerPoints.FORTY.ordinal()) {
            // 40:X
            RegularGamePlayerPoints opponentPoints = getOpponentScore(playerNumber);

            if (opponentPoints.ordinal() <= RegularGamePlayerPoints.THIRTY.ordinal()) {
                // 40:0, 40:15, 40:30
                return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
            } else if (opponentPoints.ordinal() == RegularGamePlayerPoints.FORTY.ordinal()) {
                // 40:40
                setPlayerScore(playerNumber, playerPoints.next());
            } else {
                // 40:AD
                setOpponentScore(playerNumber, RegularGamePlayerPoints.FORTY);
            }
        } else if (playerPoints.ordinal() == RegularGamePlayerPoints.ADVANTAGE.ordinal()) {
            return playerNumber == 0 ? State.PLAYER_ONE_WON : State.PLAYER_TWO_WON;
        }

        return State.ONGOING;
    }
}
