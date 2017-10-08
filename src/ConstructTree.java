
public class ConstructTree < T extends Comparable <T>> {
	public ConstructTree() {}
	
	//root node of the tree
	 Node<T> root; 
	
	public void buildTree (T[] preOrder, T[] inOrder){
		
		if((preOrder == null) || (inOrder == null) ) return;
		root = treeConstructor(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}
	
	
	
	
	/*This function recursively builds the tree with a given inOrder array, preOrder array and indices 
	 * representing the start and end of a given array or sub-array */
	private Node<T> treeConstructor (T[] preOrder, int preOrderStart, int preOrderEnd, T[] inOrder, int inOrderStart, int inOrderEnd) {
		
		//Returns null if no new node needs to be created
		if (inOrderStart > inOrderEnd || preOrderStart > preOrderEnd) return null;
		
		
		
		//Creates a new node containing the value in current index of of preOrder
		T first = preOrder[preOrderStart];
		
		//finds where to separate the array into left/right trees
		int location = assignInOrderIndex(inOrder, first);
		int preOrderLocation = preOrderStart + (location - inOrderStart);
		
		//current node
		Node<T> root = new Node<T>(first);
		
		// left side of tree  
		
		//preOrder array starts on left side 
		int preOrderStartLeft = preOrderStart + 1;
		//preOrder array ends
		int preOrderEndLeft = preOrderLocation;
		//inOrder array starts
		int inOrderStartLeft = inOrderStart;
		//splits location in half, left side is left side of tree
		int inOrderEndLeft = location - 1;
		
		// right side of tree
		
		// right side preOrder begins
		int preOrderStartRight = preOrderLocation + 1;
		//preOrder right ends 
		int preOrderEndRight = preOrderEnd;
		// right side inOrder array is to the right of the location 
		int inOrderStartRight = location + 1;
		int inOrderEndRight = inOrderEnd;
		
		
		
		//Recursive calls to build left and right children of the current node
		root.left = treeConstructor(preOrder, preOrderStartLeft, preOrderEndLeft, inOrder, inOrderStartLeft, inOrderEndLeft);
		root.right = treeConstructor(preOrder, preOrderStartRight, preOrderEndRight, inOrder, inOrderStartRight, inOrderEndRight);
		
		//Return the current node
		return root;
	}
	
	//A helper function to assign the inOrderIndex variable to the index containing the given string
	private int assignInOrderIndex(T[] inOrder, T first) {
		int index = 0;
		while(first.compareTo(inOrder[index]) != 0) {
			index++;
		}
		return index;
		
	}
	
}
