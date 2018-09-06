import java.util.Scanner;

public class Arrays {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = { 4, 5, -12, 3, 6, -2, 5, -20, 1, 2, 8 };
		
		int[] board = new int[25];
		
		board[2] = 18;
		board[13] = 22;
		board[21] = 9;
		board[23] = 4;
		
		int[] dice = {2, 3, 6, 4, 1, 3, 2, 5, 4, 1, 6, 2, 3, 6, 5, 3};
		
		// SubArrayMaxSum(arr);
		SnakesAndLadders(board, dice);
	}

	private static void SubArrayMaxSum(int[] arr) { // KADANES ALGORITHM

		int cmax = arr[0], omax = arr[0], cs = 0, ce = 0, os = 0, oe = 0; // os = ostart, oe = oend

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] <= cmax + arr[i]) { // if(cmax >= 0)
				cmax += arr[i];
				ce++;
			} else {
				cs = i;
				ce = i;
				cmax = arr[i];
			}

			if (cmax > omax) {
				omax = cmax;
				os = cs;
				oe = ce;
			}
		}

		System.out.println("Maximum Sum = " + omax);
		System.out.print("Sub Array = ");
		for (int i = os; i <= oe; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void SnakesAndLadders(int[] board, int[] dice) {

		int pos = 0;
		boolean gameStart = false;

		int i = 0;
		while (i < dice.length) {
			if (gameStart == false) {
				if (dice[i] == 1 || dice[i] == 6) {
					gameStart = true;
					pos++;
				}
			}

			else {
				pos += dice[i];

				if (pos > (board.length - 1)) {
					pos -= dice[i];
				}

				else {
					if (board[pos] != 0) {
						pos = board[pos];
					}
				}
			}
			i++;
		}
		
		System.out.print("Final Position = " + pos);
	}
	
	private static void SumOf2Arrays(int[] arr1, int[] arr2) {
		
		
	}
}