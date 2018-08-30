import java.util.Scanner;

public class CheckPrime {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = sc.nextInt();
		int i;
		int a = 2;
		int flag;
		
		System.out.print("The Prime numbers upto " + n + " are :-");
		while(a<=n)
		{
			flag = 0;
			i = 2;
			while(i*i <= a)
			{
				if(a%i==0)
				{
					flag = 1;
					break;
				}
				i++;
			}
			
			if(flag==0)
				System.out.print(" " + a);
			a++;
		}
		
		sc.close();
	}
}
