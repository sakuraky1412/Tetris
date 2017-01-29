import javax.swing.JFrame;

/**
 * Command line version of the GUI Tetris game. I did some bonus features,
 * though I am not sure if they are exactly the same as required. 1. indicate
 * when the level has been lost 2. the user can choose to go to higher levels
 * with key input, where the speed of pieces falling increases as the level
 * increases 3. allow the user to restart a level with key input
 * 
 * @author Kuan Chi Chen
 * 
 */
public class TetrisGameGUIApplication {

	// Sets the width of the frame to 500 pixels
	public static int FRAME_WIDTH = 500;

	// Sets the height of the frame to 600 pixels
	public static int FRAME_HEIGHT = 600;

	/**
	 * Start the game!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// set up GUI controller
		TetrisGameGUIController myGame = new TetrisGameGUIController();
		// make a JFrame, tetrisFrame, that holds everything we need
		JFrame tetrisFrame = new JFrame("Tetris game application");
		// add our GUI controller to tetrisFrame
		tetrisFrame.add(myGame);
		// set the size of tetrisFrame
		tetrisFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		// determine how to close tetrisFrame
		tetrisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set tetrisFrame to be visible
		tetrisFrame.setVisible(true);
	}
}
