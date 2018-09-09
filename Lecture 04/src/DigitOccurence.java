import java.util.Scanner;

public class DigitOccurence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long d = sc.nextLong();
		
		long rem, count=0;
		
		long quo=n;
		while(quo != 0)
		{
			rem = quo % 10;
			quo = quo / 10;
			
			if(rem == d)
				count++;
		}
		System.out.print(count);
	}
}