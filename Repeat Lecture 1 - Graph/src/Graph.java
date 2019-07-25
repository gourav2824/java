import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph {

	HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();

	public int countVertices() {
		return vces.size();
	}

	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}

	public void addVertex(String vname) {

		if (vces.containsKey(vname) == false) {
			vces.put(vname, new HashMap<String, Integer>());
		}
	}

	public void removeVertex(String vname) {

		ArrayList<String> adjvces = new ArrayList<>(vces.get(vname).keySet());

		for (String ver : adjvces) {
			removeEdge(ver, vname);
		}

		vces.remove(vname);
	}

	public int countEdges() {

		int count = 0;
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());

		for (String vname : vnames) {
			count += vces.get(vname).size();
		}

		return count / 2;
	}

	public boolean containsEdge(String v1name, String v2name) {

		if (vces.containsKey(v1name) && vces.containsKey(v2name)) {
			return vces.get(v1name).containsKey(v2name);
		}

		else {
			return false;
		}
	}

	public void addEdge(String v1name, String v2name, int wt) {

		if (vces.containsKey(v1name) && vces.containsKey(v2name)) {
			vces.get(v1name).put(v2name, wt);
			vces.get(v2name).put(v1name, wt);
		}
	}

	public void removeEdge(String v1name, String v2name) {

		if (vces.containsKey(v1name) && vces.containsKey(v2name)) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		}
	}

	public void display() {

		System.out.println("-----------------------------------");
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());

		for (String vname : vnames) {
			System.out.println(vname + " -> " + vces.get(vname));
		}
	}

	public boolean hasPath(String src, String dest) {

		HashSet<String> visited = new HashSet<>();
		return hasPathHelper(src, dest, visited);
	}

	private boolean hasPathHelper(String src, String dest, HashSet<String> visited) {

		if (src.equals(dest)) {
			return true;
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {

			if (visited.contains(nbr) == false) {

				boolean found = hasPathHelper(nbr, dest, visited);
				if (found == true) {
					return true;
				}
			}
		}

		return false;
	}

	public void printAllPaths(String src, String dest) {

		HashSet<String> visited = new HashSet<>();
		printAllPaths(src, dest, visited, src);
	}

	private void printAllPaths(String src, String dest, HashSet<String> visited, String psf) {

		if (src.equals(dest)) {
			System.out.println(psf);
		}

		visited.add(src);

		for (String nbr : vces.get(src).keySet()) {

			if (visited.contains(nbr) == false) {
				printAllPaths(nbr, dest, visited, psf + nbr);
			}
		}

		visited.remove(src);
	}

	private String sp;
	private String lp;
	private String cp;
	private String fp;

	private int spw;
	private int lpw;
	private int cpw;
	private int fpw;

	PriorityQueue<Pair> pq;

	private class Pair implements Comparable<Pair> {

		String psf;
		int wsf;

		public Pair(String psf, int wsf) {
			this.psf = psf;
			this.wsf = wsf;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wsf - o.wsf;
		}
	}

	public void MultiSolver(String s, String d, int cf, int ff, int k) {

		sp = "";
		lp = "";
		cp = "";
		fp = "";

		spw = Integer.MAX_VALUE;
		lpw = Integer.MIN_VALUE;
		cpw = Integer.MAX_VALUE;
		fpw = Integer.MIN_VALUE;

		pq = new PriorityQueue<>();

		HashSet<String> visited = new HashSet<>();
		MultiSolver(s, d, visited, cf, ff, k, s, 0);

		System.out.println("Smallest = " + sp + " @ " + spw);
		System.out.println("Largest = " + lp + " @ " + lpw);
		System.out.println("Ceil = " + cp + " @ " + cpw);
		System.out.println("Floor = " + fp + " @ " + fpw);

		System.out.println(k + "th Largest = " + pq.peek().psf + " @ " + pq.peek().wsf);
	}

	private void MultiSolver(String s, String d, HashSet<String> visited, int cf, int ff, int k, String psf, int wsf) {

		if (s.equals(d)) {

			System.out.println(psf + " @ " + wsf);

			if (wsf < spw) {
				spw = wsf;
				sp = psf;
			}

			if (wsf > lpw) {
				lpw = wsf;
				lp = psf;
			}

			if (wsf > cf && wsf < cpw) {
				cpw = wsf;
				cp = psf;
			}

			if (wsf < ff && wsf > fpw) {
				fpw = wsf;
				fp = psf;
			}

			if (pq.size() < k) {
				pq.add(new Pair(psf, wsf));
			}

			else {
				if (wsf > pq.peek().wsf) {
					pq.remove();
					pq.add(new Pair(psf, wsf));
				}
			}

			return;
		}

		visited.add(s);

		for (String nbr : vces.get(s).keySet()) {

			if (visited.contains(nbr) == false) {
				int nbrwt = vces.get(s).get(nbr);
				MultiSolver(nbr, d, visited, cf, ff, k, psf + nbr, wsf + nbrwt);
			}
		}

		visited.remove(s);
	}

	private class TPair {

		String v;
		String p;
		int w;

		public TPair(String v, String p, int w) {

			this.v = v;
			this.p = p;
			this.w = w;
		}
	}

	public boolean bfs(String s, String d) {

		LinkedList<TPair> queue = new LinkedList<>();
		queue.addLast(new TPair(s, s, 0));

		HashSet<String> visited = new HashSet<>();

		while (queue.size() > 0) {

			TPair rem = queue.removeFirst();
			visited.add(rem.v);

			System.out.println(rem.v + " @ " + rem.p);

			if (rem.v.equals(d)) {
				return true;
			}

			for (String n : vces.get(rem.v).keySet()) {
				if (visited.contains(n) == false) {
					TPair np = new TPair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
					queue.addLast(np);
				}
			}
		}

		return false;
	}

	public boolean dfs(String s, String d) {

		LinkedList<TPair> stack = new LinkedList<>();
		stack.addFirst(new TPair(s, s, 0));

		HashSet<String> visited = new HashSet<>();

		while (stack.size() > 0) {

			TPair rem = stack.removeFirst();
			visited.add(rem.v);

			System.out.println(rem.v + " @ " + rem.p);

			if (rem.v.equals(d)) {
				return true;
			}

			for (String n : vces.get(rem.v).keySet()) {
				if (visited.contains(n) == false) {
					TPair np = new TPair(n, rem.p + n, rem.w + vces.get(rem.v).get(n));
					stack.addFirst(np);
				}
			}
		}

		return false;
	}

	public ArrayList<String> getConnectedComponents() {

		ArrayList<String> cc = new ArrayList<>();
		HashSet<String> visited = new HashSet<>();

		for (String ver : vces.keySet()) {
			if (visited.contains(ver) == false) {
				String comp = gccbft(ver, visited);
				cc.add(comp);
			}
		}

		return cc;
	}

	private String gccbft(String s, HashSet<String> visited) {

		String comp = "";

		LinkedList<String> queue = new LinkedList<>();
		queue.addLast(s);

		while (queue.size() > 0) {

			String rem = queue.removeFirst();

			if (visited.contains(rem)) {
				continue;
			}
			visited.add(rem);

			comp += rem;

			for (String n : vces.get(rem).keySet()) {
				if (visited.contains(n) == false) {
					queue.addLast(n);
				}
			}
		}

		return comp;
	}

	public boolean isCyclic() {

		HashSet<String> visited = new HashSet<>();

		for (String ver : vces.keySet()) {
			if (visited.contains(ver) == false) {
				if (isCyclicBFT(ver, visited) == true) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isCyclicBFT(String s, HashSet<String> visited) {

		LinkedList<String> queue = new LinkedList<>();
		queue.addLast(s);

		while (queue.size() > 0) {

			String rem = queue.removeFirst();

			if (visited.contains(rem)) {
				return true;
			}
			visited.add(rem);

			for (String n : vces.get(rem).keySet()) {
				if (visited.contains(n) == false) {
					queue.addLast(n);
				}
			}
		}

		return false;
	}

	public boolean isConnected() {

		HashSet<String> visited = new HashSet<>();
		ArrayList<String> vertices = new ArrayList<>(vces.keySet());

		String ver = vertices.get(0);
		gccbft(ver, visited);

		if (visited.size() == vertices.size()) {
			return true;
		}

		return false;
	}

	public boolean isBipartite() {

		HashMap<String, Integer> visited = new HashMap<>();

		for (String v : vces.keySet()) {
			if (visited.containsKey(v) == false) {
				if (isBipartiteHelper(v, visited) == false) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isBipartiteHelper(String s, HashMap<String, Integer> visited) {

		LinkedList<String> curr = new LinkedList<>();
		LinkedList<String> next = new LinkedList<>();

		curr.addLast(s);
		int level = 1;

		while (curr.size() > 0) {

			String rem = curr.removeFirst();

			if (visited.containsKey(rem) == true) {
				int oldLevel = visited.get(rem);
				if (oldLevel % 2 != level % 2) {
					return false;
				}
			}

			visited.put(rem, level);

			for (String n : vces.get(rem).keySet()) {
				if (visited.containsKey(n) == false) {
					next.addLast(n);
				}
			}

			if (curr.size() == 0) {
				curr = next;
				next = new LinkedList<>();
				level++;
			}
		}

		return true;
	}

	public void hamiltonianCycleAndPath(String s) {

		HashSet<String> visited = new HashSet<>();
		visited.add(s);

		hamiltonianCycleAndPath(s, s, visited, s);
	}

	private void hamiltonianCycleAndPath(String s, String os, HashSet<String> visited, String psf) {

		if (visited.size() == vces.size()) {

			System.out.print(psf + " is Hamiltonian Path");

			if (vces.get(s).containsKey(os) == true) {
				System.out.println(" and Cycle.");
			}

			else {
				System.out.println(".");
			}
		}

		for (String n : vces.get(s).keySet()) {
			if (visited.contains(n) == false) {
				visited.add(n);
				hamiltonianCycleAndPath(n, os, visited, psf + n);
				visited.remove(n);
			}
		}
	}

	private class DPair implements Comparable<DPair> {

		String v;
		String psf;
		int wsf;

		DPair(String v, String psf, int wsf) {
			this.v = v;
			this.psf = psf;
			this.wsf = wsf;
		}

		@Override
		public int compareTo(DPair o) {
			return this.wsf - o.wsf;
		}
	}

	public void Djikstra(String s) {

		PriorityQueue<DPair> pq = new PriorityQueue<>();
		HashSet<String> visited = new HashSet<>();

		pq.add(new DPair(s, s, 0));

		while (pq.size() > 0) {

			// 1. Remove
			DPair rem = pq.remove();

			// 2. Mark
			if (visited.contains(rem.v) == true) {
				continue;
			}
			visited.add(rem.v);

			// 3. Print (Work)
			System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

			// 4. Add the Unvisited Neighbors
			for (String n : vces.get(rem.v).keySet()) {
				if (visited.contains(n) == false) {
					DPair np = new DPair(n, rem.psf + n, rem.wsf + vces.get(rem.v).get(n));
					pq.add(np);
				}
			}
		}
	}

	private class PPair implements Comparable<PPair> {

		String v;
		String av;
		int aew;

		PPair(String v, String av, int aew) {
			this.v = v;
			this.av = av;
			this.aew = aew;
		}

		@Override
		public int compareTo(PPair o) {
			return this.aew - o.aew;
		}
	}

	public Graph Prims() {

		if (isConnected() == false) {
			return null;
		}

		Graph mst = new Graph();
		PriorityQueue<PPair> pq = new PriorityQueue<>();
		HashSet<String> visited = new HashSet<>();

		ArrayList<String> vertices = new ArrayList<>(vces.keySet());
		String s = vertices.get(0);

		pq.add(new PPair(s, null, 0));

		while (pq.size() > 0) {

			PPair rem = pq.remove();

			if (visited.contains(rem.v)) {
				continue;
			}
			visited.add(rem.v);

			mst.addVertex(rem.v);
			if (rem.av != null) {
				mst.addEdge(rem.av, rem.v, vces.get(rem.av).get(rem.v));
			}

			for (String n : vces.get(rem.v).keySet()) {
				if (visited.contains(n) == false) {
					PPair np = new PPair(n, rem.v, vces.get(rem.v).get(n));
					pq.add(np);
				}
			}
		}

		return mst;
	}
}