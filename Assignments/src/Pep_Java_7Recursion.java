import java.util.Scanner;

public class Pep_Java_7Recursion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
//		PrintInvertedTriangle(n);
		System.out.println(NthTriangle(n));
	}
	
	private static void PrintInvertedTriangle(int n) {
		
		if(n == 0) {
			return;
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		PrintInvertedTriangle(n-1);
	}
	
	private static void BinomialPattern(int n) {
		
		if(n == 0) {
			System.out.println("1");
			return;
		}
		
		BinomialPattern(n-1);
		printBinomialTerm(n, n);
	}
	
	private static void printBinomialTerm(int n, int r) {
		
		int KplusOne = printBinomialTerm(n, r-1) * ();
	}
	
	private static int NthTriangle(int n) {
		
		if(n == 1) {
			return 1;
		}
		
		int sum = n + NthTriangle(n-1);
		return sum;
	}
	
}