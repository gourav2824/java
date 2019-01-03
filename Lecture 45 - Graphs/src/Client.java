
public class Client {

	public static void main(String[] args) {
		
//		Graph g = new Graph();
//		
//		g.addVertex("A");
//		g.addVertex("B");
//		g.addVertex("C");
//		g.addVertex("D");
//		g.addVertex("E");
//		g.addVertex("F");
//		g.addVertex("G");
//		
//		g.addEdge("A", "D", 40);
//		g.addEdge("A", "B", 10);
//		g.addEdge("B", "C", 10);
//		g.addEdge("C", "D", 10);
//		g.addEdge("D", "E", 2);
//		g.addEdge("E", "F", 3);
//		g.addEdge("E", "G", 8);
//		g.addEdge("F", "G", 3);
		
//		g.display();
//		g.removeEdge("B", "C");
//		g.display();
//		g.removeVertex("D");
//		g.display();
		
//		System.out.println(g.hasPath("A", "F"));
//		g.removeEdge("D", "E");
//		System.out.println(g.hasPath("A", "F"));
		
//		g.printAllPaths("A", "G");
		
		Graph g = new Graph();
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		
		g.addEdge("A", "B", 2);
		g.addEdge("A", "C", 3);
		g.addEdge("B", "D", 4);
		g.addEdge("C", "D", 7);
		g.addEdge("C", "E", 1);
		g.addEdge("D", "E", 2);
		g.addEdge("D", "F", 10);
		g.addEdge("E", "F", 3);
		
		g.MultiSolver("A", "F", 14, 15, 0);
	}
}