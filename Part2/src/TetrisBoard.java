/**
 * The TetrisBoard class represents the model: a board on which Tetris is
 * played; it maintains the grid (the block matrix) and the current piece.
 * 
 * @author Kuan Chi Chen
 * 
 */
public class TetrisBoard {
	// the number of the columns and rows of a standard Tetris board
	public final int NUM_COLS = 10;
	public final int NUM_ROWS = 18;
	// the 2D boolean array that keeps track of whether a certain point
	// in the board holds a block of a Tetris piece
	private boolean[][] blockMatrix;
	// the current piece that the user is controlling with keys
	private TetrisPiece currentPiece;
	// the position of the current piece
	private int[] currentPieceGridPosition;
	// the number of lines that is being removed
	private int numLines;

	/**
	 * Constructor sets up the board
	 */
	public TetrisBoard() {
		// initialize the block matrix
		blockMatrix = new boolean[NUM_ROWS][NUM_COLS];
		// initialize current grid position
		intiCurrentGP();
		// initialize board
		intiBoard();
	}

	/**
	 * Initialize an int array of length two to keep track of the grid position
	 * of the current piece (row, col) index 0 holds row index 1 holds col
	 */
	private void intiCurrentGP() {
		currentPieceGridPosition = new int[2];
		currentPieceGridPosition[0] = 0;
		currentPieceGridPosition[1] = 3;

	}

	/**
	 * Initialize the 2D board array to have all false values then add a new
	 * piece at the top of the board
	 */

