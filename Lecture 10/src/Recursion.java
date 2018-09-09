import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter x and n : ");
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		// PDIwithSkips(n);
		// PrintZigZag(n);
		//TowerOfHanoi("A", "B", "C", 3);
//		int fact = factorial(n);
//		System.out.print(fact);
		
//		int power = Power(x, n);
//		System.out.print(power);
		
		int pows = PowerSmart(x, n);
		System.out.print(pows);
	}

	public static void PDIwithSkips(int n) {

		if (n == 0)
			return;

		if (n % 2 != 0) {
			System.out.println(n);
			PDIwithSkips(n - 1);
		}

		else {
			PDIwithSkips(n - 1);
			System.out.println(n);
		}
	}

	public static void PrintZigZag(int n) {

		if (n == 0)
			return;

		System.out.println(n);
		PrintZigZag(n - 1);
		System.out.println(n);
		PrintZigZag(n - 1);
		System.out.println(n);
	}

	public static void TowerOfHanoi(String src, String dest, String helper, int n) {

		if (n == 0) {
			return;
		}

		TowerOfHanoi(src, helper, dest, n - 1);
		System.out.println("Move " + n + " from " + src + " to " + dest);
		TowerOfHanoi(helper, dest, src, n - 1);
	}
	
	public static int factorial(int n) {
		
		if(n==0)
			return 1;
		
		int fact = factorial(n-1);
		fact = n * fact;
		return fact;
	}
	
	public static int Power(int x, int n) {
		
		if(n == 0)
			return 1;
		
		int power = Power(x, n-1);
		power = x * power;
		return power;
	}
	
	public static int PowerSmart(int x, int n) {
		
		if(n == 0)
			return 1;
		
		int power = PowerSmart(x, n/2);
		power = power * power;
		
		if(n % 2 != 0)
			power = power * x;
		
		return power;
	}
}