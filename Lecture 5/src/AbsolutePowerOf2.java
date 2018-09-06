import java.util.Scanner;

public class AbsolutePowerOf2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rem, quo = n;
		boolean res = true;
		
		while(quo > 1) {
			
			rem = quo % 2;
			quo = quo / 2;
			
			if(rem != 0) {
				res = false;
				break;
			}
		}
		
		System.out.print(res);
	}
}