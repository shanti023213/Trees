package com.trees.ravindra;


/* Structure of a node in threaded binary tree */
class Node3
{
    int key;
    Node3 left, right;
 
    // Used to indicate whether the right pointer
    // is a normal right pointer or a pointer
    // to inorder successor.
    boolean isThreaded;
    
    public Node3(int key){
    	this.left = this.right = null;
        this.key = key;
    }
};

public class ThreadedBinaryTree3 {
	

 
// Converts tree with given root to threaded
// binary tree.
// This function returns rightmost child of
// root.
public static Node3 createThreaded(Node3 root)
{
    // Base cases : Tree is empty or has single
    //              node
    if (root == null)
        return null;
    if (root.left == null &&
        root.right == null)
        return root;
 
    // Find predecessor if it exists
    if (root.left != null)
    {
        // Find predecessor of root (Rightmost
        // child in left subtree)
        Node3 l = createThreaded(root.left);
 
        // Link a thread from predecessor to
        // root.
        l.right = root;
        l.isThreaded = true;
    }
 
    // If current node is rightmost child
    if (root.right == null)
        return root;
 
    // Recur for right subtree.
    return createThreaded(root.right);
}
 
// A utility function to find leftmost node
// in a binary tree rooted with 'root'.
// This function is used in inOrder()
public static Node3 leftMost(Node3 root)
{
    while (root != null && root.left != null)
        root = root.left;
    return root;
}
 
// Function to do inorder traversal of a threadded
// binary tree
public static void inOrder(Node3 root)
{
    if (root == null) return;
 
    // Find the leftmost node in Binary Tree
    Node3 cur = leftMost(root);
 
    while (cur != null)
    {
       System.out.println(cur.key);
 
        // If this Node is a thread Node, then go to
        // inorder successor
        if (cur.isThreaded)
            cur = cur.right;
 
        else // Else go to the leftmost child in right subtree
            cur = leftMost(cur.right);
    }
}
 

 
// Driver program to test above functions
public static void main(String[] args) {
	
	 
    /*       1
            / \
           2   3
          / \ / \
         4  5 6  7   */
    Node3 root = new Node3(1);
    root.left = new Node3(2);
    root.right = new Node3(3);
    root.left.left = new Node3(4);
    root.left.right = new Node3(5);
    root.right.left = new Node3(6);
    root.right.right = new Node3(7);
    
    root.left.left.right = new Node3(8);
    root.left.left.right.left = new Node3(9);
    root.left.left.right.right = new Node3(10);
    root.left.left.right.right.left = new Node3(11);
    
 
    createThreaded(root);
 
    System.out.println("Inorder traversal of creeated threaded tree is");
    inOrder(root);
  
}

}
