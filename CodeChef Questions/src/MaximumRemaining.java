import java.util.Scanner;

public class MaximumRemaining {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++){
		    max1 = Math.max(max1, a[i]);
		}
		
		boolean found = false;
		for(int i = 0; i < n; i++){
		    if(a[i] < max1){
		        found = true;
		        max2 = Math.max(max2, a[i]);
		    }
		}
		
		if(found == false){
		    max2 = 0;
		}
		
		System.out.println(max2);
		
//		int max = 0;
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				
//				max = Math.max(max, (a[i] % a[j]));
//			}
//		}
//		
//		System.out.println(max2);
	}
}