import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = sc.nextInt();
		int a=0, b=1, c, cntr=1, col;
		
		while(cntr <= n)
		{
			col = 1;
			while(col <= cntr)
			{
				System.out.print(a + " ");
				c = a + b;
				a = b;
				b = c;
				col++;
			}
			System.out.println();
			cntr++;
		}	
	}
}