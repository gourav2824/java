
import java.util.*;

public class graphDisjointSet {
	public static class edge {
		int v1;
		int v2;
		int w;
		int clr;

		edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}

	public static void addedge(ArrayList<ArrayList<edge>> graph, int v1, int v2, int w) {
		graph.get(v1).add(new edge(v1, v2, w));
		graph.get(v2).add(new edge(v2, v1, w));
	}

	public static void display(ArrayList<ArrayList<edge>> graph) {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print(i + " -> ");
			for (int e = 0; e < graph.get(i).size(); e++) {
				edge ed = graph.get(i).get(e);
				System.out.print("[" + ed.v1 + "," + ed.v2 + "," + ed.w + "] ");
			}
			System.out.println(".");
		}
	}

	public static class thelper implements Comparable<thelper> {
		int vtx;
		String psf;
		int dsf;

		thelper(int vtx, String psf, int dsf) {
			this.vtx = vtx;
			this.psf = psf;
			this.dsf = dsf;
		}

		public int compareTo(thelper o) {
			return this.dsf - o.dsf;
		}

	}

	public static void dijkstra(ArrayList<ArrayList<edge>> graph, int src) {
		PriorityQueue<thelper> pq = new PriorityQueue<>();
		boolean visited[] = new boolean[graph.size()];
		thelper rh = new thelper(src, "" + src, 0);
		pq.add(rh);
		while (pq.size() > 0) {

			thelper cp = pq.peek();
			pq.remove();

			if (visited[cp.vtx] == true) {
				continue;
			} else {
				visited[cp.vtx] = true;
			}
			System.out.println(cp.vtx + "via" + cp.psf + "@" + cp.dsf);
			for (int e = 0; e < graph.get(cp.vtx).size(); e++) {
				edge ed = graph.get(cp.vtx).get(e);
				thelper nn = new thelper(ed.v2, cp.psf + ed.v2, cp.dsf + ed.w);
				pq.add(nn);

			}
		}

	}

	public static class primshelper implements Comparable<primshelper> {
		int vtx;
		int prt;
		int wt;

		primshelper(int v, int p, int w) {
			vtx = v;
			prt = p;
			wt = w;
		}

		public int compareTo(primshelper o) {
			// TODO Auto-generated method stub
			return -this.wt - o.wt;
		}
	}

	public static void prims(ArrayList<ArrayList<edge>> graph, int src) {
		PriorityQueue<primshelper> pq = new PriorityQueue<>();
		ArrayList<ArrayList<edge>> mst = new ArrayList<ArrayList<edge>>();
		boolean visited[] = new boolean[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			mst.add(new ArrayList<edge>());
		}
		primshelper ph = new primshelper(src, -1, 0);
		pq.add(ph);
		while (pq.size() > 0) {
			primshelper cp = pq.peek();
			pq.remove();
			if (visited[cp.vtx] == true) {
				continue;
			} else {
				visited[cp.vtx] = true;
			}
			// print
			if (cp.prt != -1) {
				addedge(mst, cp.vtx, cp.prt, cp.wt);
			}
			// mst.get(cp.vtx).add(new edge(cp.vtx, cp.prt, cp.wt));
			for (int e = 0; e < graph.get(cp.vtx).size(); e++) {
				edge ed = graph.get(cp.vtx).get(e);
				primshelper nn = new primshelper(ed.v2, ed.v1, ed.w);
				pq.add(nn);

			}
		}
		display(mst);
		// return mst;
	}

	// public static void moonprblm(ArrrayList<ArrayList<edge>> graph){
	//
	//
	// }
	static class kedge implements Comparable<kedge> {
		int v1;
		int v2;
		int wt;

		public kedge(int v1, int v2, int wt) {
			this.v1 = v1;
			this.v2 = v2;
			this.wt = wt;
		}

		public int compareTo(kedge o) {
			return this.wt - o.wt;
		}
	}

	public static int findleader(ArrayList<Integer> dsp, int v) {
		if (dsp.get(v) == v) {
			return v;

		} else {
			int vsl = findleader(dsp, dsp.get(v));
			dsp.set(v, vsl); /// path compresiion
			return vsl;
		}

	}

	public static void merge(ArrayList<Integer> dsp, ArrayList<Integer> dsr, int l1, int l2) {
		if (dsr.get(l1) < dsr.get(l2)) {
			dsr.set(l1, 0);
			dsp.set(l1, l2);

		} else if (dsr.get(l1) == dsr.get(l2)) {
			dsp.set(l1, l2);
			dsr.set(l1, 0);
			dsr.set(l2, dsr.get(l2) + 1);
		} else if (dsr.get(l1) > dsr.get(l2)) {
			dsr.set(l2, 0);
			dsp.set(l2, l1);

		}
	}

	public static void kruskals(ArrayList<ArrayList<edge>> graph) {
		ArrayList<ArrayList<edge>> mst = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			mst.add(new ArrayList<edge>());
		}
		PriorityQueue<kedge> pq = new PriorityQueue<>();
		ArrayList<Integer> dsp = new ArrayList<>();
		ArrayList<Integer> dsr = new ArrayList<>();
		for (int i = 0; i < graph.size(); i++) {
			dsp.add(i);
			dsr.add(1);
		}
		for (int i = 0; i < graph.size(); i++) {
			for (int e = 0; e < graph.get(i).size(); e++) {
				edge ed = graph.get(i).get(e);
				if (ed.v1 < ed.v2) {
					kedge edr = new kedge(ed.v1, ed.v2, ed.w);

					pq.add(edr);
				}

			}
		}
		while (pq.size() > 0) {// e
			// remove edge
			// get leaders of both ends
			// if hey belong to diff leaders,take edge,merge
			kedge ke = pq.peek();// loge
			pq.remove();// loge
			int v1sl = findleader(dsp, ke.v1);// nlog*^n=nloglogn=n
			int v2sl = findleader(dsp, ke.v2);
			if (v1sl != v2sl) {
				addedge(mst, ke.v1, ke.v2, ke.wt);
				merge(dsp, dsr, v1sl, v2sl);
			}
		}

		display(mst);

	}

	public static void main(String[] args) {

		int n = 7;
		ArrayList<ArrayList<edge>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<edge>());
		}

		addedge(graph, 0, 3, 40);
		addedge(graph, 0, 1, 10);
		addedge(graph, 1, 2, 10);
		addedge(graph, 2, 3, 10);
		// addedge(graph, 2, 5, 5);
		addedge(graph, 3, 4, 2);
		addedge(graph, 4, 5, 3);
		addedge(graph, 5, 6, 3);
		addedge(graph, 4, 6, 8);

		// boolean visited[] = new boolean[n];
