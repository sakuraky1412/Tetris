import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TetrisGameTextController plays Tetris from the command line, printing the
 * game after each move.
 * 
 * @author Kuan Chi Chen
 */
public class TetrisGameTextController {
	// the game that the user plays
	private TetrisGame game;
	// the view that the user sees
	private TetrisBoardTextView view;

	/**
	 * Constructor
	 */
	public TetrisGameTextController() {
		// initializes game and view
		game = new TetrisGame();
		view = new TetrisBoardTextView(game.getTetrisBoard());
		// read key input from user
		readInput();
	}

	/**
	 * Get input from the user, looping until the user types "Quit".
	 */
	private void readInput() {
		// input stream: read input from user
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// I/O almost always requires a try/catch
		try {
			// the command line that the user types in
			String line;
			// loop until the user types "Quit"
			do {
				// tell the user what to do
				System.out
						.println("Please enter a move (l,r,d,z,x) or type Quit to end.");
				// read user input
				line = in.readLine();
				// pass in input to moveEntered
				moveEntered(line);
				// print out a new board reflecting current status
				refreshDisplay();
			} while ((!line.equals("Quit")));
		} catch (IOException ioe) {
			// tell exception to print its error log
			ioe.printStackTrace();
		}
	}

	/**
	 * Print text view of the game. First, print the number of lines cleared.
	 * Second, print the number of tetrises cleared. Then, print the tetris
	 * board.
	 */
	private void refreshDisplay() {
		System.out.println("Number of lines cleared: "
				+ Integer.toString(game.getNumLines()));
		System.out.println("Number of Tetrises cleared: "
				+ Integer.toString(game.getNumTetrises()));
		System.out.println("----------");
		System.out.println(view.getBoardString());
		System.out.println("----------");

	}

	/**
	 * r: right l: left d: down z: cw x: ccw
	 * 
	 * @param move
	 */
	private void moveEntered(String move) {
		if (move.equals("d"))
			game.attemptMove(0);
		if (move.equals("r"))
			game.attemptMove(1);
		if (move.equals("l"))
			game.attemptMove(2);
		if (move.equals("x"))
			game.attemptMove(3);
		if (move.equals("z"))
			game.attemptMove(4);

	}

	/**
	 * Start the game!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TetrisGameTextController myGame = new TetrisGameTextController();
	}
}
