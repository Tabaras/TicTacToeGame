package ticTacToe;

import java.util.Scanner;

public class TTT {

	public static int row, col;
	static Scanner s = new Scanner(System.in);
	public static char[][] board = new char[3][3];
	public static char turn = 'X';

	public static void main(String[] args) {
		// populam array-urile cu nested loop
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = '_';
			}

		}

		printBoard();
		play();

	}

	public static void play() {
		
		boolean playing = true;
		// cat timp playing este true aplicatia merge
		while (playing) {
			// pozitia din matrice (ex: 0.0, 1.3 etc) unde va revenii X sau O

			System.out.println("Please enter the row: ");
			row = s.nextInt() - 1;

			System.out.println("Please enter the col: ");
			col = s.nextInt() - 1;
			
			board[row][col] = turn;
			
			if (gameOver(row, col)) {
				System.out.println("Game over, player " + turn + " wins!");
				printBoard();
				// playing = false;
				return;

			}
			printBoard();

			if (turn == 'X') {
				turn = 'O';
			} else
				turn = 'X';

		} // end while

	}// end play method

	public static void printBoard() {
		// printam boardul astfel incat sa obtinem 9 casute
		System.out.println("  Column");
		System.out.println(" _ _ _ _ _ _");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				// cand j ul este 0 mai printam o linie
				if (j == 0) {
					System.out.print("| ");
				}

				System.out.print(board[i][j] + " | ");
			}

			System.out.println();

		}

	}

	public static boolean gameOver(int rowMove, int colMove) {
		if (board[0][colMove] == board[1][colMove] && board[0][colMove] == board[2][colMove]) {
			return true;
		}
		if (board[rowMove][0] == board[rowMove][1] && board[rowMove][0] == board[rowMove][2]) {
			return true;
		}
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') {
			return true;
		}
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_')
			return true;

		return false;
	}

}
