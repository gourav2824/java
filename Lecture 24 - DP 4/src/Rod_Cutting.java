
public class Rod_Cutting {

	public static void main(String[] args) {
		
		int[] costs = {0, 3, 5, 6, 15, 10, 25, 12, 24};
		
		RodCutting(costs);
	}
	
	private static void RodCutting(int[] costs) {
		
		int[] strg = new int[costs.length];
		
		strg[0] = 0;
		strg[1] = costs[1];
		
		for(int i = 2; i < strg.length; i++) {
			
			strg[i] = costs[i];
			int left = 1;
			int right = i - left;
			
			while(left <= right) {
				
				strg[i] = Math.max(strg[i], strg[left] + strg[right]);
				left++;
				right--;
			}
		}
		
		System.out.println(strg[strg.length - 1]);
	}
}