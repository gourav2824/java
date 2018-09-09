import java.util.Scanner;

public class TwoDArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		bulbs(sc);
		//ExitPoint();
		//NinetyClockwiseRotate();
	}
	
	private static void bulbs(Scanner sc) {
		
		int n = sc.nextInt();
		boolean[] bulbs = new boolean[n];
		
		for(int i=1; i*i<=n; i++) {
			System.out.print(i*i + " ");
		}
	}
	
	private static void ExitPoint() {
		
		int[][] maze = {
				{0, 0, 1, 0},
				{1, 0, 0, 0},
				{0, 0, 0, 0},
				{1, 0, 1, 0}
		};
		
		int row = maze.length;
		int col = maze[0].length;
		int i=0, j=0, dir=0;
		// dir = (0 : East, 1 : South, 2 : West, 3 : North)
		
		while((i < row) && (j < col) && (i > -1) && (j > -1)) {
			
			dir = (dir + maze[i][j]) % 4;
			
			if(dir == 0)
				j++;
			
			else if(dir == 1)
				i++;
			
			else if(dir == 2)
				j--;
			
			else if(dir == 3)
				i--;
		}
		
		if(dir == 0)
			j--;
		else if(dir == 1)
			i--;
		else if(dir == 2)
			j++;
		else if(dir == 3)
			i++;
		
		System.out.print("Exit Point : " + i + " " + j);
	}
	
	private static void Display(int[][] arr) {
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void NinetyClockwiseRotate() {
		
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		int dim = arr.length;
		int i=0, j=0;
		
		// Transpose
		while(i < dim) {
			
			int k=i;
			while(k < dim) {
				
				int temp = arr[i][k];
				arr[i][k] = arr[k][i];
				arr[k][i] = temp;
				
				k++;
			}
			i++;
		}
		
		Display(arr);
		
		// Reverse
		for(i=0; i<dim; i++) {
			int left = 0;
			int right = dim - 1;
			
			while(left < right) {
				
				int temp = arr[i][left];
				arr[i][left] = arr[i][right];
				arr[i][right] = temp;
				
				left++;
				right--;
			}
		}
		
		System.out.println();
		Display(arr);
	}
	
	private static void WaveDisplay() {
		
		int[][] arr = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		boolean down = true;
		
		for(int j=0; j < arr.length; j++) {
			for(int i=0; i < arr[0].length; i++) {
				
				System.out.print(arr[i][j] + " ");
				
				if(j)
				
				if(down == true) {
					i++;
				}
			}
		}
	}
}