import java.util.LinkedList;

public class Client_BT {

	public static void main(String[] args) {

		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		int[] arr1 = { 50, 25, 12, 10, -1, 20, -1, -1, -1, 75, 62, 60, -1, -1, 87, -1, -1, -1 };

		Binary_Tree bt = new Binary_Tree(arr);
		Binary_Tree bt1 = new Binary_Tree(arr1);

//		bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.min());
//		System.out.println(bt.height());
//		System.out.println(bt.find(62));

//		bt1.printSingleChild();
//		bt.display();
//		System.out.println("------------------");
//		bt.removeLeaf();
//		bt.display();

//		System.out.println(bt.RootToNodePath(37));

		int[] preOrder = { 50, 25, 12, 37, 75, 62, 87 };
		int[] postOrder = { 12, 37, 25, 62, 87, 75, 50 };
		int[] inOrder = { 12, 25, 37, 50, 62, 75, 87 };

		Binary_Tree btprein = new Binary_Tree(preOrder, inOrder);
//		btpi.display();

		Binary_Tree btpostin = new Binary_Tree(postOrder, inOrder, true);
//		btpostin.display();

//		bt1.display();
		
//		printBinaries(15);
		
//		btpostin.preOrderIteratively();
//		System.out.println();
//		btprein.postOrderIteratively();
//		System.out.println();
//		btpostin.inOrderIteratively();
//		System.out.println();
//		btprein.inOrderIteratively();
		
//		System.out.println(bt1.isBalanced());
//		System.out.println(bt1.isBalancedInOn());
		
		System.out.println(bt1.isBST());
		System.out.println(bt1.isBST2());
		
	}

	private static class Pair {
		int data;
		String binary;

		Pair(int data, String binary) {
			this.data = data;
			this.binary = binary;
		}
	}

	public static void printBinaries(int n) {

		LinkedList<Pair> queue = new LinkedList<>();

		Pair start = new Pair(1, "1");
		queue.addLast(start);

		while (queue.size() > 0) {

			Pair removepair = queue.removeFirst();
			System.out.println(removepair.data + " = " + removepair.binary);

			Pair leftPair = new Pair(removepair.data * 2, removepair.binary + "0");
			Pair rightPair = new Pair(removepair.data * 2 + 1, removepair.binary + "1");

			if (leftPair.data <= n) {
				queue.addLast(leftPair);
			}

			if (rightPair.data <= n) {
				queue.addLast(rightPair);
			}
		}
	}
}