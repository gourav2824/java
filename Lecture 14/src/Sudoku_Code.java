
public class Sudoku_Code {

	public static void main(String[] args) {

		int[][] sudoku = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		int[] rows = new int[9];
		int[] cols = new int[9];
		int[][] subm = new int[3][3];

		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[0].length; j++) {

				rows[i] = rows[i] | (1 << sudoku[i][j]);
				cols[j] = cols[j] | (1 << sudoku[i][j]);
			}
		}

//		for(int i=0; i < rows.length; i++) {
//			System.out.print(Integer.toBinaryString(rows[i]) + " ");
//			System.out.println(Integer.toBinaryString(cols[i]));
//		}

		int rmax = 9, cmax = 9, rval = 0, cval = 0, smr = 0, smc = 0;

		for (int i = 0; i < 3; i++) {

			if (rval >= rmax || cval >= cmax) {
				break;
			}

			for (int j = 0; j < 3; j++) {

				for (int row = 0; row < 3; row++) {
					for (int col = 0; col < 3; col++) {

						subm[smr][smc] = subm[smr][smc] | (1 << sudoku[row + rval][col + cval]);
					}
				}
				smc++;
				cval += 3;
			}
			smc = 0;
			cval = 0;
			smr++;
			rval += 3;
		}

//		for(int i=0; i < subm.length; i++) {
//			for(int j=0; j < subm[0].length; j++) {
//				System.out.print(Integer.toBinaryString(subm[i][j]) + " ");
//			}
//			System.out.println();
//		}

		Sudoku(sudoku, rows, cols, subm);

	}

	public static void Sudoku(int[][] sudoku, int[] rows, int[] cols, int[][] subm) {

//		int flag = 0;
//		for(int i=0; i < sudoku.length; i++) {
//			for(int j=0; j < sudoku[0].length; j++) {
//				if(sudoku[i][j] == 0)
//					flag = 1;
//			}
//		}
//		
//		if(flag == 0) {
//			for(int i=0; i < sudoku.length; i++) {
//				for(int j=0; j < sudoku[0].length; j++) {
//					System.out.print(sudoku[i][j] + " ");
//				}
//				System.out.println();
//			}
//			return;
//		}
//
		System.out.println(sudoku.length);
		System.out.println(sudoku[0].length);
		for (int i = 0; i < sudoku.length; i++) {
			System.out.println("adjj"+ i);
			for (int j = 0; j < sudoku[0].length; j++) {

				System.out.println("Values of i and j : " + i + " " + j);
				
				if (sudoku[i][j] == 0) {

					int rsub, csub;

//					if (i >= 0 && i <= 2)
//						rsub = 0;
//					else if (i >= 3 && i <= 5)
//						rsub = 1;
//					else
//						rsub = 2;
//
//					if (j >= 0 && j <= 2)
//						csub = 0;
//					else if (j >= 3 && j <= 5)
//						csub = 1;
//					else
//						csub = 2;
					
					rsub = i / 3;
					csub = j / 3;

					int bm = rows[i] | cols[j] | subm[rsub][csub];

					for (int k = 1; k <= 9; k++) {

						System.out.println("In Loop");
						if ((bm & (1 << k)) == 0) {

							System.out.println("In If Stmt");
							sudoku[i][j] = k;
							rows[i] = rows[i] | (1 << k);
							cols[j] = cols[j] | (1 << k);
							subm[rsub][csub] = subm[rsub][csub] | (1 << k);

							Sudoku(sudoku, rows, cols, subm);

							sudoku[i][j] = 0;
							rows[i] = rows[i] & (~(1 << k));
							cols[j] = cols[j] & (~(1 << k));
							subm[rsub][csub] = subm[rsub][csub] & (~(1 << k));
						}
					}
				}
			}
		}
		
		return;
	}
}