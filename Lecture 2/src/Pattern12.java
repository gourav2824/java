import java.util.Scanner;

public class Pattern12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = sc.nextInt();
		int rows = n;
		int columns = 2*n-1;
		int row, col, num;
		
		row = 1;
		while(row <= n)
		{
			col = 1;
			num = 0;
			while(col <= columns)
			{
				if((col <= row) || (col > columns - row))
				{
					if(col <= rows)
						num++;
					
					else if(col == (columns - row + 1))
						num = num;
					
					else
						num--;
					
					System.out.print(num + " ");
				}
				
				else
					System.out.print("  ");
				col++;
			}
			
			System.out.println();
			row++;
		}
	}
}