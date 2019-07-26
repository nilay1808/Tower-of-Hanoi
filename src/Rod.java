import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Rod {

	/*
	 * The Rod class is basically a stack with additional functions for the game. 
	 */
	private Stack<Integer> s;

	// Constructor
	public Rod() {
		s = new Stack<Integer>();
	}

	// Pushes int following the rules of Tower of Hanoi
	public boolean push(int i) {
		if (!s.isEmpty() && s.peek() <= i) {
			return false;
		}
		s.push(i);
		return true;
	}

	// Removes the top most int from the rod
	public int pop() {
		if (s.isEmpty()) {
			return -1;
		}
		return s.pop();
	}

	// List is top to bottom
	public List<Integer> toList() {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Integer> helper = new Stack<Integer>();

		while (!s.isEmpty()) {
			int i = s.pop();
			list.add(i);
			helper.push(i);
		}

		while (!helper.isEmpty()) {
			s.push(helper.pop());
		}

		return list;
	}

	// Checks if the number exists in the stack.
	public boolean contains(int i) {
		return s.contains(i);
	}

	// Checks if the rod is empty.
	public boolean isEmpty() {
		return s.isEmpty();
	}

	// returns number of elements in the rod
	public int size() {
		return s.size();
	}

}
