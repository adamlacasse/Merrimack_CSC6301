package Q2;
import java.util.Scanner;
import java.util.Set;

public final class RockPaperScissors {

    private static final Set<String> VALID_CHOICES = Set.of("r", "p", "s");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            play(scanner);
        }
    }

    private static void play(Scanner scanner) {
        String playerChoice;
        while (true) {
            System.out.print("Enter (r)ock, (s)cissors, or (p)aper: ");
            playerChoice = scanner.nextLine().trim().toLowerCase();
            if (!VALID_CHOICES.contains(playerChoice)) {
                System.out.println("Only 'r', 's', or 'p' are valid inputs! Please try again.");
            } else {
                break;
            }
        }

        String computerChoice = pickComputerChoice();
        announceOutcome(playerChoice, computerChoice);
    }

    private static String pickComputerChoice() {
        double rand = Math.random();
        if (rand < 1.0 / 3.0) {
            return "r";
        } else if (rand < 2.0 / 3.0) {
            return "s";
        }
        return "p";
    }

    private static void announceOutcome(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            System.out.println("It is a tie!");
        } else if (playerLoses(playerChoice, computerChoice)) {
            System.out.printf("Sorry, you lost as I had %s.%n", describeChoice(computerChoice));
        } else {
            System.out.printf("Congrats, you won as I had %s.%n", describeChoice(computerChoice));
        }
    }

    private static boolean playerLoses(String playerChoice, String computerChoice) {
        return ("r".equals(playerChoice) && "p".equals(computerChoice))
            || ("p".equals(playerChoice) && "s".equals(computerChoice))
            || ("s".equals(playerChoice) && "r".equals(computerChoice));
    }

    private static String describeChoice(String choice) {
        return switch (choice) {
            case "r" -> "rock";
            case "p" -> "paper";
            case "s" -> "scissors";
            default -> throw new IllegalArgumentException("Unexpected choice: " + choice);
        };
    }
}
