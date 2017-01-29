import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * TetrisBoardGUIController extends JPanel and holds JLabels and implements
 * KeyListener. Thus it shows and updates the scores and the view and read key
 * input.
 * 
 * @author Kuan Chi Chen
 * 
 */
public class TetrisGameGUIController extends JPanel implements KeyListener {
	// this is something that eclipse prompted me to make
	// in order to not get the following warning
	// The serializable class TetrisGameGUIController does not declare a static
	// final serialVersionUID field of type long
	private static final long serialVersionUID = 1L;
	// the default drop rate is 0.5 second
	public final int DEFAULT_DROP_RATE = 500;
	// the game that the user is playing
	private TetrisGame game;
	// the view that the user sees
	TetrisBoardGUIView view;
	// the JLabel that shows how many lines are cleared
	JLabel linesLabel;
	// the JLabel that shows how many tetrises are cleared
	JLabel tetrisesLabel;
	// the timer that times the automatic drop of pieces
	Timer gameTimer;
	// records faster and faster drop rate for higher levels
	int dropRate = DEFAULT_DROP_RATE;

	/**
	 * constructor that sets up the view and the game
	 */
	public TetrisGameGUIController() {
		// use border layout for the controller panel
		super(new BorderLayout());

		// set up game and view
		game = new TetrisGame();
		view = new TetrisBoardGUIView(game.getTetrisBoard());

		// create another panel inside the controller panel
		// that holds the labels
		JPanel labelPanel = new JPanel(new FlowLayout());
		// initiate the linesLabel and the linesLabel
		linesLabel = new JLabel("Number of lines cleared: " + 0);
		tetrisesLabel = new JLabel("Number of Tetrises cleared: " + 0);

		// add the labelPanel to the controller panel
		this.add(labelPanel, BorderLayout.NORTH);
		// add the linesLabel and the linesLabel to the labelPanel
		labelPanel.add(linesLabel);
		labelPanel.add(tetrisesLabel);

		// create the view of the board
		createView();
		// set up the timer
		setupTimer();

		// add the key listener
		setFocusable(true);
		addKeyListener(this);

	}

	/**
	 * sets up the timer
	 */
	private void setupTimer() {
		// create a timer to drop pieces down
		gameTimer = new Timer(dropRate, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// update the board class through a method in the game class
				game.moveTimeForward();
				// repaint the view because the blocks are falling
				view.repaint();

				// if the game is lost
				if (game.checkifEnd() == true) {
					// stop the timer
					gameTimer.stop();
					// tell the user he/she lost
					linesLabel.setText("You lost!");
				}
			}
		});
		// have a initial pause of 1 second after the start of the program
		// before the first piece starts falling
		// so that the user has time to adjust
		int pause = 1000;
		gameTimer.setInitialDelay(pause);
		// start the game
		gameTimer.start();
		// attempt to end the game, but didn't work

	}

	/**
	 * create the view of the board
	 */
	private void createView() {
		// add the view to the controller panel
		this.add(view, BorderLayout.CENTER);
	}

	/**
	 * update the scores
	 */
	private void createScore() {
		// update the number of cleared lines and actually clear the lines
		linesLabel.setText("Number of lines cleared: "
				+ Integer.toString(game.getNumLines()));
		// update the number of cleared tetrises and actually clear the tetrises
		tetrisesLabel.setText("Number of Tetrises cleared: "
				+ Integer.toString(game.getNumTetrises()));
	}

	/**
	 * needed for implementing KeyListener
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * reads key input and do the relating behavior
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// "KeyCode" is the enum of the key that was pressed
		int key = e.getKeyCode();
		// if down key is pressed
		if (key == KeyEvent.VK_DOWN) {
			// move the piece down and update
			game.attemptMove(0);
			createScore();
		}
		// if right key is pressed
		if (key == KeyEvent.VK_RIGHT) {
			// move the piece right and update
			game.attemptMove(1);
			createScore();
		}
		// if left key is pressed
		if (key == KeyEvent.VK_LEFT) {
			// move the piece left and update
			game.attemptMove(2);
			createScore();
		}
		// if x key is pressed
		if (key == KeyEvent.VK_X) {
			// rotate the piece counter-clockwise and update
			game.attemptMove(3);
			createScore();
		}
		// if z key is pressed
		if (key == KeyEvent.VK_Z) {
			// rotate the piece clockwise and update
			game.attemptMove(4);
			createScore();
		}
		// if e, as in exit, key is pressed
		if (key == KeyEvent.VK_E) {
			// restart game
			game.restart();
			createScore();
			dropRate = DEFAULT_DROP_RATE;
			gameTimer.setDelay(dropRate);
			gameTimer.restart();
		}
		// if u key is pressed
		if (key == KeyEvent.VK_U) {
			// increase the drop rate
			dropRate = dropRate - 50;
			gameTimer.setDelay(dropRate);
		}
	}

	/**
	 * needed for implementing KeyListener
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}
}
