package pl.javastart.voting;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private int votesFor;
    private int votesAgainst;
    private int votesAbstained;

    public void addVote(String vote) {
        switch (vote) {
            case "z" -> votesFor++;
            case "p" -> votesAgainst++;
            case "w" -> votesAbstained++;
        }
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        int totalVotes = votesFor + votesAgainst + votesAbstained;
        BigDecimal percentFor = calculatePercentage(votesFor, totalVotes);
        BigDecimal percentAgainst = calculatePercentage(votesAgainst, totalVotes);
        BigDecimal percentAbstained = calculatePercentage(votesAbstained, totalVotes);

        System.out.printf("Głosów za: %s%% %n",formatPercentage(percentFor));
        System.out.printf("Głosów przeciw: %s%% %n",formatPercentage(percentAgainst));
        System.out.printf("Wstrzymało się: %s%% %n",formatPercentage(percentAbstained));
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        System.out.println(voterName);
    }

    private BigDecimal calculatePercentage(int votes, int totalVotes) {
        if (totalVotes == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal voteCount = BigDecimal.valueOf(votes);
        BigDecimal totalCount = BigDecimal.valueOf(totalVotes);
        return voteCount.divide(totalCount,2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    }

    private String formatPercentage(BigDecimal percentage) {
        return percentage.setScale(2, RoundingMode.HALF_UP).toString();
    }
}
