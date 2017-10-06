import java.util.*;

//This class contains the functions for various traversals
public class Traversals {
	
	//Function for printing the inOrder traversal
	void printInOrder(Node<String> root) {
		
		//Return if tree is empty
		if (root == null) return;
        
        //A stack to save the path of inOrder traversal
        Stack<Node<String>> stack = new Stack<>();
        Node<String> currentNode = root;
         
        //Add path from root to left-most node to the stack
        while (currentNode != null) {
        	
            stack.push(currentNode);
            currentNode = currentNode.left;
            
        }
         
        /*Print and remove the node from the top of the stack and:
          - if the node has a right child, add it to the stack
          - if newly added node has a left child, add path to left-most node to the stack
         */
        while (stack.size() > 0) {
           
            currentNode = stack.pop();
            System.out.print(currentNode.data + " ");
            
     
            if (currentNode.right != null) {
            	
                currentNode = currentNode.right;
                 
                while (currentNode != null) {
                	
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                    
                }
                
            }
            
        }
        
        System.out.println();
        System.out.println();
		
	}
	
	//Function for printing the preOrder traversal
	void printPreOrder(Node<String> root) {
		
		//Return if tree is empty
        if (root == null) return;
 
        //A stack for traversing the tree
        Stack<Node<String>> stack = new Stack<>();
        stack.push(root);
 
        /*Iteratively print and remove the item from the top of the stack, and then push it's right child
          to the stack, followed by its left child */
        while (stack.empty() != true) {
             
            //Print and remove node from top of stack
            Node<String> currentNode = stack.peek();
            System.out.print(currentNode.data + " ");
            stack.pop();
 
            //Push right child and then left child to stack
            if (currentNode.right != null) stack.push(currentNode.right);
            if (currentNode.left != null) stack.push(currentNode.left);
            
        }
        
        System.out.println();
        System.out.println();
		
	}
	
	//Function for printing the postOrder traversal
	void printPostOrder(Node<String> root) {
		
		//Return if tree is empty
		if (root == null) return;
		
		/*An auxiliary stack for use while traversing, and a final stack
		  for holding and printing the postOrder traversal
		 */
        Stack<Node<String>> auxStack = new Stack<>();
        Stack<Node<String>> finalStack = new Stack<>();
 
        //Push the root onto the stack
        auxStack.push(root);
         
        //Traverse iteratively until the auxiliary stack is empty
        while (auxStack.isEmpty() != true) {
        	
            //Remove the top node from the auxiliary stack and put it onto the final stack
            finalStack.push(auxStack.pop());
         
            /*If this node has children, push its left child onto
              the auxiliary stack followed by its right child
             */
            Node<String> currentNode = finalStack.peek();
            if (currentNode.left != null) auxStack.push(currentNode.left);
            if (currentNode.right != null) auxStack.push(currentNode.right);
            
        }
 
        //Remove and print the nodes from the finalStack
        while (finalStack.isEmpty() != true) {
        	
            Node<String> currentNode = finalStack.pop();
            System.out.print(currentNode.data + " ");
            
        }
        
        System.out.println();
        System.out.println();
		
	}
	
	//Function for printing the byLevel traversal
	void printByLevel(Node<String> root) {
		
		//Return if tree is empty
        if (root == null) return;
         
        //A queue for adding/removing all nodes of a given level
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        
        //Traverse iteratively by level. Break when the queue is empty
        while (true) {
             
            //currentLevelNodeCount is the number of nodes on this current level
        		int currentLevelNodeCount = queue.size();
            if (currentLevelNodeCount == 0) break;
            System.out.print("Level " + currentLevel + " : ");
             
            /*Iteratively print and remove all nodes on the current level while adding the 
              next level nodes to the queue. Then decrement currentLevelNodeCount */
            while (currentLevelNodeCount > 0) {
            	
                Node<String> currentNode = queue.peek();
                System.out.print(currentNode.data + " ");
                queue.remove();
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
                currentLevelNodeCount--;
                
            }
            
            System.out.println();
            currentLevel++;
            
        }
        
        System.out.println();
        System.out.println();
        
	}

}
