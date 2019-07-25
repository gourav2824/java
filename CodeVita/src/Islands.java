import java.util.*;

public class Islands {
	
	public static class island implements Comparable<island> {
		
		int i;
		int x1, y1;
		int x2, y2;
		int x3, y3;
		int x4, y4;
		int d;
		
		public island(int i, int x1, int y1, int x3, int y3) {
			
			this.i = i + 1;
			
			this.x1 = x1;
			this.y1 = y1;
			this.x3 = x3;
			this.y3 = y3;
			
			this.x2 = x1;
			this.y2 = y3;
			this.x4 = x3;
			this.y4 = y1;
		}

		@Override
		public int compareTo(island o) {
			
			if(this.d == o.d) {
				return this.i - o.i;
			}
			
			return this.d - o.d;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		island[] arr = new island[n];
		
		for(int i = 0; i < n; i++) {
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			
			arr[i] = new island(i, x1, y1, x3, y3);
		}
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			int d = Math.abs(arr[i].x1 - x) + Math.abs(arr[i].y1 - y);
			d = Math.min(d, Math.abs(arr[i].x2 - x) + Math.abs(arr[i].y2 - y));
			d = Math.min(d, Math.abs(arr[i].x3 - x) + Math.abs(arr[i].y3 - y));
			d = Math.min(d, Math.abs(arr[i].x4 - x) + Math.abs(arr[i].y4 - y));
			
			if(arr[i].x3 >= x && arr[i].y3 >= y && arr[i].x1 <= x && arr[i].y1 <= y) {
				d = 0;
			}
			
			if(arr[i].x1 >= x && arr[i].y1 >= y && arr[i].x3 <= x && arr[i].y3 <= y) {
				d = 0;
			}
			
			if(arr[i].x3 >= x && arr[i].x1 <= x || arr[i].x3 <= x && arr[i].x1 >= x) {
				d = Math.min(d, Math.abs(arr[i].y1 - y));
				d = Math.min(d, Math.abs(arr[i].y3 - y));
			}
			
			if(arr[i].y3 >= y && arr[i].y1 <= y || arr[i].y3 <= y && arr[i].y1 >= y) {
				d = Math.min(d, Math.abs(arr[i].x1 - x));
				d = Math.min(d, Math.abs(arr[i].x3 - x));
			}
			
			arr[i].d = d;
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			
			System.out.print(arr[i].i);
			if(i < n - 1) {
				System.out.print(" ");
			}
		}
	}
}