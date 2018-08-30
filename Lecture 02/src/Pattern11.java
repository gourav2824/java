import java.util.Scanner;

public class Pattern11 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = sc.nextInt();
		int spaces=n, stars=-1, row, col, num=0;
		
		row=1;
		while(row <= n)
		{
			spaces -= 1;
			stars += 2;
			
			col=1;
			while(col <= spaces)
			{
				System.out.print("  ");
				col++;
			}
			
			col=1;
			while(col <= stars)
			{
				if(col <= (stars+1)/2)
					num ++;
				else
					num --;
				
				System.out.print(num + " ");
				//System.out.print("* ");
				col++;
			}
			
			col=1;
			while(col <= spaces)
			{
				System.out.print("  ");
				col++;
			}
			
			System.out.println();
			row++;
		}
	}
}