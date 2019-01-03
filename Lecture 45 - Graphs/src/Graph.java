import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	
	HashMap<String, HashMap<String, Integer>> vces = new HashMap<>();
	
	public int countVertices() {
		return vces.size();
	}
	
	public boolean containsVertex(String vname) {
		return vces.containsKey(vname);
	}
	
	public void addVertex(String vname) {
		
		if(vces.containsKey(vname) == false) {
			vces.put(vname, new HashMap<String, Integer>());
		}
	}
	
	public void removeVertex(String vname) {
		
		ArrayList<String> adjvces = new ArrayList<>(vces.get(vname).keySet());
		
		for(String ver : adjvces) {
			removeEdge(ver, vname);
		}
		
		vces.remove(vname);
	}
	
	public int countEdges() {
		
		int count = 0;
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		
		for(String vname : vnames) {
			count += vces.get(vname).size();
		}
		
		return count / 2;
	}
	
	public boolean containsEdge(String v1name, String v2name) {
		
		if(vces.containsKey(v1name) && vces.containsKey(v2name)) {
			return vces.get(v1name).containsKey(v2name);
		}
		
		else {
			return false;
		}
	}
	
	public void addEdge(String v1name, String v2name, int wt) {
		
		if(vces.containsKey(v1name) && vces.containsKey(v2name)) {
			vces.get(v1name).put(v2name, wt);
			vces.get(v2name).put(v1name, wt);
		}
	}
	
	public void removeEdge(String v1name, String v2name) {
		
		if(vces.containsKey(v1name) && vces.containsKey(v2name)) {
			vces.get(v1name).remove(v2name);
			vces.get(v2name).remove(v1name);
		}
	}
	
	public void display() {
		
		System.out.println("-----------------------------------");
		ArrayList<String> vnames = new ArrayList<>(vces.keySet());
		
		for(String vname : vnames) {
			System.out.println(vname + " -> " + vces.get(vname));
		}
	}
	
	public boolean hasPath(String src, String dest) {
		
		HashSet<String> visited = new HashSet<>();
		return hasPathHelper(src, dest, visited);
	}
	
	private boolean hasPathHelper(String src, String dest, HashSet<String> visited) {
		
		if(src.equals(dest)) {
			return true;
		}
		
		visited.add(src);
		
		for(String nbr : vces.get(src).keySet()) {
			
			if(visited.contains(nbr) == false) {
				
				boolean found = hasPathHelper(nbr, dest, visited);
				if(found == true) {
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
		
		if(src.equals(dest)) {
			System.out.println(psf);
		}
		
		visited.add(src);
		
		for(String nbr : vces.get(src).keySet()) {
			
			if(visited.contains(nbr) == false) {
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
	
	public void MultiSolver(String s, String d, int cf, int ff, int k) {
		
		sp = "";
		lp = "";
		cp = "";
		fp = "";
		
		spw = Integer.MAX_VALUE;
		lpw = Integer.MIN_VALUE;
		cpw = Integer.MAX_VALUE;
		fpw = Integer.MIN_VALUE;
		
		HashSet<String> visited = new HashSet<>();
		MultiSolver(s, d, visited, cf, ff, k, s, 0);
		
		System.out.println("Smallest = " + sp + " @ " + spw);
		System.out.println("Largest = " + lp + " @ " + lpw);
		System.out.println("Ceil = " + cp + " @ " + cpw);
		System.out.println("Floor = " + fp + " @ " + fpw);
	}
	
	private void MultiSolver(String s, String d, HashSet<String> visited, int cf, int ff, int k, String psf, int wsf) {
		
		if(s.equals(d)) {
			
			System.out.println(psf + " @ " + wsf);
			
			if(wsf < spw) {
				spw = wsf;
				sp = psf;
			}
			
			if(wsf > lpw) {
				lpw = wsf;
				lp = psf;
			}
			
			if(wsf > cf && wsf < cpw) {
				cpw = wsf;
				cp = psf;
			}
			
			if(wsf < ff && wsf > fpw) {
				fpw = wsf;
				fp = psf;
			}
			
			return;
		}
		
		visited.add(s);
		
		for(String nbr : vces.get(s).keySet()) {
			
			if(visited.contains(nbr) == false) {
				int nbrwt = vces.get(s).get(nbr);
				MultiSolver(nbr, d, visited, cf, ff, k, psf + nbr, wsf + nbrwt);
			}
		}
		
		visited.remove(s);
	}
}