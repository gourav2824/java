import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Number : ");
		int n = sc.nextInt();
		int num = 1, cntr = 1, col;
		
		while(cntr <= n)
		{
			col = 1;
			while(col <= cntr)
			{
				System.out.print(num + " ");
				num++;
				col++;
			}
			
			System.out.println();
			cntr++;
		}
	}
}
