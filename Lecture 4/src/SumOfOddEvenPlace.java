import java.util.Scanner;

public class SumOfOddEvenPlace {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		long quo = n;
		long i=1, rem, even=0, odd=0;
		
		while(quo != 0)
		{
			rem = quo % 10;
			quo = quo / 10;
			
			if(i%2==0)
			{
				even += rem;
			}
			else
			{
				odd += rem;
			}
			
			i++;
		}
		System.out.print(odd + " " + even);
	}
}