	private void intiBoard() {
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				blockMatrix[i][j] = false;
			}
		}
		addNewPiece();
	}

	/**
	 * Update the board array to reflect the position of the building blocks of
	 * a landed piece using the currentGridPosition values and the
	 * currentPiece's rotation value.
	 */
	public void landPiece() {
		// get piece grid position
		currentPieceGridPosition = getCurrentPieceGridPosition();
		int x = currentPieceGridPosition[0];
		int y = currentPieceGridPosition[1];
		// get piece rotation
		currentPiece = getCurrentPiece();
		int rot = currentPiece.getPieceRotation();
		// for the 4X4 piece array
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// if there is a block
				if (currentPiece.isFilled(rot, i, j))
					// the corresponding position of the board is filled
					blockMatrix[x + i][y + j] = true;
			}
		}
	}

	/**
	 * Check if moving left is valid. If so, update the position of the current
	 * piece.
	 * 
	 */
	public boolean moveLeft() {
		// get piece grid position
		currentPieceGridPosition = getCurrentPieceGridPosition();
		int x = currentPieceGridPosition[0];
		int y = currentPieceGridPosition[1];

		// get piece rotation
		currentPiece = getCurrentPiece();
		int rot = currentPiece.getPieceRotation();

		// if the piece can be moved
		if (validMove(currentPiece, rot, x, y - 1)) {
			// position move one block to the left
			currentPieceGridPosition[1] = y - 1;
			// piece is moved
			return true;
		}
		// piece is not moved
		return false;
	}

	/**
	 * Check if moving right is valid. If so, update the position of the current
	 * piece.
	 * 
	 */
	public boolean moveRight() {
		// get piece grid position
		currentPieceGridPosition = getCurrentPieceGridPosition();
		int x = currentPieceGridPosition[0];
		int y = currentPieceGridPosition[1];

		// get piece rotation
		currentPiece = getCurrentPiece();
		int rot = currentPiece.getPieceRotation();

		// if the piece can be moved
		if (validMove(currentPiece, rot, x, y + 1)) {
			// position move one block to the right
			currentPieceGridPosition[1] = y + 1;
			// piece is moved
			return true;
		}
		// piece is not moved
		return false;
	}

	/**
	 * Check if moving down is valid. If so, update the position of the current
	 * piece.
	 * 
	 */
	public boolean moveDown() {
		// get piece grid position
		currentPieceGridPosition = getCurrentPieceGridPosition();
		int x = currentPieceGridPosition[0];
		int y = currentPieceGridPosition[1];

		// get piece rotation
		currentPiece = getCurrentPiece();
		int rot = currentPiece.getPieceRotation();

		// if the piece can be moved
		if (validMove(currentPiece, rot, x + 1, y)) {
			// position move one block to the down
			currentPieceGridPosition[0] = x + 1;
			// piece is moved
			return true;
		}
		// piece is not moved
		return false;
	}

	/**
	 * Check if rotating clockwise is valid. If so, rotate the current piece
	 * clockwise by 90 degrees.
	 */
	public boolean moveCW() {
		// get piece grid position
		currentPieceGridPosition = getCurrentPieceGridPosition();
		int x = currentPieceGridPosition[0];
		int y = currentPieceGridPosition[1];
		// rotate piece clockwise
		currentPiece.rotateCW();
		// get piece rotation
		currentPiece = getCurrentPiece();
		int rot = currentPiece.getPieceRotation();
		// if the piece cannot be moved
		if (!validMove(currentPiece, rot, x, y)) {
			// rotate it back
			currentPiece.rotateCCW();
			// piece is not moved
			return false;
		}
		// piece is moved
		return true;
	}

	/**
	 * Check if rotating clockwise is valid. If so, rotate the current piece
	 * counterclockwise by 90 degrees.
	 */
	public boolean moveCCW() {
		// get piece grid position
		currentPieceGridPosition = getCurrentPieceGridPosition();
		int x = currentPieceGridPosition[0];
		int y = currentPieceGridPosition[1];
		// rotate piece counter counterclockwise
		currentPiece.rotateCCW();
		// get piece rotation
		currentPiece = getCurrentPiece();
		int rot = currentPiece.getPieceRotation();
		// if the piece cannot be moved
		if (!validMove(currentPiece, rot, x, y)) {
			// rotate it back
			currentPiece.rotateCW();
			// piece is not moved
			return false;
		}
		// piece is moved
		return true;
	}

	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation
	 * rot (values can be 0, 90, 180, 270) would cause a collision (i.e., if
	 * there would be a block on an already-filled grid square).
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 */
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		// for the 4X4 piece array
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// if there is a block
				if (currentPiece.isFilled(rot, i, j)) {
					// if there is another block to the left, right, or below
					if (blockMatrix[gridRow + i][gridCol + j]
							|| blockMatrix[gridRow][gridCol + j]) {
						// there is a collision
						return true;

					}
				}
			}
		}
		// there is no collision
		return false;
	}

	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation
	 * rot (values can be 0, 90, 180, 270) would cause an out of bounds
	 * condition (i.e., if there would be a block falling off the board).
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 */
	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		// for the 4X4 piece array
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// if there is a block
				if (currentPiece.isFilled(rot, i, j)) {
					// if the block is trying to cross over the right, left, or
					// bottom border of the board
					if (gridCol + j > NUM_COLS - 1 || gridCol + j < 0
							|| gridRow + i > NUM_ROWS - 1) {
						// there is an OutOfBounds error
						return true;
					}
				}
			}
		}
		// there is no OutOfBounds error
		return false;
	}

	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation
	 * rot (values can be 0, 90, 180, 270) is a valid move, by using
	 * detectOutOfBounds and detectCollision. Note that detectOutOfBounds should
	 * be checked first.
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 */
	private boolean validMove(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		// if there is neither an OutOfBounds error nor a collision
		if (!detectOutOfBounds(piece, rot, gridRow, gridCol)
				&& !detectCollision(piece, rot, gridRow, gridCol)) {
			// it is valid to move
			return true;
		}
		// it is not valid to move
		else {
			return false;
		}
	}

	/**
	 * Check if there is a block in the row and column.
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean hasBlock(int row, int col) {
		// get piece grid position
		currentPieceGridPosition = getCurrentPieceGridPosition();
		// get piece rotation
		int rot = currentPiece.getPieceRotation();
		// for the 4X4 piece array
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				// the row index in the board where there is a block
				int rowBoard = currentPieceGridPosition[0] + i;
				// the column index in the board where there is a block
				int colBoard = currentPieceGridPosition[1] + j;
				// if the position being checked holds a block
				// and the corresponding piece also holds a block there
				if (rowBoard == row && colBoard == col
						&& currentPiece.isFilled(rot, i, j)) {
					// there is the block at the position that is passed in
					return true;
				}
			}
		}
		// return the value of the block matrix
		return blockMatrix[row][col];
	}

	/**
	 * Add a new random Tetris piece to the board at grid position (0, 3).
	 */
	public void addNewPiece() {
		// get a random number from 0 to 6
		int n = (int) (Math.random() * 6);
		// assign each number to a piece
		// so that we get random pieces to appear
		if (n == 0)
			currentPiece = new I();
		else if (n == 1)
			currentPiece = new J();
		else if (n == 2)
			currentPiece = new L();
		else if (n == 3)
			currentPiece = new O();
		else if (n == 4)
			currentPiece = new S();
		else if (n == 5)
			currentPiece = new T();
		else if (n == 6)
			currentPiece = new Z();
		// set the initial position of the new piece
		currentPieceGridPosition[0] = 0;
		currentPieceGridPosition[1] = 3;
	}

	/**
	 * Detect and remove any lines formed.
	 * 
	 */
	public int numberOfFormedLines() {
		// reset number of lines to 0
		numLines = 0;
		// for each row
		for (int i = 0; i < NUM_ROWS; i++) {
			// if there is a full line
			if (fullLine(i)) {
				// remove the line
				removeLine(i);
				// add to number of lines
				numLines++;
			}
		}
		return numLines;
	}

	/**
	 * Detect and remove any tetrises formed.
	 * 
	 */
	public int numberOfTetrises() {
		// if the user removes 4, 8, 12, 16, or more lines at once
		// update the number of corresponding tetrises removed
		if (numLines >= 4)
			return 1;
		else if (numLines >= 8)
			return 2;
		else if (numLines >= 12)
			return 3;
		else if (numLines >= 16)
			return 4;
		else
			return 0;
	}

	/**
	 * Check if there is a full line at the row.
	 * 
	 * @param row
	 * @return
	 */
	private boolean fullLine(int row) {
		// for all the columns
		for (int i = 0; i < NUM_COLS; i++) {
			// if there is one position where there is no block
			if (blockMatrix[row][i] == false) {
				// the line is not full
				return false;
			}
		}
		// else, congratulations, there is a line!
		return true;
	}

	/**
	 * Remove the line at row in the model. Shift all values for rows at a lower
	 * index to be at one row higher.
	 * 
	 * @param row
	 */
	private void removeLine(int row) {
		// from the row where there is a line to the top of the board
		for (int i = row; i > 0; i--) {
			// for all columns
			for (int j = 0; j < NUM_COLS; j++) {
				// if there is a block in the positions passed in
				if (hasBlock(i, j))
					// remove full lines and
					// move each remaining block down to where it is supposed to
					// be
					blockMatrix[i][j] = blockMatrix[i - 1][j];
			}
		}
	}

	/**
	 * @return the block matrix (the grid of blocks)
	 */
	public boolean[][] getBlockMatrix() {
		return blockMatrix;
	}

	/**
	 * @return the currentPiece
	 */
	public TetrisPiece getCurrentPiece() {
		return currentPiece;
	}

	/**
	 * @return the currentPieceGridPosition
	 */
	public int[] getCurrentPieceGridPosition() {
		return currentPieceGridPosition;
	}

	/**
	 * @return the numCols in the block matrix
	 */
	public int getNumCols() {
		return NUM_COLS;
	}

	/**
	 * @return the numRows in the block matrix
	 */
	public int getNumRows() {
		return NUM_ROWS;
	}

}
