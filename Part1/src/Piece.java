import java.awt.*;

//Piece
/**
* Piece creates the 7 unique pieces of a Tetris standard game
*/
public class​ Piece {

//the I shaped piece of a standard Tetris game 
	public Piece I;  
//the J shaped piece of a standard Tetris game
	public Piece J; 
//the L shaped piece of a standard Tetris game 
	public Piece L;  
//the O shaped piece of a standard Tetris game 
	public Piece O;  
//the S shaped piece of a standard Tetris game 
	public Piece S;  
//the T shaped piece of a standard Tetris game 
	public Piece T;  
//the Z shaped piece of a standard Tetris game 
	public Piece Z; 
//one building block of a standard Tetris piece
	public Piece block; 
//the current piece that is falling down the board
	public Piece currentPiece; 
//the next piece that will be falling down the board
	public Piece nextPiece; 

//the color of the next piece
	private Color nextPieceColor;

//the size of each building block of a standard Tetris piece
	private int blockSize;

//the coordinates of a tetris piece
	private int[][] coord;

//the table of the coordinates of a tetris piece
	private int[][][] coordsTable;

/**
* Constructor. Initializes instance variables.
*/
public Piece(){
}

/**
* get an x coordinate of a block
*/
public int getX(Piece block){
	return 0;
}

/**
* get an y coordinate of a block
*/
public int getY(Piece block){
	return 0;

}

/**
* get a piece
*/
public Piece getPiece(Piece piece){
	return null;

}

/**
* set an x coordinate of a block
*/
public void​ setX(){
}

/**
* set an y coordinate of a block
*/
public void setY(){
}

/**
* set a piece
*/
public void setPiece(){
}

/**
* move the piece left
*/
public void left(Piece piece){
}

/**
* move the piece right
*/
public void right(Piece piece){
}

/**
* move the piece down
*/
public void down(Piece piece){
}

/**
* rotate a piece to the left
*/
public void rotateLeft(Piece piece){
}

/**
* rotate a piece to the right
*/
public void rotateRight(Piece piece){
}

/**
* set the color of the next piece
*/
public void setColor(Piece piece){
}

/**
* draw the blocks of the piece
* Graphics g should be inside parameter
*/
public void drawBlock(int x, int y, Piece piece){
}

}