package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        VotingResult votingResult = new VotingResult();

        for (String voter : voters) {
            String vote = getVote(voter, scanner);
            votingResult.addVote(vote);
        }
        return votingResult;
    }

    private String getVote(String voter, Scanner scanner) {
        String vote;
        while (true) {
            System.out.printf("Jak głosuje %s? (z - za, p - przeciw, w - wstrzymanie sie)", voter);
            vote = scanner.nextLine();
            if (vote.equals("z") || vote.equals("p") || vote.equals("w")) {
                break;
            } else {
                System.out.println("Nieprawidłowy głos! Spróbuj ponownie");
            }
        }
        return vote;
    }
}
