package eightQueens;

public class chessBoard {
	//2d int array for the board
	private static int board[][];
	//number of queens on board
	private int numQueens;
	private int solutions;
	private static int rowToSkip;
	
	public chessBoard(int inputCol, int inputRow) {
		//init the number of queens and the board size
		numQueens = 0;
		solutions = 0;
		board = new int[8][8];
		//initialise the board to be all 0s
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				board[row][col] = 0;
			}
		}
		//handles the user inputted values
		board[inputRow][inputCol] = 1;
		numQueens++;
		rowToSkip = inputRow;
		this.printBoard();
	}
	
	public int getNumQueens() {
		return numQueens;
	}
	
	public void start() {
		solve(1, 0);
	}
	
	public boolean solve(int numQueens, int row) {
		if (row == rowToSkip) {
			row++;
			//System.out.println("skipping occupied row");
		}
		//exits if 8 placed
		if (row >= 8) {
			solutions++;
			System.out.println("Solution " + solutions);
			this.printBoard();
			return true;
		}
		//if not done, iterate thru whole row
		for (int col = 0; col < 8; col++) {
			//if the space is safe, place a queen
			if (checkSafe(row,col) == 0) {
				//System.out.println("placing queen at " + row + " " + col);
				this.placeQueen(row, col, 0);
				numQueens++;
				//System.out.println("numQueens: " + numQueens);
				//if the problem can be solved using recursion return true
				solve(numQueens, row+1);
				
				this.placeQueen(row, col, 1);
				numQueens--;
			} else {
				//System.out.println("unsafe to place queen at" + row + " " + col);
			}
			
		}
		//System.out.println("solve returned false");
		return false;
		
	}
	
	//this method checks if the given xy value is safe, returns -1 if not and 0 if is
	public static int checkSafe(int row, int col) {
		//check vertical
		for (int i = 0; i < 8; i++) {
			if (get(i,col) == 1) {
				return -1;
			}
		}
		//check diagonal
		for (int i = 0; i < 8; i++) {
			//up left
			if (get(row-i, col-i) == 1) {
				return -1;
			}
			//down left
			if (get(row-i, col+i) == 1) {
				return -1;
			}
			//up right
			if (get(row+i, col-i) == 1) {
				return -1;
			}
			//down right
			if (get(row+i, col+i) == 1) {
				return -1;
			}
		}
		return 0;
	}
	
	//code to place a queen. takes the xy value + a type (0 for place, 1 for remove)
	public int placeQueen(int x, int y, int type) {
		if (type == 0) {
			board[x][y] = 1;
			numQueens++;
			return 0;
		}
		else if (type == 1) {
			board[x][y] = 0;
			return 0;
		}
		System.out.println("Wrong type to placeQueen");
		return -1;
	}
	
	public static int get(int x, int y) {
		if (x < 0 || y < 0 || x > 7 || y > 7) {
			//System.out.println("invalid coordinates to get method");
			return -1;
		}
		return board[x][y];
	}
	
	public void printBoard() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				System.out.print(this.get(x,y) + " ");
			}
			System.out.println("");
		}
	}
}
