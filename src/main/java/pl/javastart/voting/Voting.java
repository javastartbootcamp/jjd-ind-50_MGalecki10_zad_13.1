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
        voters.add("asas");
        voters.add("wfwaf");
        voters.add("Zbyssafaonoga");
        voters.add("Zbyswafwhrhonoga");

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
        List<Vote> votes = new ArrayList<>();

        for (String voter : voters) {
            Boolean vote = askForVote(voter, scanner);
            votes.add(new Vote(voter,vote));
        }
        return new VotingResult(votes);
    }
    private Boolean askForVote(String voter, Scanner scanner) {
        System.out.printf("Jak głosuje %s? (z - za, p - przeciw, w - wstrzymanie sie)", voter);
        String input = scanner.nextLine().toLowerCase();
        return switch (input) {
            case "z" -> true;
            case "p" -> false;
            case "w" -> null;
            default -> askForVote(voter, scanner);
        };
    }
}
