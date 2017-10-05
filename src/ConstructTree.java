
public class ConstructTree {
	
	Node<String> root;
	static int preOrderIndex = 0;
	
	public ConstructTree () {}
	
	public Node<String> build (String[] inOrder, String[] preOrder, int inOrderStart, int inOrderEnd) {
		
		if (inOrderStart > inOrderEnd) return null;
		
		Node<String> newNode = new Node<String>(preOrder[preOrderIndex++]);
		
		if (inOrderStart == inOrderEnd) return newNode;
		
		int inOrderIndex = assignInOrderIndex(inOrder, newNode.data);
		
		newNode.left = build(inOrder, preOrder, inOrderStart, inOrderIndex - 1);
		newNode.right = build(inOrder, preOrder, inOrderIndex + 1, inOrderEnd);
		
		return newNode;
	}
	
	//A helper function to assign the the inOrderIndex variable
	int assignInOrderIndex(String[] inOrder, String lookFor) {
		
		int i;
		
		for (i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == lookFor) {
				return i;
			}
		}
		return i;
	}
	
	void printInorder(Node<String> node) 
    {
        if (node == null)
            return;
  
        /* first recur on left child */
        printInorder(node.left);
  
        /* then print the data of node */
        System.out.print(node.data + " ");
  
        /* now recur on right child */
        printInorder(node.right);
    }

}
