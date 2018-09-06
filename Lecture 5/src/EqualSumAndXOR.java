import java.util.Scanner;

public class EqualSumAndXOR {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count=0;
		
		for(int i=0; i<=n; i++)
		{
			if((n+i) == (n^i))
				count++;
		}
		System.out.print(count);
	}
}