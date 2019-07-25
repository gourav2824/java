import java.util.Scanner;

public class HungarianAlgo {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			
			int[][] arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			boolean yes = true;
			
			for(int i = 0; i < n; i++) {
				
				boolean found = false;
				for(int j = 0; j < n; j++) {
					if(arr[i][j] == 0) {
						found = true;
						break;
					}
				}
				
				if(found == false) {
					yes = false;
					break;
				}
			}
			
			if(yes == false) {
				System.out.println("NO");
			}
			
			else {
				for(int j = 0; j < n; j++) {
					
					boolean found = false;
					for(int i = 0; i < n; i++) {
						if(arr[i][j] == 0) {
							found = true;
							break;
						}
					}
					
					if(found == false) {
						yes = false;
						break;
					}
				}
				
				if(yes == false) {
					System.out.println("NO");
				}
				
				else {
					System.out.println("YES");
				}
			}
			
			tno ++;
		}
	}
}