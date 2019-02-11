import java.util.Scanner;

public class LabProgram {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the RGB values :");
		int r = sc.nextInt();
		int g = sc.nextInt();
		int b = sc.nextInt();
		
		int min = r;
		
		if(min > g) {
			min = g;
		}
		
		if(min > b) {
			min = b;
		}
		
		r = r - min;
		g = g - min;
		b = b - min;
		
		System.out.println(r + " " + g + " " + b);
		sc.close();
	}
}