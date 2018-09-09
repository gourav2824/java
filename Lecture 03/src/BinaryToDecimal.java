import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Binary Number : ");
		int n = sc.nextInt();
		int quo, rem, power=1, num=0;
		
		quo = n;
		while(quo != 0)
		{
			rem = quo % 10;
			quo = quo / 10;
			num += rem * power;
			power = power * 2;
		}
		
		System.out.print("Decimal Number = " + num);
	}
}