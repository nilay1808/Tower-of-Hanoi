import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		/*
		 * Game Player: You can play the game in the terminal by running this program
		 */
		System.out.println("Hello, welcome to Tower of Hanoi!\n");

		// Get number of disks you want to play with
		System.out.print("Please enter the number of disks you want to play with- ");
		Scanner num = new Scanner(System.in);
		int numOfDisks = num.nextInt();
		System.out.println("Let's get started!");

		// Initialize the game
		TowerOfHanoi game = new TowerOfHanoi(numOfDisks);
		game.makeGame();
		int moves = 0;
		game.print();

		while (!game.win()) {
			System.out.println("What move do you want to play?");

			// Get Start Rod
			System.out.print("Start rod (1, 2, 3): ");
			int start = num.nextInt();
			if (start < 1 || start > 3) {
				// Error catcher
				System.out.println("Invalid Rod. Try again");
				continue;
			}

			// Get Destination Rod
			System.out.print("And destination rod (1, 2, 3): ");
			int dest = num.nextInt();
			if (dest < 1 || dest > 3) {
				// Error catcher
				System.out.println("Invalid Rod. Try again");
				continue;
			}

			// Play Move
			game.moveDisk(start, dest);
			game.print();
			moves++;
		}
		num.close();
		// Print ending details
		System.out.println("Congratulations! You win!");
		System.out.println("You took " + moves + " moves.");
		System.out.println("Thanks for playing!!");
	}

}
