import java.util.Scanner;

public class DeputyChef {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int tno = 1;
		while(tno <= t) {
			
			int n = sc.nextInt();
			
			int[] a = new int[n];
			int[] d = new int[n];
			
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			for(int i = 0; i < n; i++) {
				d[i] = sc.nextInt();
			}
			
			int value = -1;
			
			for(int i = 0; i < n; i++) {
				
				if(i == 0) {
					if(d[i] > a[n - 1] + a[i + 1]) {
						value = Math.max(value, d[i]);
					}
				}
				
				else if(i == n-1) {
					if(d[i] > a[i - 1] + a[0]) {
						value = Math.max(value, d[i]);
					}
				}
				
				else {
					if(d[i] > a[i - 1] + a[i + 1]) {
						value = Math.max(value, d[i]);
					}
				}
			}
			
			System.out.println(value);
			
			tno ++;
		}
	}
}