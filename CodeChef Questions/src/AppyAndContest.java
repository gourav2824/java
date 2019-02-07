import java.util.Scanner;

public class AppyAndContest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		int testCase = 1;
		while(testCase <= testCases) {
			
			long n = sc.nextLong();
			int a = sc.nextInt();
			int b = sc.nextInt();
			long k = sc.nextLong();
			
			long na = n / a;
			long nb = n / b;
			
			long lcm = a * b;
			
			if(a % b == 0) {
				lcm = a;
			}
			
			if(b % a == 0) {
				lcm = b;
			}
			
			long nlcm = n / lcm;
			
			long prob = (na + nb) - (2 * nlcm);
			
			if(prob >= k) {
				System.out.println("Win");
			}
			
			else {
				System.out.println("Lose");
			}
			
			testCase ++;
		}
	}
}