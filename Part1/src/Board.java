import java.awt.*;

//Board
/**
* Board represents a standard Tetris board.
* It stores information about the current state of the game. 
* It has functions that can be called by the controller.
*/

public class​ Board {

//check if the game starts
	private boolean start;
//check if a certain piece had fallen into place
	// how the game determine where a piece "lands"?
	private boolean fallen;

//the rows of a standard Tetris board 
	private int row;
//the columns of a standard Tetris board
	private int col;
//the score of the user
	private int score;
//the number of lines that the user had cleared
	private int linesCleared;
//the amount of space to move the pieces
	private int moveSpace;
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
	private Boolean[] board;

/**
* Set­up fields
*/
public Board(){

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
* more specifically, a piece cannot move past the right and left borders of the board
* it also cannot move past other pieces
* or after it had fallen into place
* or when the game is lost
* updates boolean fallen and uses the border information, the boolean array and the pieces representing the board
* to determine whether the pieces should stop moving
*/
public boolean​ tryMove (int​ x, int y, Boolean[] board, Piece piece){
	return false;
}

/**
* check if a line is filled with blocks
*/
public boolean​ lineFilled (Boolean[] board){
	return false;
}

/**
* check if the pieces went over the top border of the board
* if so clear the board
*/
public boolean​ gameLost (Boolean[] board, int x){
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
* when the last piece had fallen into place
* that is to say if fallen is true
* updates fallen to be false
*/
private void newPiece() {
}

/**
* clear a line of blocks if filled
* updates lineCleared
* 
*/
private int clearLine(Boolean[] board) {
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
private int tetris(Boolean[] board) {
	return 0;

}

}


