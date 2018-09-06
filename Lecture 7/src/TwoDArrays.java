import java.util.Scanner;

public class TwoDArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//int row1=3, col1=3, row2=3, col2=3;
		int[][] mat1 = {
				{1, 0, 0},
				{0, 1, 0},
				{0, 0, 1}
		};
		
		int[][] mat2 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		MatrixMultiply(mat1, mat2);
	}
	
	private static void DisplayMatrix(int[][] arr) {
		
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	private static void MatrixMultiply(int[][] mat1, int[][] mat2) {
		
		int[][] res = new int[3][3];
		
		System.out.println("First Matrix :-");
		DisplayMatrix(mat1);
		System.out.println();
		System.out.println("Second Matrix :-");
		DisplayMatrix(mat2);
		
		int row1 = mat1.length;
		int col1 = mat1[0].length;
		int row2 = mat2.length;
		int col2 = mat2[0].length;
		
		if(col1 != row2) {
			System.out.print("Matrices cannot be multiplied");
			return;
		}
		
		else {
			for(int i = 0; i < row1; i++) {
				for(int j = 0; j < col2; j++) {
					for(int k = 0; k < col1; k++) {
						res[i][j] += mat1[i][k] * mat2[k][j];
					}
				}
			}
		}
		
		System.out.println();
		System.out.println("Resultant Matrix :-");
		DisplayMatrix(res);
	}
}