//		display(graph);
		// dijkstra(graph, 0);
		// prims(graph, 0);
		// display(mst);
		// System.out.println("....................");
		// dijkstra(graph, 0);

//		System.out.println("-----------------------------");
//		kruskals(graph);

		int[] parent = new int[graph.size()];

		int[] disc = new int[graph.size()]; // Discovery time
		int[] low = new int[graph.size()]; // Low time

		boolean[] visited = new boolean[graph.size()];

		parent[0] = -1;

		boolean[] aps = new boolean[graph.size()]; // Articulation Points

		ArticulationPoint(graph, parent, disc, low, visited, aps, 0);
		for (int i = 0; i < aps.length; i++) {
			if (aps[i] == true) {
				System.out.println(i + " is an AP");
			}
		}
	}

	static int time = 0;

	private static void ArticulationPoint(ArrayList<ArrayList<edge>> graph, int[] parent, int[] disc, int[] low,
			boolean[] visited, boolean[] aps, int src) {

		disc[src] = low[src] = ++time;
		visited[src] = true;
		int counter = 0;

		for (int i = 0; i < graph.get(src).size(); i++) {

			int nbr = graph.get(src).get(i).v2;

			if (nbr == parent[src]) {
				// nothing to do
			}

			else if (visited[nbr] == true) {
				low[src] = Math.min(low[src], disc[nbr]);
			}

			else {

				parent[nbr] = src;
				ArticulationPoint(graph, parent, disc, low, visited, aps, nbr);
				low[src] = Math.min(low[src], low[nbr]);

				if (parent[src] == -1) {
					counter++;
					if (counter == 2) {
						aps[src] = true;
					}
				}

				else {

					if (low[nbr] >= disc[src]) {
						aps[src] = true;
						if (low[nbr] > disc[src]) {
							System.out.println("Bridge from " + src + " to " + nbr);
						}
					}
				}
			}
		}
	}
}