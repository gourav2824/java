import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Decimal Number : ");
		int n = sc.nextInt();
		int quo, rem, power=1, num=0;
		
		quo = n;
		while(quo != 0)
		{
			rem = quo % 2;
			quo = quo / 2;
			num += rem * power;
			power = power * 10;
		}
		
		System.out.print("Binary Number = " + num);	
	}
}