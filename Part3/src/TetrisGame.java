/**
 * The TetrisGame class maintains a Tetris game.
 * 
 * @author Kuan Chi Chen
 */
public class TetrisGame {
	// the integers that represents movements of down, right, left,
	// clockwise and counterclockwise rotation
	public final int DOWN = 0;
	public final int RIGHT = 1;
	public final int LEFT = 2;
	public final int CW = 3;
	public final int CCW = 4;
	// the number of lines that the user had removed so far
	private int numLines;
	// the number of tetrises that the user had removed so far
	private int numTetrises = 0;
	// the tetris board
	private TetrisBoard tetrisBoard;

	/**
	 * Constructor
	 */
	public TetrisGame() {
		tetrisBoard = new TetrisBoard();
	}

	/**
	 * Try to move the current piece with RIGHT, LEFT, DOWN, CW, CCW
	 * 
	 * @param moveType
	 */
	public void attemptMove(int moveType) {
		// if the piece reached the bottom, end the round
		if (moveType == DOWN)
			tetrisBoard.moveDown();
		if (moveType == RIGHT)
			tetrisBoard.moveRight();
		if (moveType == LEFT)
			tetrisBoard.moveLeft();
		if (moveType == CW)
			tetrisBoard.moveCW();
		if (moveType == CCW)
			tetrisBoard.moveCCW();

	}

	/**
	 * Performed when a piece cannot move down anymore. Ends the round by
	 * landing the current piece and adding a new piece.
	 */
	private void endRound() {
		tetrisBoard.landPiece();
		tetrisBoard.addNewPiece();
	}

	/**
	 * @return the numLines
	 */
	public int getNumLines() {
		return numLines = numLines + tetrisBoard.numberOfFormedLines();
	}

	/**
	 * @return the numTetrises
	 */
	public int getNumTetrises() {
		return numTetrises = numTetrises + tetrisBoard.numberOfTetrises();
	}

	/**
	 * @return the tetrisBoard
	 */
	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;
	}

	/**
	 * Let the current piece drop down automatically when time in the Timer
	 * passes
	 */
	public void moveTimeForward() {
		// move the piece down
		tetrisBoard.moveDown();
		// automatically start the next round when piece cannot go down anymore
		if (!tetrisBoard.moveDown())
			endRound();
	}

	/**
	 * tell the controller that the game has ended
	 * 
	 * @return
	 */
	public boolean checkifEnd() {
		return tetrisBoard.gameEnded();
	}

	/**
	 * restarts the game
	 */
	public void restart() {
		tetrisBoard.clearBoard();
		numLines = 0;
		numTetrises = 0;
	}

}
