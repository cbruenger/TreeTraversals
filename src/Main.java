import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
//		System.out.println("Enter the preorder separated by commas: ");
//		Scanner scanner = new Scanner(System.in);
//		String preOrderScan = scanner.nextLine().toString();
//		System.out.println("Enter the inorder separated by commas: ");
//		String inOrderScan = scanner.nextLine().toString();
//		scanner.close();
//	
//		String preOrder[] = preOrderScan.split(",");
//		String inOrder[] = inOrderScan.split(",");
	
		
		String in[] = new String[] {"2","5","6","10","12","14","15"};
		String pre[] = new String[] {"10","5","2","6","14","12","15"};
		
		ConstructTree tree = new ConstructTree();
		int len = in.length;
		
		//Build the tree
		Node<String> root = tree.build(in, pre, 0, len - 1);
		
		
		//Print traversals
		Traversals traverse = new Traversals();
		
		//inOrder
		System.out.println("InOrder traversal of constructed tree: ");
		traverse.printInOrder(root);

		//preOrder
		System.out.println("PreOrder traversal of constructed tree: ");
		traverse.printPreOrder(root);
		
		//postOrder
		System.out.println("PostOrder traversal of constructed tree: ");
		traverse.printPostOrder(root);
		
		//byLevel
		System.out.println("ByLevel traversal of constructed tree: ");
		traverse.printByLevel(root);
		
	
	}

}
