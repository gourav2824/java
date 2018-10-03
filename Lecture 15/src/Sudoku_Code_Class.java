
public class Sudoku_Code_Class {

	public static void main(String[] args) {
		
		int[][] sudoku = {
				{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 }
				};
		
		int[] rownos = new int[9];
		int[] colnos = new int[9];
		int[] sbnos = new int[9];
		
		for(int i=0; i < sudoku.length; i++) {
			for(int j=0; j < sudoku[0].length; j++) {
				
				if(sudoku[i][j] != 0) {
					makeAChoice(sudoku, i * sudoku.length + j + 1, rownos, colnos, sbnos, sudoku[i][j]);
				}
			}
		}
		
		Sudoku(sudoku, 1, rownos, colnos, sbnos);
	}
	
	public static void Sudoku(int[][] sudoku, int cellno, int[] rownos, int[] colnos, int[] sbnos) {
		
		if(cellno == 82) {
			
			for(int i=0; i < sudoku.length; i++) {
				for(int j=0; j < sudoku[0].length; j++) {
					System.out.print(sudoku[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		
		int rno = (cellno - 1) / sudoku.length;
		int cno = (cellno - 1) % sudoku[0].length;
		
		if(sudoku[rno][cno] == 0) {
			
			int rowno = rownos[rno];
			int colno = colnos[cno];
			int sbno = sbnos[(rno / 3) * 3 + (cno / 3)];
			
			int no = rowno | colno | sbno;
			
			for(int choice = 1; choice <= 9; choice++) {
				
				if((no & (1 << choice)) == 0) {
					
					makeAChoice(sudoku, cellno, rownos, colnos, sbnos, choice);
					Sudoku(sudoku, cellno + 1, rownos, colnos, sbnos);
					unmakeAChoice(sudoku, cellno, rownos, colnos, sbnos, choice);
				}
			}
		}
		
		else {
			Sudoku(sudoku, cellno + 1, rownos, colnos, sbnos);
		}
	}
	
	
	
	public static void makeAChoice(int[][] sudoku, int cellno, int[] rownos, int[] colnos, int[] sbnos, int choice) {
		
		int rno = (cellno - 1) / sudoku.length;
		int cno = (cellno - 1) % sudoku[0].length;
		
		sudoku[rno][cno] = choice;
		rownos[rno] ^= (1 << choice);
		colnos[cno] ^= (1 << choice);
		sbnos[(rno / 3) * 3 + (cno / 3)] ^= (1 << choice);
		
		return;
	}
	
	public static void unmakeAChoice(int[][] sudoku, int cellno, int[] rownos, int[] colnos, int[] sbnos, int choice) {
		
		int rno = (cellno - 1) / sudoku.length;
		int cno = (cellno - 1) % sudoku[0].length;
		
		sudoku[rno][cno] = 0;
		rownos[rno] ^= (1 << choice);
		colnos[cno] ^= (1 << choice);
		sbnos[(rno / 3) * 3 + (cno / 3)] ^= (1 << choice);
		
		return;
	}
}