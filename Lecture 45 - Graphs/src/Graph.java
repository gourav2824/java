import java.util.ArrayList;
import java.util.HashMap;

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
}