import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = { "Rock", "Paper", "Scissors" };

        while (true) {
            System.out.println("Choose your move: (1) Rock, (2) Paper, (3) Scissors, or type 'exit' to quit");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("exit")) {
                System.out.println("Exiting the game. Goodbye!");
                break;
            }

            try {
                int userChoice = Integer.parseInt(userInput);

                if (userChoice < 1 || userChoice > 3) {
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                    continue;
                }

                String userMove = choices[userChoice - 1];
                int computerIndex = random.nextInt(3);
                String computerMove = choices[computerIndex];

                System.out.println("You choice: " + userMove);
                System.out.println("Computer choice: " + computerMove);

                // Determine the winner
                if (userMove.equals(computerMove)) {
                    System.out.println("It's a tie!");
                } else if ((userMove.equals("Rock") && computerMove.equals("Scissors")) ||
                        (userMove.equals("Paper") && computerMove.equals("Rock")) ||
                        (userMove.equals("Scissors") && computerMove.equals("Paper"))) {
                    System.out.println("You win!");
                } else {
                    System.out.println("Computer wins!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or type 'exit' to quit.");
            }
        }

        scanner.close();
    }
}
