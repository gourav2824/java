
public class Client {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		
		Generic_Trees gt = new Generic_Trees(arr);
		
//		gt.display();
		
//		System.out.println(gt.size());
//		System.out.println(gt.max());
//		System.out.println(gt.height());
//		System.out.println(gt.find(100));
//		
//		System.out.println(gt.nodeToRootPath(110));
		
//		gt.display();
//		System.out.println("-----------------");
//		gt.removeAllLeaves();
//		gt.display();
		
//		gt.display();
//		System.out.println("-----------------");
		gt.mirrorTree();
		gt.display();
	}
}