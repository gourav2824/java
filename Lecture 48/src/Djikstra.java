import java.util.PriorityQueue;

public class Djikstra {

	public static void main(String[] args) {
		
		Integer[][] graph=new Integer[6][6];
		graph[0][1]=2;
		graph[0][2]=3;
		graph[1][3]=5;
		graph[2][4]=3;
		graph[3][5]=2;
		graph[4][5]=7;
		graph[2][3]=1;
		
		djikstra(graph, 0);
	}
	
	private static class DPair implements Comparable<DPair> {
		
		int s;
		String psf;
		int wsf;
		
		DPair(int s, String psf, int wsf){
			this.s = s;
			this.psf = psf;
			this.wsf = wsf;
		}
		
		@Override
		public int compareTo(DPair o) {
			return this.wsf - o.wsf;
		}
	}
	
	private static void djikstra(Integer[][] graph, int src) {
		
		PriorityQueue<DPair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[graph.length];
		
		pq.add(new DPair(src, "" + src, 0));

		while (pq.size() > 0) {

			// 1. Remove
			DPair rem = pq.remove();

			// 2. Mark
			if (visited[rem.s] == true) {
				continue;
			}
			visited[rem.s] = true;

			// 3. Print (Work)
			System.out.println(rem.s + " via " + rem.psf + " @ " + rem.wsf);

			// 4. Add the Unvisited Neighbors
			
			for(int i = 0; i < graph.length; i++) {
				if(graph[rem.s][i] != null && visited[i] == false) {
					DPair np = new DPair(i, rem.psf + i, rem.wsf + graph[rem.s][i]);
					pq.add(np);
				}
			}
		}
	}
}