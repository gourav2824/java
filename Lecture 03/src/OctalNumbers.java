import java.util.Scanner;

public class OctalNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter the Number : ");
//		int n = sc.nextInt();
		System.out.print("Enter the First Number : ");
		int n1 = sc.nextInt();
		System.out.print("Enter the Second Number : ");
		int n2 = sc.nextInt();
		
		//Addition(n1, n2);
		//Subtraction(n1, n2);
		//OctalToBinary(n);
		//BinaryToOctal(n);
		Rotation(n1, n2);
	}
	
	private static void Addition(int n1, int n2)
	{
		int a, b, da, db, sum=0, add, digit, power=1, carry=0;
		
		a = n1;
		b = n2;
		while((a!=0) || (b!=0) || (carry!=0))
		{
			da = a % 10;
			db = b % 10;
			a = a / 10;
			b = b / 10;
			
			add = da + db + carry;
			
			digit = add % 8;
			carry = add / 8;
			
			sum += digit * power;
			power = power * 10;
		}
		
		System.out.print("Sum = " + sum);
	}
	
	private static void Subtraction(int n1, int n2)
	{
		int a, b, da, db, sum=0, power=1, borrow=0, digit;
		
		a = n1;
		b = n2;
		while((a!=0) || (b!=0))
		{
			da = a % 10;
			db = b % 10;
			a = a / 10;
			b = b / 10;
			da = da + borrow;
			
			if(da < db)
			{
				borrow = -1;
				da += 8;
			}
			else
			{
				borrow = 0;
			}
			
			digit = da - db;
			sum += digit * power;
			power = power * 10;
		}
		
		System.out.print("Difference = " + sum);
	}
	
	private static void OctalToBinary(int n)
	{
		int power=1, sum=0;
		int a = n;
		while(a!=0)
		{
			int digit = a % 10;
			a = a / 10;
			
			int term = OtoB(digit);
			sum += term * power;
			power = power * 1000;
		}
		System.out.print("Binary Number = " + sum);
	}
	
	private static int OtoB(int n)
	{
		switch(n)
		{
		case 0: return 0;
		case 1: return 1;
		case 2: return 10;
		case 3: return 11;
		case 4: return 100;
		case 5: return 101;
		case 6: return 110;
		case 7: return 111;
		default: return 0;
		}
	}
	
	private static void BinaryToOctal(int n)
	{
		int power=1, sum=0;
		int a = n;
		while(a!=0)
		{
			int digit = a % 1000;
			a = a / 1000;
			
			int term = B2O(digit);
			sum += term * power;
			power = power * 10;
		}
		System.out.print("Octal Number = " + sum);
	}
	
	private static int B2O(int n)
	{
		switch(n)
		{
		case 0: return 0;
		case 1: return 1;
		case 10: return 2;
		case 11: return 3;
		case 100: return 4;
		case 101: return 5;
		case 110: return 6;
		case 111: return 7;
		default: return -1;
		}
	}
	
	private static void Rotation(int n, int r)
	{
		if(r < 0)
		{
			if(Math.abs(r) >= GetLength(n))
				r = r % GetLength(n);
			
			r = r + GetLength(n);
		}
		
		else
		{
			if(r >= GetLength(n))
				r = r % GetLength(n);
		}
		
		int p1 = n / (int)Math.pow(10,r);
		int p2 = n % (int)Math.pow(10,r);
		
		int len = GetLength(p1);
		p2 = p2 * (int)Math.pow(10,len);
		int sum = p1 + p2;
		
		System.out.print("Rotated Number = " + sum);
	}
	
	private static int GetLength(int n)
	{
		int len=0;
		while(n!=0)
		{
			n = n / 10;
			len++;
		}
		return len;
	}
}