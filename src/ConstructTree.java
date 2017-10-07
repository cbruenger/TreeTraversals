
public class ConstructTree < T extends Comparable <T>> {
	public ConstructTree() {}
	//A variable representing the current index in the preOrder array for creating new nodes recursively
	//static int preOrderIndex = 0;
	
	
//	@SuppressWarnings("hiding")
//	private class Node<T> { 
//		
//		private T data;
//		private Node<T> left;
//		private Node<T> right; 
//			
//		public Node (T data){
//			this.data = data;
//			this.left = null;
//			this.right = null;
//		}
//		
//	}
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
		int location = assignInOrderIndex(inOrder, first);
		int preOrderLocation = preOrderStart + (location - inOrderStart);
		
		Node<T> root = new Node<T>(first);
		//Return the current node if it has no children
		//if (inOrderStart == inOrderEnd) return newNode;
		int preOrderStartLeft = preOrderStart + 1;
		int preOrderEndLeft = preOrderLocation;
		int inOrderStartLeft = inOrderStart;
		int inOrderEndLeft = location - 1;
		
		int preOrderStartRight = preOrderLocation + 1;
		int preOrderEndRight = preOrderEnd;
		int inOrderStartRight = location + 1;
		int inOrderEndRight = inOrderEnd;
		
		//Call the helper function to find the index in the inOrder array containing newNode.data
		//int inOrderIndex = assignInOrderIndex(inOrder, first);
		
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
