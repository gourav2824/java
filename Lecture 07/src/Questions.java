//import java.text.DecimalFormat;
import java.util.Scanner;

public class Questions {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//DecimalFormat f = new DecimalFormat("#.0000000");
		
		TemperatueConversion(sc);
	}
	
	private static void TemperatueConversion(Scanner sc) {
		
		int n = sc.nextInt();
		float c;
		
		c = ((n - 32) * 5) / 9.0F;
		
		//System.out.print(f.format(c));
		System.out.print(c);
	}
}