import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int r = scn.nextInt();
		int c = scn.nextInt();
		
//		if(r == 0 && c == 0) {
//			System.out.println("0, 0");
//			return;
//		}
		
		int[][] arr = new int[r][c];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		
		exitPointofMatrix(arr);
	}
	
	private static void exitPointofMatrix(int[][] arr) {
		
		int dir = 1;
		int r = 0, c = 0;
		
//		if(arr.length == 0 && arr[0].length == 0) {
//			System.out.println("0, 0");
//		}
		
		while(true) {
			
//			if(r == arr.length || c == arr[0].length || r < 0 || c < 0) {
//				System.out.println(r + ", " + c);
//				break;
//			}
//			
//			if(dir == 0) {
//				c++;
//				
//				if(c == arr[0].length) {
//					System.out.println(r + ", " + (c - 1));
//					break;
//				}
//				
//				if(arr[r][c] == 1) {
//					dir = 3;
//				}
//			}
//			
//			else if(dir == 1) {
//				c--;
//				
//				if(c < 0) {
//					System.out.println(r + ", " + (c + 1));
//					break;
//				}
//				
//				if(arr[r][c] == 1) {
//					dir = 2;
//				}
//			}
//			
//			else if(dir == 2) {
//				r--;
//				
//				if(r < 0) {
//					System.out.println((r + 1) + ", " + c);
//					break;
//				}
//				
//				if(arr[r][c] == 1) {
//					dir = 0;
//				}
//			}
//			
//			else {
//				r++;
//				
//				if(r == arr.length) {
//					System.out.println((r - 1) + ", " + c);
//					break;
//				}
//				
//				if(arr[r][c] == 1) {
//					dir = 1;
//				}
//			}
			
			if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length) {
				
				if(dir == 0) {
					r++;
				}
				
				else if(dir == 1) {
					c--;
				}
				
				else if(dir == 2) {
					r--;
				}
				
				else {
					c++;
				}
				
				System.out.println(r + ", " + c);
				break;
			}
			
			if(arr[r][c] == 1) {
				dir = (dir + 1) % 4;
			}
			
			if(dir == 0) {
				r--;
			}
			
			else if(dir == 1) {
				c++;;
			}
			
			else if(dir == 2) {
				r++;
			}
			
			else {
				c --;
			}
		}
	}
}