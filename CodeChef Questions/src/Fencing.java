import java.util.Scanner;

public class Fencing {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			boolean[][] grid = new boolean[n][m];
			
			for(int i = 0; i < k; i++) {
				
				int r = sc.nextInt();
				int c = sc.nextInt();
				
				grid[r - 1][c - 1] = true;
			}
			
			int fences = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					
					if(grid[i][j] == true) {
						
						if(i == 0 && j == 0) {
							
							fences += 2;
							
							if(grid[i][j + 1] == false) {
								fences += 1;
							}
							
							if(grid[i + 1][j] == false) {
								fences += 1;
							}
						}
						
						else if(i == 0 && j == m-1) {
							
							fences += 2;
							
							if(grid[i][j - 1] == false) {
								fences += 1;
							}
							
							if(grid[i + 1][j] == false) {
								fences += 1;
							}
						}
						
						else if(i == n-1 && j == 0) {
							
							fences += 2;
							
							if(grid[i][j + 1] == false) {
								fences += 1;
							}
							
							if(grid[i - 1][j] == false) {
								fences += 1;
							}
						}
						
						else if(i == n-1 && j == m-1) {
							
							fences += 2;
							
							if(grid[i][j - 1] == false) {
								fences += 1;
							}
							
							if(grid[i - 1][j] == false) {
								fences += 1;
							}
						}
						
						else if(i == 0) {
							
							fences += 1;
							
							if(grid[i][j - 1] == false) {
								fences += 1;
							}
							
							if(grid[i][j + 1] == false) {
								fences += 1;
							}
							
							if(grid[i + 1][j] == false) {
								fences += 1;
							}
						}
						
						else if(j == 0) {
							
							fences += 1;
							
							if(grid[i - 1][j] == false) {
								fences += 1;
							}
							
							if(grid[i + 1][j] == false) {
								fences += 1;
							}
							
							if(grid[i][j + 1] == false) {
								fences += 1;
							}
						}
						
						else if(i == n - 1) {
							
							fences += 1;
							
							if(grid[i][j - 1] == false) {
								fences += 1;
							}
							
							if(grid[i][j + 1] == false) {
								fences += 1;
							}
							
							if(grid[i - 1][j] == false) {
								fences += 1;
							}
						}
						
						else if(j == m - 1) {
							
							fences += 1;
							
							if(grid[i - 1][j] == false) {
								fences += 1;
							}
							
							if(grid[i + 1][j] == false) {
								fences += 1;
							}
							
							if(grid[i][j - 1] == false) {
								fences += 1;
							}
						}
						
						else {
							
							if(grid[i + 1][j] == false) {
								fences += 1;
							}
							
							if(grid[i - 1][j] == false) {
								fences += 1;
							}
							
							if(grid[i][j + 1] == false) {
								fences += 1;
							}
							
							if(grid[i][j - 1] == false) {
								fences += 1;
							}
						}
					}
				}
			}
			
			System.out.println(fences);
			tno ++;
		}
	}
}