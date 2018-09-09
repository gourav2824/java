import java.util.Scanner;

public class TwoDArrays {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//WaveDisplay();
		//SpiralDisplay();
		CardGame(sc);
	}

	private static void WaveDisplay() {

		int[][] arr = { { 1, 2, 3, 4, 5 },
						{ 6, 7, 8, 9, 10 },
						{ 11, 12, 13, 14, 15 },
						{ 16, 17, 18, 19, 20 } };

		boolean down = true;
		int i = 0, j = 0;

		while (j < arr[0].length) {

			if (down == true) {
				if (i == arr.length - 1) {
					down = false;
					System.out.print(arr[i][j] + " ");
					j++;
				}

				else {
					System.out.print(arr[i][j] + " ");
					i++;
				}
			}

			else {
				if (i == 0) {
					down = true;
					System.out.print(arr[i][j] + " ");
					j++;
				}

				else {
					System.out.print(arr[i][j] + " ");
					i--;
				}
			}
		}
	}
	
	private static void SpiralDisplay() {
		
		int[][] arr = { { 1, 2, 3, 4, 5 },
						{ 6, 7, 8, 9, 10 },
						{ 11, 12, 13, 14, 15 },
						 };
		
		int rs=0, re=arr.length-1, cs=0, ce=arr[0].length-1;
		int count=1;
		int total = arr.length * arr[0].length;
		int i,j;
		
		while(count <= total) {
			
			for(i=rs; count <= total && i<=re; i++) {
				System.out.print(arr[i][cs] + " ");
				count++;
			}
			cs++;
			
			for(j=cs; count <= total && j<=ce; j++) {
				System.out.print(arr[re][j] + " ");
				count++;
			}
			re--;
			
			for(i=re; count <= total && i>=rs; i--) {
				System.out.print(arr[i][ce] + " ");
				count++;
			}
			ce--;
			
			for(j=ce; count <= total && j>=cs; j--) {
				System.out.print(arr[rs][j] + " ");
				count++;
			}
			rs++;
		}
	}
	
	private static void CardGame(Scanner sc) {
		
		int n = sc.nextInt();
		int moves = 3;
		
		boolean[] win = new boolean[n];
		
		
	}
}