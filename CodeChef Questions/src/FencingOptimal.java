import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FencingOptimal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			int[][] grid = new int[k][2];
			HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
			
			for(int i = 0; i < k; i++) {
				
				int r = sc.nextInt();
				int c = sc.nextInt();
				
//				grid[i][0] = r - 1;
//				grid[i][1] = c - 1;
				
				grid[i][0] = r;
				grid[i][1] = c;
				
				if(map.containsKey(r) == false) {
					map.put(r, new HashSet<>());
					map.get(r).add(c);
				}
				
				else {
					map.get(r).add(c);
				}
			}
			
			int fences = 0;
			
			for(int i = 0; i < k; i++) {
				
				int r = grid[i][0];
				int c = grid[i][1];
				
				boolean top = false;
				boolean down = false;
				boolean left = false;
				boolean right = false;
				
//				for(int j = 0; j < k; j++) {
//					
//					if(grid[j][0] == r - 1 && grid[j][1] == c) {
//						top = true;
//					}
//					
//					if(grid[j][0] == r + 1 && grid[j][1] == c) {
//						down = true;
//					}
//					
//					if(grid[j][0] == r && grid[j][1] == c - 1) {
//						left = true;
//					}
//					
//					if(grid[j][0] == r && grid[j][1] == c + 1) {
//						right = true;
//					}
//				}
				
				if(map.get(r).contains(c - 1) == true) {
					left = true;
				}
				
				if(map.get(r).contains(c + 1) == true) {
					right = true;
				}
				
				if(map.containsKey(r - 1) == true) {
					if(map.get(r - 1).contains(c) == true) {
						top = true;
					}
				}
				
				if(map.containsKey(r + 1) == true) {
					if(map.get(r + 1).contains(c) == true) {
						down = true;
					}
				}
				
				// 0 -> 1
				// n - 1 -> n
				// m - 1 -> m
				
				if(r == 1 && c == 1) {
					
					fences += 2;
					
					if(right == false) {
						fences += 1;
					}
					
					if(down == false) {
						fences += 1;
					}
				}
				
				else if(r == 1 && c == m) {
					
					fences += 2;
					
					if(left == false) {
						fences += 1;
					}
					
					if(down == false) {
						fences += 1;
					}
				}
				
				else if(r == n && c == 1) {
					
					fences += 2;
					
					if(top == false) {
						fences += 1;
					}
					
					if(right == false) {
						fences += 1;
					}
				}
				
				else if(r == n && c == m) {
					
					fences += 2;
					
					if(left == false) {
						fences += 1;
					}
					
					if(top == false) {
						fences += 1;
					}
				}
				
				else if(r == 1) {
					
					fences += 1;
					
					if(left == false) {
						fences += 1;
					}
					
					if(right == false) {
						fences += 1;
					}
					
					if(down == false) {
						fences += 1;
					}
				}
				
				else if(c == 1) {
					
					fences += 1;
					
					if(top == false) {
						fences += 1;
					}
					
					if(right == false) {
						fences += 1;
					}
					
					if(down == false) {
						fences += 1;
					}
				}
				
				else if(r == n) {
					
					fences += 1;
					
					if(left == false) {
						fences += 1;
					}
					
					if(right == false) {
						fences += 1;
					}
					
					if(top == false) {
						fences += 1;
					}
				}
				
				else if(c == m) {
					
					fences += 1;
					
					if(left == false) {
						fences += 1;
					}
					
					if(top == false) {
						fences += 1;
					}
					
					if(down == false) {
						fences += 1;
					}
				}
				
				else {
					
					if(left == false) {
						fences += 1;
					}
					
					if(right == false) {
						fences += 1;
					}
					
					if(top == false) {
						fences += 1;
					}
					
					if(down == false) {
						fences += 1;
					}
				}
			}
			
			System.out.println(fences);
			tno ++;
		}
	}
}