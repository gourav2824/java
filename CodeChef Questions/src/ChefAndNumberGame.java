import java.util.Scanner;

public class ChefAndNumberGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int n = sc.nextInt();
			int[] a = new int[n];
			
			int neg = 0;
			int pos = 0;
			
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				
				if(a[i] >= 0) {
					pos ++;
				}
				else {
					neg ++;
				}
			}
			
			int minsize, maxsize;
			
			if(pos > 0 && neg > 0) {
				minsize = Math.min(pos, neg);
				maxsize = Math.max(pos, neg);
			}
			
			else if(pos > 0) {
				minsize = pos;
				maxsize = pos;
			}
			
			else {
				minsize = neg;
				maxsize = neg;
			}
			
			System.out.println(maxsize + " " + minsize);
			tno ++;
		}
	}
}