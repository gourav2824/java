
public class Greedy {

	public static void main(String[] args) {
		
		egyptianFraction(3, 7);
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
}