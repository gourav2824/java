import java.util.Arrays;

public class Greedy {

	public static void main(String[] args) {
		
//		egyptianFraction(3, 7);
		
//		int[] arr = {5, 6, 10, 100, 10, 5};
//		MaxSumNoAdjacent(arr);
		
//		int[] arrivals = {900, 940, 950, 1100, 1500, 1800};
//		int[] departures = {910, 1200, 1120, 1130, 1900, 2000};
//		minPlatformsCount(arrivals, departures);
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
		
		System.out.println(Math.max(inc, exc));
	}
	
	private static void minPlatformsCount(int[] arrivals, int[] departures) {
		
		Arrays.sort(arrivals);
		Arrays.sort(departures);
		
		int i = 0, j = 0;
		
		int cars = 0;
		int min = Integer.MIN_VALUE;
		
		while(i < arrivals.length && j < departures.length) {
			
			if(arrivals[i] <= departures[j]) {
				cars++;
				i++;
			}
			
			else {
				cars--;
				j++;
			}
			
			if(cars > min) {
				min = cars;
			}
		}
		
		System.out.println("Minimum Platforms Required = " + min);
	}
}