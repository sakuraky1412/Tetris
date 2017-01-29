import java.awt.*;

//Board
/**
* Board represents a standard Tetris board.
* It stores information about the current state of the game. 
* It has functions that can be called by the controller.
*/

public class​ TextBoard {

//check if the game starts
	private boolean start;
//check if a certain piece had fallen into place
	private boolean fallen;

//the score of the user
	private int score;
//the number of lines that the user had cleared
	private int linesCleared;

//the left border of the board where the pieces should not be able to move across
	private int borderLeft;
//the right border of the board where the pieces should not be able to move across
	private int borderRight;
//the bottom border of the board where the pieces should not be able to move across
	private int borderBottom;
//the top border of the board where if the pieces piled up across, the user loses
	private int borderTop;
//remember the time since the piece had fallen from the top to let the piece fall down slowly
	//private Timer timer = new Timer(speed, this);
//the array that stores the pieces
	private String[] board;

/**
* Set­up fields
*/
public TextBoard(){

}

/**
* The getScore method returns the current score
* @return the current score
*/
public int getScore(int score){
	return 0;
}

/**
* The updateScore method updates the score of the user 
* @return the score.
*/
public int updateScore(int lineCleared){
	return 0;
}

/**
* The updateTetris method updates the tetris cleared by the user 
*/
public int updateTetris(int tetris){
	return 0;
}

/**
* check if the piece can be moved
*/
public boolean​ tryMove (int​ x, int y, Piece piece){
	return false;
}

/**
* check if a line is filled with blocks
*/
public boolean​ lineFilled (String[] board){
	return false;
}

/**
* check if the pieces went over the top border of the board
*/
public boolean​ gameLost (String[] board, int x){
	return false;
}

/**
* start the game
*/
private void start() {
}

/**
* clear the board if the game is lost
*/
private void clearBoard() {
}

/**
* stop the piece if it had fallen into place
* updates fallen to true
*/
private void pieceFallen(boolean fallen, Piece piece) {
}

/**
* start a new piece falling from the top
*/
private void newPiece() {
}

/**
* clear a line of blocks if filled
* updates line cleared
*/
private int clearLine() {
	return 0;
}

/**
* move the blocks down
*/
private int fallDown(Piece piece) {
	return 0;
}

/**
* clear four lines at once	
* updates tetrices cleared
*/
private int tetris() {
	return 0;

}

}


