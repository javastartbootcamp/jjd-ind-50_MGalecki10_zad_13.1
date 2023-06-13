package pl.javastart.voting;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private List<Vote> votes;

    public VotingResult(List<Vote> votes) {
        this.votes = votes;
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        int totalVotes = votes.size();
        int votesFor = 0;
        int votesAgainst = 0;
        int votesAbstained = 0;

        for (Vote vote : votes) {
            Boolean voteValue = vote.getVote();
            if (voteValue == null) {
                votesAbstained++;
            } else if (voteValue) {
                votesFor++;
            } else {
                votesAgainst++;
            }
        }

        BigDecimal percentVotesFor = calculatePercentage(votesFor, totalVotes);
        BigDecimal percentVotesAgainst = calculatePercentage(votesAgainst, totalVotes);
        BigDecimal percentVotesAbstained = calculatePercentage(votesAbstained, totalVotes);

        System.out.println("Głosów za: " + percentVotesFor + "%");
        System.out.println("Głosów przeciw: " + percentVotesAgainst + "%");
        System.out.println("Wstrzymało się: " + percentVotesAbstained + "%");
    }

    private BigDecimal calculatePercentage(int votes, int totalVotes) {
        if (totalVotes == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal percantage = BigDecimal.valueOf(votes * 100 / totalVotes);
        return percantage.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote vote : votes) {
            if (vote.getVoter().equals(voterName)) {
                Boolean voteValue = vote.getVote();
                String voteStatus;
                if (voteValue == null) {
                    voteStatus = "WSTRZYMAŁ SIĘ";
                } else if (voteValue) {
                    voteStatus = "ZA";
                } else {
                    voteStatus = "PRZECIW";
                }
                System.out.println(vote.getVoter() + ": " + voteStatus);
            }
        }
    }
}
