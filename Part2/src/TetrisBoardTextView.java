/**
 * TetrisBoardTextView creates a String view of a TetrisBoard.
 * 
 * @author Kuan Chi Chen
 */
public class TetrisBoardTextView {
	// the tetris board
	public TetrisBoard board;

	// pass in the tetris board
	public TetrisBoardTextView(TetrisBoard b) {
		this.board = b;
	}

	// get the string of this tetris board
	public String getBoardString() {
		// initial the string
		String stringBoard = "";
		// get the number of columns of the board
		int col = board.getNumCols();
		// get the number of rows of the board
		int row = board.getNumRows();
		// for the whole board
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// if there is a block in the positions passed in
				if (board.hasBlock(i, j))
					stringBoard = stringBoard + "X";
				// if there is no block, just print space
				else
					stringBoard = stringBoard + " ";
			}
			// go to a new line, except for the last line
			if (i < row - 1)
				stringBoard = stringBoard + '\n';
		}
		return stringBoard;
	}
}
