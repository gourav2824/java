
public class PnCRecursion {

	public static void main(String[] args) {
		
		//boolean[] boxes = new boolean[4];
		//Permutations(boxes, 2, 0, "");
		//Combinations(boxes, 2, 0, 0, "");
		
		//int[] coins = {2, 3, 5, 6};
		//CoinChangePerm(coins, 10, 0, "");
		//CoinChangeComb(coins, 10, 0, 0, "");
		
		//PermUsingBM(0, 4, 2, 0, "");
		//CombOther(4, 0, 2, 0, "");
		
	}
	
	public static void Permutations(boolean[] boxes, int titem, int citem, String asf) {
		
		if(citem == titem) {
			System.out.println(asf);
			return;
		}
		
		for(int i=0; i<boxes.length; i++) {
			
			if(boxes[i] == false) {
				boxes[i] = true;
				Permutations(boxes, titem, citem + 1, asf + "b"+i+"i"+citem + " ");
				boxes[i] = false;
			}
		}
	}
	
	public static void Combinations(boolean[] boxes, int titem,int citem, int cpos, String asf) {
		
		if(citem == titem) {
			System.out.println(asf);
			return;
		}
		
		for(int i=cpos; i<boxes.length; i++) {
			
			if(boxes[i] == false) {
				boxes[i] = true;
				Combinations(boxes, titem, citem + 1, i+1, asf + "b"+i+"i"+citem + " ");
				boxes[i] = false;
			}
		}
	}
	
	public static void CoinChangePerm(int[] coins, int amount, int sum, String asf) {
		
//		if(sum > amount) {
//			return;
//		}
		
		if(sum == amount) {
			System.out.print(asf + " ");
			return;
		}
		
		for(int i=0; i<coins.length; i++) {
			if(sum <= amount) {
				CoinChangePerm(coins, amount, sum + coins[i], asf + coins[i]);
			}
		}
	}
	
	public static void CoinChangeComb(int[] coins, int amount, int sum, int pos, String asf) {
		
//		if(sum > amount) {
//			return;
//		}
		
		if(sum == amount) {
			System.out.print(asf + " ");
			return;
		}
		
		for(int i=pos; i<coins.length; i++) {
			if(sum <= amount) {
				CoinChangeComb(coins, amount, sum + coins[i], i, asf + coins[i]);
			}
		}
	}
	
	public static void PermUsingBM(int choicebm, int tboxes, int titems, int citem, String asf) {
		
		if(citem == titems) {
			System.out.println(asf);
			return;
		}
		
		for(int i=0; i<tboxes; i++) {
			
			if((choicebm & (1 << i)) == 0) {
				choicebm = choicebm | (1 << i);
				PermUsingBM(choicebm, tboxes, titems, citem + 1, asf + "b"+i+"i"+citem + " ");
				choicebm = choicebm & (~(1 << i));
			}
		}
	}
	
	public static void CombOther(int tboxes, int cbox, int titems, int citem, String asf) {
		
		if(citem == titems) {
			System.out.println(asf);
			return;
		}
		
		if(cbox == tboxes) {
			return;
		}
		
		CombOther(tboxes, cbox + 1, titems, citem + 1, asf + "b" + cbox + "i" + citem + " ");
		CombOther(tboxes, cbox + 1, titems, citem, asf);
	}
	
}