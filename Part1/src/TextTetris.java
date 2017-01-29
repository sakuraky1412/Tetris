import java.awt.*;
//TetrisController
/**
 * Tetris is the controller for the Tetris game. 
 * It takes input from the user and make changes to the board accordingly. 
 * Should implements KeyListener
 */

public class TextTetris{

//the Tetris game that we are playing 
	private Tetris game;

//checks if the game is over
	private boolean gameOver;

/**
* Constructor. Sets up model and view instance variables.
*/
public TextTetris(){}

/**
* Necessary for KeyListener
* Listens for key input from user
* call the according methods to do the necessary behavior when a command is received
* parameter takes in KeyEvent e
* l for move left, r for move right, d for down
* z for rotate counter-clockwise, x for rotate clockwise
*/
public void keyTyped() {
}

/**
* Updates board with userInput
* Calls getScore and updateScore from board
*/
public void updateBoard(int​ userInput){
}

/**
* Set­up the model, view, KeyListener
*/
public void main(){}

}