import java.util.Collections;
import java.util.PriorityQueue;

public class Job_Sequencing {

	public static void main(String[] args) {
		
		char[] acts = "abdecfghijklmnopqrstuv".toCharArray();
		int[] dlines = { 4, 2, 3, 1, 8, 3, 2, 1, 2, 6, 5, 7, 9, 2, 6, 5, 2, 7, 6, 9, 1, 6 };
		int[] profits = { 100, 69, 94, 54, 33, 77, 11, 99, 37, 76, 34, 47, 78, 45, 39, 75, 49, 34, 48, 92, 44, 90 };
		
		jobSequencing(acts, dlines, profits);
	}
	
	public static class Pair implements Comparable<Pair>{
		
		char act;
		int dline;
		int profit;
		
		public Pair(char act, int dline, int profit) {
			
			this.act = act;
			this.dline = dline;
			this.profit = profit;
		}

		@Override
		public int compareTo(Pair o) {
			return this.profit - o.profit;
		}
	}
	
	private static void jobSequencing(char[] acts, int[] dlines, int[] profits) {
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int maxdl = 0;
		
		for(int i = 0; i < acts.length; i++) {
			Pair np = new Pair(acts[i], dlines[i], profits[i]);
			pq.add(np);
			maxdl = Math.max(maxdl, dlines[i]);
		}
		
		int[] free = new int[maxdl + 1];
		char[] seq = new char[maxdl + 1];
		
		for(int i = 0; i < free.length; i++) {
			free[i] = i;
		}
		
		while(pq.size() > 0) {
			
			Pair rem =  pq.remove();
			int realFree = find(free, rem.dline);
			
			if(realFree > 0) {
				seq[realFree] = rem.act;
				free[realFree] = find(free, realFree - 1);
			}
		}
		
		System.out.println(seq);
	}
	
	private static int find(int[] free, int dline) {
		
		if(free[dline] == dline) {
			return dline;
		}
		
		int realFree = find(free, free[dline]);
		free[dline] = realFree;
		return realFree;
	}
}