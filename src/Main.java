import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ConstructTree<String> tree = new ConstructTree<String>();

		System.out.println("Enter the preorder separated by spaces: ");
		Scanner scanner = new Scanner(System.in);
		String preOrderInput = scanner.nextLine();
		System.out.println("Enter the inorder separated by commas: ");
		String inOrderInput = scanner.nextLine();
		scanner.close();
	
		String preOrder[] = preOrderInput.split(" ");
		String inOrder[] = inOrderInput.split(" ");
	
		
		//String in[] = new String[] {"2","5","6","10","12","14","15"};
		//String pre[] = new String[] {"10","5","2","6","14","12","15"};
		
		//int len = inOrder.length;
		
		//Build the tree
		tree.buildTree(preOrder, inOrder);
		
		
		//Print traversals
		Traversals traverse = new Traversals();
		
		//inOrder
		System.out.println("InOrder traversal of constructed tree: ");
		traverse.printInOrder(tree.root);

		//preOrder
		System.out.println("PreOrder traversal of constructed tree: ");
		traverse.printPreOrder(tree.root);
		
		//postOrder
		System.out.println("PostOrder traversal of constructed tree: ");
		traverse.printPostOrder(tree.root);
		
		//byLevel
		System.out.println("ByLevel traversal of constructed tree: ");
		traverse.printByLevel(tree.root);
		
	
	}

}
