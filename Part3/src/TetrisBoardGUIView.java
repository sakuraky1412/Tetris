import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * TetrisBoardGUIView creates a GUI view of a TetrisBoard.
 * 
 * @author Kuan Chi Chen
 * 
 */
public class TetrisBoardGUIView extends JComponent {
	// this is something that eclipse prompted me to make
	// in order to not get the following warning
	// The serializable class TetrisBoardGUIView does not declare a static final
	// serialVersionUID field of type long
	private static final long serialVersionUID = 1L;
	// the tetris board
	private TetrisBoard board;
	// the number of rows in the board
	private int row;
	// the number of columns in the board
	private int col;
	// the size of blocks
	public static final int blockSize = 25;

	/**
	 * constructor assigns the passed in tetris board to this tetris board that
	 * we have inside the class
	 * 
	 * @param b
	 */
	public TetrisBoardGUIView(TetrisBoard b) {
		this.board = b;

	}

	/**
	 * paints the whole board and the blocks
	 */
	public void paint(Graphics g) {
		// get the number of rows and columns in the board
		col = board.getNumCols();
		row = board.getNumRows();
		// paint blocks
		paintBlock(g, row, col, blockSize);
		// paint board outline
		paintBoardOutline(g);
	}

	/**
	 * paint a black outline of the board
	 * 
	 * @param g
	 */
	private void paintBoardOutline(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(0, 0, 250, 450);
	}

	/**
	 * paint magenta blocks with black outlines
	 * 
	 * @param g
	 * @param row
	 * @param col
	 * @param blockSize
	 */
	private void paintBlock(Graphics g, int row, int col, int blockSize) {
		// for the whole board
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// if there is a block in the position passed in
				if (board.hasBlock(i, j)) {
					// paint a block here
					g.setColor(Color.magenta);
					g.fillRect(blockSize * j, blockSize * i, blockSize,
							blockSize);
					g.setColor(Color.black);
					g.drawRect(blockSize * j, blockSize * i, blockSize,
							blockSize);
				}
				// if there is no block
				else {
					// paint a blank space
					g.setColor(Color.white);
				}

			}

		}
	}

}
