import java.util.HashMap;
import java.util.PriorityQueue;

public class Kruskal {

	public static void main(String[] args) {
		
		Integer[][] graph = new Integer[6][6];
		
		graph[0][1]=2;
		graph[0][2]=3;
		graph[1][3]=5;
		graph[2][4]=3;
		graph[3][5]=2;
		graph[4][5]=7;
		graph[2][3]=1;
		
		Integer[][] mst = KruskalMST(graph);
		
		for(int u = 0; u < mst.length; u++) {
			for(int v = 0; v < mst.length; v++) {
				System.out.print((mst[u][v] == null ? "*" : mst[u][v]) + "\t");
			}
			System.out.println();
		}
	}
	
	public static Integer[][] KruskalMST(Integer[][] graph){
		
		Integer[][] mst = new Integer[graph.length][graph.length];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		HashMap<Integer, DSNode> disjointSet = new HashMap<>();
		
		for(int u = 0; u < graph.length; u++) {
			disjointSet.put(u, new DSNode(u));
			
			for(int v = 0; v < graph.length; v++) {
				
				if(graph[u][v] != null) {
					pq.add(new Edge(u, v, graph[u][v]));
				}
			}
		}
		
		while(pq.size() > 0) {
			
			Edge rem = pq.remove();
			
			DSNode ulead = find(disjointSet.get(rem.u));
			DSNode vlead = find(disjointSet.get(rem.v));
			
			if(ulead != vlead) {
				mst[rem.u][rem.v] = rem.wt;
				merge(ulead, vlead);
			}
		}
		
		return mst;
	}
	
	private static class Edge implements Comparable<Edge> {
		
		int u;
		int v;
		int wt;
		
		Edge(int u, int v, int wt){
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}
	}
	
	private static class DSNode {
		
		int vtx;
		DSNode parent;
		int rank;
		
		DSNode(int vtx){
			this.vtx = vtx;
			this.parent = this;
			this.rank = 1;
		}
	}
	
	private static void merge(DSNode ulead, DSNode vlead) {
		
		if(ulead.rank > vlead.rank) {
			vlead.parent = ulead;
		}
		
		else if(ulead.rank < vlead.rank) {
			ulead.parent = vlead;
		}
		
		else {
			ulead.parent = vlead;
			vlead.rank++;
		}
	}
	
	private static DSNode find(DSNode vnode) {
		
		if(vnode.parent == vnode) {
			return vnode;
		}
		
		else {
			DSNode pnode = find(vnode.parent);
			vnode.parent = pnode;
			return pnode;
		}
	}
}