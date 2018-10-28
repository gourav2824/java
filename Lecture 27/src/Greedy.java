
public class Greedy {

	public static void main(String[] args) {
		
//		egyptianFraction(3, 7);
		
		int[] arr = {5, 6, 10, 100, 10, 5};
		MaxSumNoAdjacent(arr);
	}
	
	private static void egyptianFraction(int num, int denom) {
		
		if(num == 0) {
			return;
		}
		
		if(num == 1) {
			System.out.println(num + " / " + denom);
			return;
		}
		
		int newdenom = (int)Math.ceil(denom * 1.0 / num);
		int newnum = 1;
		System.out.println(1 + " / " + newdenom);
		egyptianFraction(num * newdenom - denom, newdenom * denom);
	}
	
	private static void MaxSumNoAdjacent(int[] arr) {
		
		int inc = arr[0];
		int exc = 0;
		
		for(int i = 1; i < arr.length; i++) {
			
			int oinc = inc;
			inc = exc + arr[i];
			
			exc = Math.max(oinc, exc);
		}
		
		System.out.println(inc);
	}
}