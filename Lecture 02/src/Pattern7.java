import java.util.Scanner;

public class Pattern7 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = sc.nextInt();
		int row=1, col;
		
		while(row<=n)
		{
			col=1;
			while(col<=n)
			{
				if((col == row) || (col == (n-row+1)))
					System.out.print("* ");
				else
					System.out.print("  ");
				col++;
			}
			System.out.println();
			row++;
		}
	}
}