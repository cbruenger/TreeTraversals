import java.util.*;

public class ConstructTree {
	
	Node<Integer> root;
	static int preOrderIndex = 0;
	
	public ConstructTree () {}
	
	public Node<Integer> buildTree (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, int inOrderStart, int inOrderEnd) {
		
		if (inOrderStart > inOrderEnd) return null;
		
		Node newNode = new Node(Integer preOrder[preOrderIndex++]);
	}

}
