import java.util.HashSet;
import java.util.Stack;

public class Topological_Sort {

	public static void main(String[] args) {
		
		boolean[][] graph = {
				{false,true,false,true,false,false},
				{false,false,true,false,false,false},
				{false,false,false,true,false,false},
				{false,false,false,false,false,false},
				{false,false,false,true,false,true},
				{false,false,true,false,false,false}
		};
		
		topologicalSort(graph);
	}
	
	private static void topologicalSort(boolean[][] graph) {
		
		boolean[] visited = new boolean[graph.length];
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < graph.length; i++) {
			if(visited[i] == false) {
				topologicalSort(graph, visited, st, i);
			}
		}
		
		while(st.size() > 0) {
			System.out.print(st.pop() + " ");
		}
	}
	
	private static void topologicalSort(boolean[][] graph, boolean[] visited, Stack<Integer> st, int s) {
		
		visited[s] = true;
		
		for(int j = 0; j < graph.length; j++) {
			if(graph[s][j] == true && visited[j] == false) {
				topologicalSort(graph, visited, st, j);
			}
		}
		
		st.push(s);
	}
}