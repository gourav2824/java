package test4;

import java.util.Scanner;

public class Ques1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int tno = 0;
		
		while(tno < t) {
			
			int r1 = sc.nextInt();
			int r2 = sc.nextInt();
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int z1 = sc.nextInt();
			
			int a1i = sc.nextInt();
			int a1j = sc.nextInt();
			int a1k = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int z2 = sc.nextInt();
			
			int a2i = sc.nextInt();
			int a2j = sc.nextInt();
			int a2k = sc.nextInt();
			
			if(x2 > x1) {
				if(a2i > 0 && a1i < 0) {
					System.out.println("No");
					tno++;
					continue;
				}
			}
			
			else {
				if(a1i > 0 && a2i < 0) {
					System.out.println("No");
					tno++;
					continue;
				}
			}
			
			if(y2 > y1) {
				if(a2j > 0 && a1j < 0) {
					System.out.println("No");
					tno++;
					continue;
				}
			}
			
			else {
				if(a1j > 0 && a2j < 0) {
					System.out.println("No");
					tno++;
					continue;
				}
			}
			
			if(z2 > z1) {
				if(a2k > 0 && a1k < 0) {
					System.out.println("No");
					continue;
				}
			}
			
			else {
				if(a1k > 0 && a2k < 0) {
					System.out.println("No");
					tno++;
					continue;
				}
			}
			
			System.out.println("Yes");
			tno++;
		}
	}
}