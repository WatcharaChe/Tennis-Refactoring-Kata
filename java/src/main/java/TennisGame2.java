
public class TennisGame2 implements TennisGame {
    private int P1point = 0;
    private int P2point = 0;

    private String player1Name;
    private String player2Name;

    TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (isDeuce()) {
            score = "Deuce";
        } else if (isNormal()) {
            score = String.format("%s-%s", tie(P1point), isEqualsPoint() ? "All" : tie(P2point));
        } else if (isAdvantage()) {
            score = String.format("Advantage %s", whoHasMorePoint());
        }
        else if (isWinner()) {
            score = String.format("Win for %s", whoHasMorePoint());
        }

        return score;
    }

    private String tie(int point) {
        String[] values = {"Love", "Fifteen", "Thirty", "Forty"};
        return values[point];
    }

    private boolean isDeuce() {
        return (P1point == P2point && P1point >= 3);
    }

    private boolean isNormal() {
        return (P1point < 4 && P2point < 4);
    }

    private boolean isAdvantage() {
        return (Math.abs(P1point - P2point) == 1);
    }

    private boolean isWinner() {
        return (Math.abs(P1point - P2point) > 1);
    }

    private boolean isEqualsPoint() {
        return (P1point == P2point);
    }

    private String whoHasMorePoint() {
        return (P1point > P2point ? player1Name : player2Name);
    }

    private void P1Score() {
        P1point++;
    }

    private void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player1Name.equals(player)) {
            P1Score();
        } else
            P2Score();
    }
}