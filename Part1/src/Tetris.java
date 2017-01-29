import java.awt.*;
//TetrisController
/**
 * Tetris is the controller for the Tetris game. 
 * It takes input from the user and make changes to the board accordingly. 
 * Should implements KeyListener
 */

public class Tetris{

//shows the user information about scores and instructions
	//private JLabel label;
//window that holds the Tetris Board
	//private JFrame frame;

//the width of the board
	private int boardWidth;
	private int boardHeight; 

//a standard Tetris board
	private Board board;

//the Tetris game that we are playing 
	private Tetris game;

//checks if the game is over
	private boolean gameOver;

/**
* Constructor. Sets up model and view instance variables.
*/
public Tetris(){}

/**
* Necessary for KeyListener
* Listens for key input from user
* parameter takes in KeyEvent e
*/
public void keyTyped() {
}

/**
* Updates board with userInput
* Calls getScore and updateScore from board
* arrow keys for move left, move right, move down
* z for rotate counter-clockwise, x for rotate clockwise
*/
public void updateBoard(int​ userInput){
}

/** Necessary for KeyListener implementation 
* parameter takes in KeyEvent e
*/
public void​ keyPressed() {
}
/** Necessary for KeyListener implementation 
* parameter takes in KeyEvent e
*/
public void​ keyReleased() {
}

/**
* Set­up the model, view, KeyListener
*/
public void main(){}

}