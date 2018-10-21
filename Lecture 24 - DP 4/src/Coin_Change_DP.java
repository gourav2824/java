
public class Coin_Change_DP {

	public static void main(String[] args) {
		
		int[] coins = {2, 3, 5, 6};
		int target = 10;
		
		CoinChangePermutations(coins, target);
		CoinChangeCombinations(coins, target);
	}
	
	private static void CoinChangePermutations(int[] coins, int target) {
		
		int[] strg = new int[target + 1];
		
		strg[0] = 1;
		
		for(int i = 1; i < strg.length; i++) {
			for(int coin : coins) {
				if(i >= coin) {
					strg[i] += strg[i - coin];
				}
			}
		}
		
		System.out.println(strg[target]);
	}
	
	private static void CoinChangeCombinations(int[] coins, int target) {
		
		int[] strg = new int[target + 1];
		
		strg[0] = 1;
		
		for(int coin : coins) {
			for(int i = 1; i < strg.length; i++) {
				if(i >= coin) {
					strg[i] += strg[i - coin];
				}
			}
		}
		
		System.out.println(strg[target]);
	}
}