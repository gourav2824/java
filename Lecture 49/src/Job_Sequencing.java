import java.util.Collections;
import java.util.PriorityQueue;

public class Job_Sequencing {

	public static void main(String[] args) {

		char[] acts = "abdecfghijklmnopqrstuv".toCharArray();
		int[] dlines = { 4, 2, 3, 1, 8, 3, 2, 1, 2, 6, 5, 7, 9, 2, 6, 5, 2, 7, 6, 9, 1, 6 };
		int[] profits = { 100, 69, 94, 54, 33, 77, 11, 99, 37, 76, 34, 47, 78, 45, 39, 75, 49, 34, 48, 92, 44, 90 };

		jobSequencing(acts, dlines, profits);
	}

	public static void jobSequencing(char[] activities, int[] deadlines, int[] profits) {

		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

		int maxdl = 0;
		for (int i = 0; i < activities.length; i++) {
			Pair np = new Pair(activities[i], deadlines[i], profits[i]);
			pq.add(np);
			maxdl = Math.max(maxdl, deadlines[i]);
		}

		int[] free = new int[maxdl + 1];
		char[] res = new char[maxdl + 1];

		for (int i = 0; i < free.length; i++) {
			free[i] = i;
		}

		while (pq.size() > 0) {

			Pair rem = pq.remove();
			int realFree = find(free, rem.deadline);

			if (realFree > 0) {

				res[realFree] = rem.activity;
				int rfm1 = find(free, realFree - 1);			// rfm1 = real free minus 1
				free[realFree] = rfm1;
			}
		}

		System.out.println(res);
	}

	private static class Pair implements Comparable<Pair> {

		char activity;
		int deadline;
		int profit;

		public Pair(char activity, int deadline, int profit) {

			this.activity = activity;
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public int compareTo(Pair o) {
			return this.profit - o.profit;
		}
	}

	private static int find(int[] free, int dline) {

		if (free[dline] == dline) {
			return dline;
		}

		else {
			int realFree = find(free, free[dline]);
			free[dline] = realFree;
			return realFree;
		}
	}
}