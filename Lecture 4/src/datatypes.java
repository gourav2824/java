import java.util.Scanner;

public class datatypes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = sc.nextInt();
		System.out.print("Enter the Bit : ");
		int k = sc.nextInt();
		
		System.out.println(n + " = " + Integer.toBinaryString(n));
		
		ToggleTheBit(n, k);
	}
	
	private static void checkbit(int n, int k) {
		// TODO Auto-generated method stub
		int bitmask = 1 << k;
		if((n & bitmask)==0)
			System.out.print("OFF");
		else
			System.out.print("ON");
	}
	
	private static void onthebit(int n, int k) {
		// TODO Auto-generated method stub
		int bitmask = 1 << k;
		
		System.out.print(Integer.toBinaryString(n | bitmask));
	}
	
	private static void offthebit(int n, int k) {
		
		int bitmask = ~(1 << k);
		
		System.out.print(Integer.toBinaryString(n & bitmask));
	}
	
	private static void ToggleTheBit(int n, int k) {
		
		int bitmask = 1 << k;
		
		System.out.print(Integer.toBinaryString(n ^ bitmask));
	}

}
