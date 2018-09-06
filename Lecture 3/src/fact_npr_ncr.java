import java.util.Scanner;

public class fact_npr_ncr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of n : ");
		int n = sc.nextInt();
		System.out.print("Enter the value of r : ");
		int r = sc.nextInt();
		
		int fact_n = factorial(n);
		int fact_r = factorial(r);
		int fact_n_r = factorial(n-r);
		
		int npr = fact_n / fact_n_r;
		int ncr = fact_n / (fact_n_r * fact_r);
		
		System.out.println(fact_n);
		System.out.println(npr);
		System.out.print(ncr);
	}
	
	private static int factorial(int n) {
		int fact = 1;
		if(n==0)
			fact = 1;
		else
		{
			for(int i=2;i<=n;i++)
			{
				fact = fact * i;
			}
		}
		return fact;
	}
}