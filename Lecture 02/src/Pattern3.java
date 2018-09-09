import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = sc.nextInt();
		int row=0, col, num, k;
		
		/*int cntr = 0;
		while(cntr<n)
		{
			col = 0;
			num = 1;
			while(col<=cntr)
			{
				System.out.print(num + " ");
				val = val * (cntr-col) / (col+1);
				col++;
			}
			System.out.println();
			cntr++;
		}*/
		
		
		while(row < n)
		{
			col = 0;
			num = 1;
			while(col <= row)
			{
				if((col == 0))
				{
					System.out.print(num + " ");
					col++;
				}
				
				else
				{
					k = col-1;
					num = (num*(row-k))/(k+1);
					System.out.print(num + " ");
					col++;
				}
			}
			
			System.out.println();
			row++;
		}
	}
}