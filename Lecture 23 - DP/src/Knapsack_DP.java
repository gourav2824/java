
public class Knapsack_DP {

	public static void main(String[] args) {
		
		int[] weights = {2, 5, 1, 3, 4};
		int[] prizes = {15, 14, 10, 16, 30};
		int capacity = 7;
		int[][] strg = new int[weights.length + 1][capacity + 1];
		
		knapsack(weights, prizes, capacity, strg);
	}
	
	private static void knapsack(int[] weights, int[] prizes, int capacity, int[][] strg) {
		
		for(int i = 1; i < strg.length; i++) {
			for(int j = 1; j < strg[0].length; j++) {
				
				if(j >= weights[i - 1]) {
					
					strg[i][j] = Math.max(strg[i - 1][j], prizes[i - 1] + strg[i - 1][j - weights[i - 1]]);
				}
				
				else {
					strg[i][j] = strg[i - 1][j];
				}
			}
		}
		
		System.out.println("Maximum Value = " + strg[strg.length - 1][strg[0].length - 1]);
	}

}
