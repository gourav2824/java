
public class Recursion {

	public static void main(String[] args) {
		
		boolean[][] board = new boolean[3][3];
		long start = System.currentTimeMillis();
		//printNQueensReactive(board, 1, 0, "");
		//printNQueensProActive(board, 1, 0, "");
		//printNQueensSubSetA(board, 1, 1, "");
		//printNKnights(board, 1, 1, "");
		long end = System.currentTimeMillis();
		System.out.print(end - start);
	}
	
	static int count = 0;
	
	private static void printNQueensReactive(boolean[][] board, int cq, int lqb, String asf) {
		
		if(cq > board.length) {
			if(isTheBoardValid(board) == true) {
				System.out.println(++count + ". " + asf);
			}
			return;
		}
		
		for(int i = lqb + 1; i <= board.length * board.length; i++) {
			int rno = (i - 1) / board.length;
			int cno = (i - 1) % board.length;
			
			if(board[rno][cno] == false) {
				
				board[rno][cno] = true;
				printNQueensReactive(board, cq + 1, i, asf + i + " ");
				board[rno][cno] = false;
			}
		}
	}
	
	private static void printNQueensProActive(boolean[][] board, int cq, int lqb, String asf) {
		
		if(cq > board.length) {
			System.out.println(++count + ". " + asf);
			return;
		}
		
		for(int i = lqb + 1; i <= board.length * board.length; i++) {
			int rno = (i - 1) / board.length;
			int cno = (i - 1) % board.length;
			
			if(board[rno][cno] == false && isTheQueenSafe(board, rno, cno) == true) {
				
				board[rno][cno] = true;
				printNQueensProActive(board, cq + 1, i, asf + i + " ");
				board[rno][cno] = false;
			}
		}
	}
	
	private static void printNQueensSubSetA(boolean[][] board, int cq, int cb, String asf) {
		
		if(cq > board.length) {
			System.out.println(++count + ". " + asf);
			return;
		}
		
		if(cb > board.length * board.length) {
			return;
		}
		
		printNQueensSubSetA(board, cq, cb + 1, asf);
		
		int row = (cb - 1) / board.length;
		int col = (cb - 1) % board.length;
		
		if(board[row][col] == false) {
			if(isTheQueenSafe(board, row, col) == true) {
				board[row][col] = true;
				printNQueensSubSetA(board, cq + 1, cb + 1, asf + cb + " ");
				board[row][col] = false;
			}
		}
	}
	
	private static boolean isTheBoardValid(boolean[][] board) {
		
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) {
				if(board[row][col] == true) {
					if(isTheQueenSafe(board, row, col) == false) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
//	private static boolean isTheQueenSafe(boolean[][] board, int row, int col) {
//		
//		int cellno = row * board.length + col + 1;
//		
//		board[row][col] = false;
//		for(int i=0; i < board.length; i++) {
//			if(board[row][col + i] == true) {
//				return false;
//			}
//		}
//		
//		for(int i=0; i < board.length; i++) {
//			if(board[row + i][col] == true) {
//				return false;
//			}
//		}
//		board[row][col] = true;
//		
//		while(cellno <= board.length * board.length) {
//			
//			int rno = (cellno - 1) / board.length;
//			int cno = (cellno - 1) / board.length;
//			if(board[rno][cno] == true) {
//				return false;
//			}
//			cellno += board.length + 1;
//		}
//		
//		return true;
//	}
	
	private static boolean isTheQueenSafe(boolean[][] board, int row, int col) {
		
		int[][] dirs = {
				{-1, 0}, // North
				{-1, 1},
				{0, 1},
				{1, 1},
				{1, 0},
				{1, -1},
				{0, -1},
				{-1, -1}
		};
		
		for(int rad=1; rad < board.length; rad++) {
			for(int[] dir : dirs) {
				
				int row_enemy = row + rad * dir[0];
				int col_enemy = col + rad * dir[1];
				
				if(row_enemy >= 0 && row_enemy < board.length &&
				   col_enemy >= 0 && col_enemy < board.length &&
				   board[row_enemy][col_enemy] == true) {
					
					return false;
				}
			}
		}
		return true;
	}
	
	private static void printNKnights(boolean[][] board, int ck, int cb, String asf) {
		
		if(ck > board.length) {
			System.out.println(++count + ". " + asf);
			return;
		}
		
		if(cb > board.length * board.length) {
			return;
		}
		
		printNKnights(board, ck, cb + 1, asf);
		
		int row = (cb - 1) / board.length;
		int col = (cb - 1) % board.length;
		
		if(board[row][col] == false) {
			if(isTheKnightSafe(board, row, col) == true) {
				board[row][col] = true;
				printNKnights(board, ck + 1, cb + 1, asf + cb + " ");
				board[row][col] = false;
			}
		}
	}
	
	private static boolean isTheKnightSafe(boolean[][] board, int row, int col) {
		
		int[][] dirs = {
				{-2, +1},
				{-1, +2},
				{+1, +2},
				{+2, +1},
				{-2, -1},
				{-1, -2},
				{+1, -2},
				{+2, -1}
		};
		
		for(int[] dir : dirs) {
			
			int row_enemy = row + dir[0];
			int col_enemy = col + dir[1];
			
			if(row_enemy >= 0 && row_enemy < board.length &&
			   col_enemy >= 0 && col_enemy < board.length &&
			   board[row_enemy][col_enemy] == true) {
				
				return false;
			}
		}
		
		return true;
	}
	
	
}