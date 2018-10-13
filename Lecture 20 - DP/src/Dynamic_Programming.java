
public class Dynamic_Programming {

	public static void main(String[] args) {
		
//		getBoardPath(0, 10, "");
//		System.out.println(countBoardPath(0, 10));
//		int n = 10;
//		System.out.println(countBoardPathM(0, n, new int[n + 1]));
//		System.out.println(countBoardPathT(0, n));
//		System.out.println(countBoardPathTSmart(0, n));
//		System.out.println(countMazePathT(3, 3));
		
		int[][] arr = {
				{1, 2, 5, 3, 5},
				{4, 2, 2, 6, 0},
				{0, 8, 1, 1, 4},
				{4, 0, 2, 5, 100},
				{0, 2, 6, 7, 1}
		};
		
//		System.out.println(MinCostPathT(arr));
		
		int[][] gold = {
				{2,1,3,10,2},
				{6,0,8,1,8},
				{3,9,5,6,7},
				{4,2,4,7,4},
				{1,5,0,2,3}
		};
		
		System.out.println(GoldMine(gold));
		
	}
	
	public static void getBoardPath(int src, int dest, String ans) {
		
		if(src == dest) {
			System.out.print(ans + " ");
			return;
		}
		
		if(src > dest) {
			return;
		}
		
		for(int i=1; i<=6; i++) {
			getBoardPath(src+i, dest, ans+i);
		}
	}
	
	public static int countBoardPath(int src, int dest) {
		
		int count = 0;
		
		if(src == dest) {
			return 1;
		}
		
		if(src > dest) {
			return 0;
		}
		
		for(int i=1; i<=6; i++) {
			count += countBoardPath(src+i, dest);
		}
		
		return count;
	}
	
	public static int countBoardPathM(int src, int dest, int[] qb) {		// Memoization
		
		if(src == dest) {
			return 1;
		}
		
		if(qb[src] != 0) {
			return qb[src];
		}
		
		int cstod = 0;
		for(int dice = 1; dice <= 6 && src + dice <= dest; dice++) {
			int i = src + dice;
			int citod = countBoardPathM(i, dest, qb);
			cstod += citod;
		}
		
		qb[src] = cstod;
		return cstod;
	}
	
	private static int countBoardPathT(int s, int d) {
		
		int[] qb = new int[d+1];
		qb[d] = 1;
		
		for(int i = d - 1; i >= s; i--) {
			for(int dice = 1; dice <= 6 && (i + dice) <= d; dice++) {
				
				qb[i] += qb[i + dice];
			}
		}
		
		return qb[s];
	}
	
	private static int countBoardPathTSmart(int s, int d) {
		
		int[] sl = new int[6];
		sl[0] = 1;
		
		for(int slides = 1; slides <= d; slides++) {
			
			int nv = sl[0] + sl[1] + sl[2] + sl[3] + sl[4] + sl[5];
			
			for(int i = 5; i > 0; i--) {
				sl[i] = sl[i - 1];
			}
			
			sl[0] = nv;
		}
		
		return sl[0];
	}
	
	private static int countMazePathT(int r, int c) {
		
		int[][] maze = new int[r+1][c+1];
		
		for(int i = r; i >= 0; i--) {
			for(int j = c; j >= 0; j--) {
				
				if(i == r && j == c) {
					maze[i][j] = 1;
				}
				
				else if(i == r) {
					maze[i][j] = maze[i][j+1];
				}
				
				else if(j == c) {
					maze[i][j] = maze[i+1][j];
				}
				
				else {
					maze[i][j] = maze[i][j+1] + maze[i+1][j];
				}
			}
		}
		
		return maze[0][0];
	}
	
	private static int MinCostPathT(int[][] arr) {
		
		int r = arr.length -1;
		int c = arr[0].length - 1;
		int[][] maze = new int[r+1][c+1];
		
		for(int i = r; i >= 0; i--) {
			for(int j = c; j >= 0; j--) {
				
				if(i == r && j == c) {
					maze[i][j] = arr[i][j];
				}
				
				else if(i == r) {
					maze[i][j] = arr[i][j] + maze[i][j+1];
				}
				
				else if(j == c) {
					maze[i][j] = arr[i][j] + maze[i+1][j];
				}
				
				else {
					maze[i][j] = arr[i][j] + Math.min(maze[i][j+1], maze[i+1][j]);
				}
			}
		}
		
		return maze[0][0];
	}
	
	private static int GoldMine(int[][] gold) {
		
		int[][] goldSum = new int[gold.length][gold[0].length];  // Storage
		
		for(int j = gold[0].length - 1; j >= 0; j--) {
			for(int i = gold.length - 1; i >= 0; i--) {
				
				if(j == gold[0].length - 1) {
					goldSum[i][j] = gold[i][j];
				}
				
				else {
					if(i == 0) {
						goldSum[i][j] = gold[i][j] + Math.max(goldSum[i][j+1], 
															  goldSum[i+1][j+1]);
					}
					
					else if(i == gold.length - 1) {
						goldSum[i][j] = gold[i][j] + Math.max(goldSum[i][j+1], 
															  goldSum[i-1][j+1]);
					}
					
					else {
						goldSum[i][j] = gold[i][j] + Math.max(goldSum[i][j+1], 
												 			  Math.max(goldSum[i-1][j+1], 
												 					   goldSum[i+1][j+1]));
					}
				}
			}
		}
		
		int max = goldSum[0][0];
		for(int i=1; i < goldSum[0].length; i++) {
			max = Math.max(max, goldSum[i][0]);
		}
		
		return max;
	}
}