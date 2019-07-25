package class_1_LLnSnQ;

import java.util.LinkedList;
import java.util.Queue;

public class RottenCropsInAFarm {

	public static void main(String[] args) {
		
		int[][] arr = {
				{0, 1, 0, 0, 0, 1, 0},
				{1, 1, 1, 0, 0, 1, 1},
				{0, 2, 0, 0, 0, 1, 0},
				{0, 0, 0, 1, 1, 1, 0},
				{0, 1, 0, 2, 1, 0, 0},
				{2, 1, 0, 0, 1, 1, 0},
				{0, 1, 1, 0, 0, 0, 0},
				{0, 0, 1, 1, 1, 1, 0}
		};
		
		rottenOranges(arr);
	}
	
	public static class Pair {
		
		int x;
		int y;
		int t;
		
		Pair(int x, int y, int t){
			this.x = x;
			this.y = y;
			this.t= t;
		}
	}
	
	public static void rottenOranges(int[][] arr) {
		
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 2) {
					Pair np = new Pair(i, j, 0);
					visited[i][j] = true;
					q.add(np);
				}
			}
		}
		
		int time = 0;
		
		while(q.size() > 0) {
			
			Pair rem = q.remove();
			
			visited[rem.x][rem.y] = true;
			
			int x = rem.x;
			int y = rem.y;
			int t = rem.t;
			
			if(t > time) {
				time = t;
			}
			
			if(x + 1 < arr.length && arr[x + 1][y] == 1 && visited[x + 1][y] == false) {
				Pair np = new Pair(x + 1, y, t + 1);
				q.add(np);
			}
			
			if(x - 1 >= 0 && arr[x - 1][y] == 1 && visited[x - 1][y] == false) {
				Pair np = new Pair(x - 1, y, t + 1);
				q.add(np);
			}
			
			if(y + 1 < arr[0].length && arr[x][y + 1] == 1 && visited[x][y + 1] == false) {
				Pair np = new Pair(x, y + 1, t + 1);
				q.add(np);
			}
			
			if(y - 1 >= 0 && arr[x][y - 1] == 1 && visited[x][y - 1] == false) {
				Pair np = new Pair(x, y - 1, t + 1);
				q.add(np);
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 1 && visited[i][j] == false) {
					time = -1;
				}
			}
		}
		
		System.out.println(time);
	}
}