
public class Unbounded_Knapsack {

	public static void main(String[] args) {
		
		int[] weights = {2, 5, 1, 3, 4};
		int[] prizes = {15, 14, 10, 45, 30};
		int capacity = 7;
		
		UnboundedKnapsack(weights, prizes, capacity);
	}
	
	private static void UnboundedKnapsack(int[] weights, int[] prizes, int capacity) {
		
		int[] strg = new int[capacity + 1];
		
		int omax = 0;
		
		for(int i = 1; i < strg.length; i++) {
			
			strg[i] = 0;
			for(int j = 0; j < weights.length; j++) {
				
				if(i >= weights[j]) {
					strg[i] = Math.max(strg[i], prizes[j] + strg[i - weights[j]]);
				}
			}
			
			omax = Math.max(omax, strg[i]);
		}
		
		System.out.println("Maximum Value = " + strg[capacity]);
	}
}