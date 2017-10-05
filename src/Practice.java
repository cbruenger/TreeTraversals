import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		
		System.out.println("Enter the preorder separated by spaces: ");
		Scanner scanner = new Scanner(System.in);
		String preOrderScan = scanner.nextLine();
		System.out.println("Enter the inorder separated by spaces: ");
		String inOrderScan = scanner.nextLine();
		String preOrderString = (String) preOrderScan;
		String inOrderString = (String) inOrderScan;
		scanner.close();
		
		
		
		String preOrder[] = preOrderString.split(" ");
		String inOrder[] = inOrderString.split(" ");
		
//		System.out.println("PreOrder: ");
//		for (String i : preOrder) {
//			System.out.println(i);
//		}
//		
//		System.out.println("InOrder:");
//		for (String i : inOrder) {
//			System.out.println(i);
//		}
		
		ConstructTree tree = new ConstructTree();
		int len = inOrder.length;
		
		Node<String> root = tree.build(inOrder, preOrder, 0, len-1);
		
		System.out.println("InOrder traversal of constructed tree: ");
		tree.printInorder(root);
		
		
		
		
	
	}

}
