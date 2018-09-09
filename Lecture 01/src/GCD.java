import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number : ");
		int a = sc.nextInt();
		System.out.println("Enter the second number : ");
		int b = sc.nextInt();
		int divisor=b, divident=a, rem;
		
			rem = divident % divisor;
			
			while(rem!=0)
			{
				divident = divisor;
				divisor = rem;
				
				rem = divident % divisor;
			}
			
			System.out.println("GCD = " + divisor);
		
	}

}
