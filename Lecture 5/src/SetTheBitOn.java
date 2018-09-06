import java.util.Scanner;

public class SetTheBitOn {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int bitmask = 1 << k;
		System.out.print(n | bitmask);
	}
}