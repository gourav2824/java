
public class LargestNumber {

	public static void main(String[] args) {
		int a = 80;
		int b = 40;
		int c = 50;
		
//		if(a>=b && a>=c)
//		{
//			System.out.println(a + " is largest");
//			return;
//		}
//		
//		if(b>=a && b>=c)
//		{
//			System.out.println(b + " is largest");
//			return;
//		}
//		
//		System.out.println(c + " is largest");
		
		if(a>=b)
		{
			if(a>=c)
			{
				System.out.println(a + " is largest");
			}
			else
			{
				System.out.println(c + " is largest");
			}
			
		}
		
		else
		{
			if(b>=c)
			{
				System.out.println(b + " is largest");
			}
			else
			{
				System.out.println(c + " is largest");
			}
		}
		
		
	}

}
