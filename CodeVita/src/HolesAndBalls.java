import java.util.*;

public class HolesAndBalls {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] holes = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			holes[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		int[] balls = new int[m];
		
		for(int i = 0; i < m; i++) {
			balls[i] = sc.nextInt();
		}
		
		int[] filled = new int[n + 1];
		
		for(int i = 0; i < m; i++) {
			
			boolean found = false;
			for(int j = n; j >= 0; j--) {
				
				if(filled[j] < j) {
					
					if(holes[j] >= balls[i]) {
						filled[j] += 1;
						System.out.print(j);
						found = true;
						break;
					}
				}
			}
			
			if(found == false) {
				System.out.print("0");
			}
			
			if(i < m - 1) {
				System.out.print(" ");
			}
		}
	}
}