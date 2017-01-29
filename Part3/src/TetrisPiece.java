/**
 * The TetrisPiece abstract class represents a piece made of 4 TetrisBlocks. It
 * maintains 4 rotations (0 degrees, 90 degrees, 180 degrees and 270 degrees),
 * with each being a 4x4 grid with certain filled squares.
 * 
 * @author Kuan Chi Chen
 */
public abstract class TetrisPiece {
	// 3 dimensional array maintaining which squares are filled first dimension
	// is rotation (index 0: 0 degrees, index 1: 90 degrees, index 2: 180
	// degrees, index 3: 270 degrees) second and third dimensions create 4x4
	// grid with true values indicating filled squares
	public boolean[][][] filledSquares = new boolean[4][4][4];
	//Maintains the current rotation.
	protected int pieceRotation;

	public TetrisPiece() {
	}

	public void rotateCW() {

	}

	public void rotateCCW() {

	}

	public int getPieceRotation() {
		return pieceRotation;
	}

	public boolean isFilled(int rot, int row, int col) {
		return false;
	}
}
