package test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenCropsExtendedVersion {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();

		int[][] arr = new int[r][c];
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {

				arr[i][j] = sc.nextInt();

				if (arr[i][j] == 3) {
					Pair np = new Pair(i, j, 0, 3);
					q.add(np);
				}
			}
		}

		rottenOranges(arr, q);
	}

	public static class Pair {

		int x;
		int y;
		int t;
		int val;

		Pair(int x, int y, int t, int val) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.val = val;
		}
	}

	public static void rottenOranges(int[][] arr, Queue<Pair> q) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2) {
					Pair np = new Pair(i, j, 0, 2);
					q.add(np);
				}
			}
		}

		int time = 0;

		while (q.size() > 0) {

			Pair rem = q.remove();

			int x = rem.x;
			int y = rem.y;
			int t = rem.t;
			int val = rem.val;

//			arr[x][y] = val;
			
			if (t > time) {
				time = t;
			}

			if (x + 1 < arr.length && arr[x + 1][y] == 1) {
				Pair np = new Pair(x + 1, y, t + 1, val);
				arr[x + 1][y] = val;
				q.add(np);
			}

			if (x - 1 >= 0 && arr[x - 1][y] == 1) {
				Pair np = new Pair(x - 1, y, t + 1, val);
				arr[x - 1][y] = val;
				q.add(np);
			}

			if (y + 1 < arr[0].length && arr[x][y + 1] == 1) {
				Pair np = new Pair(x, y + 1, t + 1, val);
				arr[x][y + 1] = val;
				q.add(np);
			}

			if (y - 1 >= 0 && arr[x][y - 1] == 1) {
				Pair np = new Pair(x, y - 1, t + 1, val);
				arr[x][y - 1] = val;
				q.add(np);
			}

			if (arr[x][y] == 3) {

				if (x + 2 < arr.length && arr[x + 1][y] == 3 && arr[x + 2][y] == 1) {
					Pair np = new Pair(x + 2, y, t + 1, val);
					arr[x + 2][y] = val;
					q.add(np);
				}

				if (x - 2 >= 0 && arr[x - 1][y] == 3 && arr[x - 2][y] == 1) {
					Pair np = new Pair(x - 2, y, t + 1, val);
					arr[x - 2][y] = val;
					q.add(np);
				}

				if (y + 2 < arr[0].length && arr[x][y + 1] == 3 && arr[x][y + 2] == 1) {
					Pair np = new Pair(x, y + 2, t + 1, val);
					arr[x][y + 2] = val;
					q.add(np);
				}

				if (y - 2 >= 0 && arr[x][y - 1] == 3 && arr[x][y - 2] == 1) {
					Pair np = new Pair(x, y - 2, t + 1, val);
					arr[x][y - 2] = val;
					q.add(np);
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					time = -1;
				}
			}
		}

		System.out.println(time);
	}
}