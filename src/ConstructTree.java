
public class ConstructTree {
	
	//A variable representing the current index in the preOrder array for creating new nodes recursively
	static int preOrderIndex = 0;
	
	/*This function recursively builds the tree with a given inOrder array, preOrder array and indices 
	 * representing the start and end of a given array or sub-array */
	public Node<String> build (String[] inOrder, String[] preOrder, int inOrderStart, int inOrderEnd) {
		
		//Returns null if no new node needs to be created
		if (inOrderStart > inOrderEnd) return null;
		
		//Creates a new node containing the value in current index of of preOrder
		Node<String> newNode = new Node<String>(preOrder[preOrderIndex++]);
		//System.out.println("Created new node for preOrderIndex " + preOrderIndex);
		
		//Return the current node if it has no children
		if (inOrderStart == inOrderEnd) return newNode;
		
		//Call the helper function to find the index in the inOrder array containing newNode.data
		int inOrderIndex = assignInOrderIndex(inOrder, inOrderStart, inOrderEnd, newNode.data);
		
		//Recursive calls to build left and right children of the current node
		newNode.left = build(inOrder, preOrder, inOrderStart, inOrderIndex - 1);
		newNode.right = build(inOrder, preOrder, inOrderIndex + 1, inOrderEnd);
		
		//Return the current node
		return newNode;
	}
	
	//A helper function to assign the inOrderIndex variable to the index containing the given string
	int assignInOrderIndex(String[] inOrder, int inOrderStart, int inOrderEnd, String lookFor) {
		
		int i;
		
		for (i = inOrderStart; i <= inOrderEnd; i++) {
			if (inOrder[i] == lookFor) {
				return i;
			}
		}
		return i;
	}
	
	//A function to print the inOrder traversal of the tree
	void printInorder(Node<String> node) {
		
        if (node == null) return;
  
        //Recursive call to left child
        printInorder(node.left);
  
        //Print data
        System.out.print(node.data + " ");
  
        //Recursive call to right child
        printInorder(node.right);
    }

}
