import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ConstructTree<String> tree = new ConstructTree<String>();

		System.out.println("Enter the preorder separated by spaces: ");
		Scanner scanner = new Scanner(System.in);
		String preOrderInput = scanner.nextLine();
		System.out.println("Enter the inorder separated by spaces: ");
		String inOrderInput = scanner.nextLine();
		scanner.close();
	
		String preOrder[] = preOrderInput.split(" ");
		String inOrder[] = inOrderInput.split(" ");
	
		
		
		
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
