import java.util.Scanner;

public class Pattern8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = sc.nextInt();
		int spaces=((n+1)/2), stars=-1, row=1, col;
		
		while(row <= n)
		{
			if(row <= (n+1)/2)
			{
				spaces -= 1;
				stars += 2;
			}
			else
			{
				spaces += 1;
				stars -= 2;
			}
			
			col=1;
			while(col <= spaces)
			{
				System.out.print(" ");
				col++;
			}
			
			col=1;
			while(col <= stars)
			{
				System.out.print("*");
				col++;
			}
			
			col=1;
			while(col <= spaces)
			{
				System.out.print(" ");
				col++;
			}
			
			//System.out.println(spaces + " " + stars);
			System.out.println();
			row++;
		}
	}
}