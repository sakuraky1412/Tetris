/**
 * This class represents the Tetris piece that looks like an L.
 * 
 * @author Kuan Chi Chen
 */
public class L extends TetrisPiece {
	// 3 dimensional array maintaining which squares are filled
	public boolean[][][] filledSquares = new boolean[4][4][4];
	// maintains the current rotation
	protected int pieceRotation = 0;

	/**
	 * Constructor sets up inherited field filledSquares.
	 */
	public L() {
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					filledSquares[k][i][j] = false;
				}
			}
		}

		filledSquares[0][0][1] = true;
		filledSquares[0][1][1] = true;
		filledSquares[0][2][1] = true;
		filledSquares[0][2][2] = true;

		filledSquares[1][1][1] = true;
		filledSquares[1][1][2] = true;
		filledSquares[1][1][3] = true;
		filledSquares[1][2][1] = true;

		filledSquares[2][1][1] = true;
		filledSquares[2][1][2] = true;
		filledSquares[2][2][2] = true;
		filledSquares[2][3][2] = true;

		filledSquares[3][1][2] = true;
		filledSquares[3][2][0] = true;
		filledSquares[3][2][1] = true;
		filledSquares[3][2][2] = true;

	}

	/**
	 * Update the indices to rotate clockwise
	 */
	public void rotateCW() {
		if (pieceRotation == 0 || pieceRotation == 1 || pieceRotation == 2)
			pieceRotation++;
		else
			pieceRotation = 0;
	}

	/**
	 * Update the indices to rotate counterclockwise
	 */
	public void rotateCCW() {
		if (pieceRotation == 1 || pieceRotation == 2 || pieceRotation == 3)
			pieceRotation--;
		else
			pieceRotation = 3;
	}

	/**
	 * Get the rotation status aka the first index in the 3D array
	 */
	public int getPieceRotation() {
		return pieceRotation;
	}

	/**
	 * return true if there is a block at the position passed in
	 */
	public boolean isFilled(int rot, int row, int col) {
		if (filledSquares[rot][row][col])
			return true;
		else
			return false;

	}
}
