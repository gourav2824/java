import java.util.Scanner;

public class ques4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt(), col = sc.nextInt();
		int[][] matrix = new int[row][col];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				matrix[i][j] = sc.nextInt();
		System.out.println(countWays(matrix));

	}

	public static int countWays(int[][] matrix) {
		
		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		int count = ways(matrix, visited, 0, 0);
		return count;
	}
	
	private static int ways(int[][] arr, boolean[][] visited, int i, int j) {
		
		if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
			return 0;
		}
		
		if(arr[i][j] == 0 || visited[i][j] == true) {
			return 0;
		}
		
		if(i == arr.length - 1 && j == arr[0].length - 1) {
			return 1;
		}
		
		int count = 0;
		visited[i][j] = true;
		
		count += ways(arr, visited, i + 1, j);
		count += ways(arr, visited, i - 1, j);
		count += ways(arr, visited, i, j + 1);
		count += ways(arr, visited, i, j - 1);

		visited[i][j] = false;
		return count;
	}
}