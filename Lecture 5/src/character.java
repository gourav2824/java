import java.util.Scanner;

public class character {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter the Character : ");
//		char ch = sc.nextLine().charAt(0);
//		char nch = ' ';
//		
//		if(ch >= 'a' && ch <= 'z')
//		{
//			System.out.println("Lower");
//			nch = (char)(ch - 'a' + 'A');
//			System.out.print("New Character = " + nch);
//		}
//			
//		else if(ch >= 'A' && ch <= 'Z')
//		{
//			System.out.println("Upper");
//			nch = (char)(ch - 'A' + 'a');
//			System.out.print("New Character = "+ nch);
//		}
//		
//		else
//			System.out.print("Invalid");
		
		//ValidOrInvalid(sc);
		FarToCelsius(sc);
	}
	
	private static void ValidOrInvalid(Scanner sc) {
		
		System.out.print("Enter the Count of Numbers : ");
		int n = sc.nextInt();
		
		System.out.println("Enter the Numbers :-");
		int prev = sc.nextInt();
		int curr = sc.nextInt();
		
		boolean goingDown = curr < prev;
		
		for(int i=3;i<=n;i++)
		{
			prev = curr;
			curr = sc.nextInt();
			
			if(goingDown == true)
			{
				if(curr > prev)
					goingDown = false;
			}
			
			else
			{
				if(curr < prev)
				{
					System.out.print("Invalid");
					return;
				}
			}
		}
		
		System.out.print("Valid");
	}
	
	private static void RectangleOverlapOrNot(Scanner sc) {
		
		System.out.print("Enter the value of x1 and y1 : ");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		
		System.out.print("Enter the value of x2 and y2 : ");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		System.out.print("Enter the value of x3 and y3 : ");
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		
		System.out.print("Enter the value of x4 and y4 : ");
		int x4 = sc.nextInt();
		int y4 = sc.nextInt();
		
		if(((x3-x1)<(x2-x1)) && ((x4-x2)<(x4-x3)) && ((y3-y1)<(y1-y2)) && ((y4-y2)<((y1-y2))))
				System.out.print("Overlapping");
		else
			System.out.print("Not Overlapping");
	}
	
	private static void FarToCelsius(Scanner sc) {
		
		System.out.print("Enter the values of min, max and step : ");
		int minf = sc.nextInt();
		int maxf = sc.nextInt();
		int step = sc.nextInt();
		
		int cel;
		int f = minf;
		while(f <= maxf)
		{
			cel = (int)((5.0/9) * (f-32));
			System.out.println(f + " " + cel);
			f += step;
		}
	}
}