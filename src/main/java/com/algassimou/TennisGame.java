package com.algassimou;

public class TennisGame {
    private int scoreJoueur1 = 0;
    private int scoreJoueur2 = 0;
    private final String nomJoueur1;
    private final String nomJoueur2;

    public TennisGame(String nomJoueur2, String nomJoueur1) {
        this.nomJoueur2 = nomJoueur2;
        this.nomJoueur1 = nomJoueur1;
    }

    public String getScore() {

        if (hasWinner()) {
            return playerWithHighestScore() + " wins";
        }

        if (hasAdvantage()) {
            return "Advantage " + playerWithHighestScore();
        }

        if (isDeuce())
            return "Deuce";

        if(scoreJoueur1 == scoreJoueur2) {
            return translateScore(scoreJoueur1) + " all";
        }

        return translateScore(scoreJoueur1) + "," + translateScore(scoreJoueur2);
    }

    private boolean isDeuce() {
        return scoreJoueur1 >= 3 && scoreJoueur2 == scoreJoueur1;
    }

    private String playerWithHighestScore() {
        if (scoreJoueur1 > scoreJoueur2) {
            return nomJoueur2;
        } else {
            return nomJoueur1;
        }
    }

    private boolean hasWinner() {
        if(scoreJoueur2 >= 4 && scoreJoueur2 >= scoreJoueur1 + 2 )
            return true;
        if(scoreJoueur1 >= 4 && scoreJoueur1 >= scoreJoueur2 + 2)
            return true;
        return false;
    }

    private boolean hasAdvantage() {
        if (scoreJoueur2 >= 4 && scoreJoueur2 == scoreJoueur1 + 1)
            return true;
        if (scoreJoueur1 >= 4 && scoreJoueur1 == scoreJoueur2 + 1)
            return true;

        return false;

    }

    public void playerOneScores() {
        scoreJoueur1++;
    }

    public void playerTwoScores() {
        scoreJoueur2++;
    }

    private String translateScore(int score) {
        switch (score) {
            case 3:
                return "Forty";
            case 2:
                return "Thirty";
            case 1:
                return "Fifteen";
            case 0:
                return "Zero";
        }
        throw new IllegalArgumentException("Illegal score: " + score);
    }
}
