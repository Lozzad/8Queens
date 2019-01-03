package eightQueens;

public class main {

	public static void main(String[] args) {
		int column = -1;
		int row = -1;
		
		while (column < 0 || column > 8) {
		//get user input
			System.out.println("enter the column (between 0 and 7) that you want to place a queen in:");
			column = BIO.getInt();
		}
		while (row < 0 || row > 8) {
			//get user input
				System.out.println("enter the row (between 0 and 7) that you want to place a queen in:");
				row = BIO.getInt();
		}
		System.out.println("queen placed at " + column + ", " + row);
		chessBoard board = new chessBoard(column, row);
		board.start();
	}

}
