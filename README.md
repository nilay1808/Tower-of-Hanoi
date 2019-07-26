## Tower of Hanoi
The game uses 3 Rods from the Rod Class. When the game is initialized, the number of disks needs to be passed in. The file also contains a game player, and anyone can play the game in the terminal by running the program.
The class as the following methods-
- `moveDisk(int startRod, int destRod)` - Moves the top most disk from startRod to destRod
- `disksAtRod(int rod)` - Returns a list of disk at given rod. List is from top to bottom
- `print()` - A simple print function that prints the game board
- `win()` - Checks if there is a win situation on the board
- `isValidRod(int r)` - Checks if the input rod is valid or not
- `makeGame()` - Generates a random game board.

### Rod class
The Rod class is implemented using a stack. It is very similar to a normal stack but has some added functionality for ease and follows all the rules of Tower of Hanoi.
The class as the following methods-
- `push(int i)` - returns `true` if the move was valid and was executed else returns `false`.
- `pop()` - return the top element from the rod, `-1` if the rod is empty
- `toList()` - returns a copy of the stack as a iterable list. List is top to bottom.
- `contains(int i)` - Checks if the input is contained in the rod.
- `isEmpty()` - Checks if the rod is empty.
- `size()` - Returns the number of elements in the rod.
