import java.util.Scanner;

public class MatrixRotate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[][] mat = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = scn.nextInt();
			}
		}
		
		rotateMatrix(n, mat);
	}
	
	private static void rotateMatrix(int n, int[][] arr) {
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(j >= i) {
					int val = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = val;
				}
			}
		}
		
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < n; i++) {
				
				if(i < (n / 2)) {
					int val = arr[i][j];
					arr[i][j] = arr[n - 1 - i][j];
					arr[n - 1 - i][j] = val;
				}
			}
		}
		
		displayMatrix(n, arr);
	}
	
	public static void displayMatrix(int N, int mat[][]) 
    { 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(mat[i][j]+" "); 
       
            System.out.print("\n"); 
        } 
        System.out.print("\n"); 
    }
}