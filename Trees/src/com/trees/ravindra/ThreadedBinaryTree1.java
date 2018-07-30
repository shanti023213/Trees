package com.trees.ravindra;

	import java.util.LinkedList;
	import java.util.Queue;
	  
	/* Class containing left and right child of current 
	 Node1 and key value*/
	class Node1 
	{
	    int data;
	    Node1 left, right;
	  
	    // Used to indicate whether the right pointer is a normal
	    // right pointer or a pointer to inorder successor.
	    boolean isThreaded;
	  
	    public Node1(int item) 
	    {
	        data = item;
	        left = right = null;
	    }
	}
	  
	class ThreadedBinaryTree1 
	{
	    Node1 root;
	   
	    // Helper function to put the Node1s in inorder into queue
	    void populateQueue(Node1 Node1, Queue<Node1> q) 
	    {
	        if (Node1 == null)
	            return;
	        if (Node1.left != null)
	            populateQueue(Node1.left, q);
	        q.add(Node1);
	        System.out.println(Node1.data);
	        if (Node1.right != null)
	            populateQueue(Node1.right, q);
	    }
	  
	    // Function to traverse queue, and make tree threaded
	    void createThreadedUtil(Node1 Node1, Queue<Node1> q) 
	    {
	        if (Node1 == null)
	            return;
	  
	        if (Node1.left != null) 
	            createThreadedUtil(Node1.left, q);        
	        q.remove();
	  
	        if (Node1.right != null) 
	            createThreadedUtil(Node1.right, q);        
	  
	        // If right pointer is NULL, link it to the
	        // inorder successor and set 'isThreaded' bit.
	        else
	        {
	            Node1.right = q.peek();
	            Node1.isThreaded = true;
	        }
	    }
	  
	    // This function uses populateQueue() and
	    // createThreadedUtil() to convert a given binary tree 
	    // to threaded tree.
	    void createThreaded(Node1 Node1) 
	    {
	        // Create a queue to store inorder traversal
	        Queue<Node1> q = new LinkedList<Node1>();
	  
	        // Store inorder traversal in queue
	        populateQueue(Node1, q);
	  
	        // Link NULL right pointers to inorder successor
	        createThreadedUtil(Node1, q);
	    }
	  
	    // A utility function to find leftmost Node1 in a binary
	    // tree rooted with 'root'. This function is used in inOrder()
	    Node1 leftMost(Node1 Node1) 
	    {
	        while (Node1 != null && Node1.left != null)
	            Node1 = Node1.left;
	        return Node1;
	    }
	  
	    // Function to do inorder traversal of a threadded binary tree
	    void inOrder(Node1 Node1) 
	    {
	        if (Node1 == null) 
	            return;        
	  
	        // Find the leftmost Node1 in Binary Tree
	        Node1 cur = leftMost(Node1);
	  
	        while (cur != null) 
	        {
	            System.out.print(" " + cur.data + " ");
	  
	            // If this Node1 is a thread Node1, then go to
	            // inorder successor
	            if (cur.isThreaded == true)
	                cur = cur.right;
	            else // Else go to the leftmost child in right subtree
	                cur = leftMost(cur.right);
	        }
	    }
	      
	    // Driver program to test for above functions
	    public static void main(String args[]) 
	    {
	    	ThreadedBinaryTree1 tree = new ThreadedBinaryTree1();
	        tree.root = new Node1(1);
	        tree.root.left = new Node1(2);
	        tree.root.right = new Node1(3);
	  
	        tree.root.left.left = new Node1(4);
	        tree.root.left.right = new Node1(5);
	        tree.root.right.left = new Node1(6);
	        tree.root.right.right = new Node1(7);
	  
	        tree.createThreaded(tree.root);
	        System.out.println("Inorder traversal of created threaded tree");
	        tree.inOrder(tree.root);
	    }
	}

