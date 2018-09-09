import java.util.Scanner;

public class Number_Conversion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Source Number : ");
		int sn = sc.nextInt();
		System.out.print("Enter the Base of the Source Number System : ");
		int sb = sc.nextInt();
		System.out.print("Enter the Base of the Destination Number System : ");
		int db = sc.nextInt();
		
		int quo, rem, power;
		
		quo = sn;
		power = 1;
		int decimal = 0;
		
		while(quo != 0)
		{
			rem = quo % 10;
			quo = quo / 10;
			decimal += rem * power;
			power = power * sb;
		}
		
		quo = decimal;
		power=1;
		int num = 0;
		
		while(quo != 0)
		{
			rem = quo % db;
			quo = quo / db;
			num += rem * power;
			power = power * 10;
		}
		
		System.out.print("Destination Number = " + num);
	}
}