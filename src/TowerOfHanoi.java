import java.util.List;
import java.util.Stack;

public class TowerOfHanoi {

	/*
	 * The game uses 3 Rods which are basically modified stacks. When the game is
	 * initialized, the number of disks needs to be passed in. Functions-
	 * moveDisk(int startRod, int destRod)- Moves the top most disk from startRod to
	 * destRod disksAtRod(int rod)- Returns a list of disk at given rod. List is
	 * from top to bottom print()- A simple print function that prints the game
	 * board win()- Checks if there is a win situation on the board isValidRod(int
	 * r)- Checks if the input rod is valid or not makeGame()- Generates a random
	 * game board.
	 */

	private Rod r1, r2, r3;
	private int numOfDisks;

	// Constructor
	public TowerOfHanoi(int n) {
		r1 = new Rod();
		r2 = new Rod();
		r3 = new Rod();
		numOfDisks = n;
	}

	public void moveDisk(int startRod, int destRod) {

		// Error Handler 1: Check if startRod and destRod exist
		if (!isValidRod(startRod) || !isValidRod(destRod)) {
			System.out.println("Error: The rods passed in do not exist.\n");
			return;
		}

		// No move needed
		if (startRod == destRod) {
			return;
		}

		int disk;
		// Get the top disk which needs to be moved
		if (startRod == 1) {
			disk = r1.pop();
		} else if (startRod == 2) {
			disk = r2.pop();
		} else {
			disk = r3.pop();
		}

		// Error Handler 2: Given rod is empty
		if (disk == -1) {
			System.out.println("Error: The start rod passed in is empty!\n");
			return;
		}

		Boolean success;
		// Push the disk on the destination rod
		if (destRod == 1) {
			success = r1.push(disk);
		} else if (destRod == 2) {
			success = r2.push(disk);
		} else {
			success = r3.push(disk);
		}

		// Error Handler 3: Check if the move was valid and that it occured, if not put
		// the disk back in the starting rod
		if (!success) {
			if (startRod == 1) {
				r1.push(disk);
			} else if (startRod == 2) {
				r2.push(disk);
			} else {
				r3.push(disk);
			}
			System.out.println("Error: Cannot move the rod since it's an invalid move.\n");
			return;
		}

		return;
	}

	public List<Integer> disksAtRod(int rod) {
		switch (rod) {
		case 1:
			return r1.toList();
		case 2:
			return r2.toList();
		case 3:
			return r3.toList();
		default:
			// Error Handler
			System.out.println("Error: Given rod doesn't exist.\n");
			return null;
		}

	}

	public void print() {
		// Gets the 3 rods as lists
		List<Integer> rod1 = disksAtRod(1);
		List<Integer> rod2 = disksAtRod(2);
		List<Integer> rod3 = disksAtRod(3);

		Stack<String> printStack = new Stack<String>();

		for (int i = 0; i < numOfDisks; i++) {
			String d1, d2, d3;
			// Rod 1 element
			if (rod1.isEmpty()) {
				d1 = " ";
			} else {
				d1 = rod1.remove(rod1.size() - 1).toString();
			}
			// Rod 2 element
			if (rod2.isEmpty()) {
				d2 = " ";
			} else {
				d2 = rod2.remove(rod2.size() - 1).toString();
			}
			// Rod 3 element
			if (rod3.isEmpty()) {
				d3 = " ";
			} else {
				d3 = rod3.remove(rod3.size() - 1).toString();
			}
			// Create final line
			String line = " | " + d1 + " | " + d2 + " | " + d3 + " | ";
			printStack.push(line);
		}

		// Execute the printStack
		while (!printStack.isEmpty()) {
			System.out.println(printStack.pop());
		}
		// Leave an empty line at the end
		System.out.println();
	}

	public boolean win() {
		if (r1.isEmpty() && r2.isEmpty()) {
			return r3.size() == numOfDisks;
		}
		if (r1.isEmpty() && r3.isEmpty()) {
			return r2.size() == numOfDisks;
		}
		if (r2.isEmpty() && r3.isEmpty()) {
			return r1.size() == numOfDisks;
		}
		return false;
	}

	/*
	 * Helper Functions
	 */
	private boolean isValidRod(int r) {
		return (r == 1 || r == 2 || r == 3);
	}

	public void makeGame() {
		int n = numOfDisks;
		for (int i = n; i > 0; i--) {
			int r = (int) (Math.random() * 3) + 1;
			if (r == 1) {
				r1.push(i);
			} else if (r == 2) {
				r2.push(i);
			} else {
				r3.push(i);
			}
		}
		return;
	}

}
