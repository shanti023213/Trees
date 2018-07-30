package com.trees.ravindra;

public class NodesKDistanceFromGivenNode {
	
	  Node root;
	
	  public int printkdistanceNode(Node node, Node targetNode, int distance){
		  
		  if(node == null){
			  return -1;
		  }
		  
		  if(node.data == targetNode.data){
			  printBottomNodesAtKDistance(node, distance);
			  return 0;
		  }
		  
		  int dl = printkdistanceNode(node.left,targetNode,distance);
		  
		  if(dl!=-1){
			  
			  if(dl == distance-1){
				  System.out.println(node.data);
			  }else{
				  printBottomNodesAtKDistance(node.right,distance-dl-2);
			  }
			  
			  return dl+1;
		  }
		  int dr = printkdistanceNode(node.right,targetNode,distance);
		  
		  if(dr!=-1){
			  
			  if(dr == distance-1){
				  System.out.println(node.data);
			  }else{
				  printBottomNodesAtKDistance(node.left,distance-dr-2);
			  }
			  
			  return dr+1;
		  }
		  
		  return -1;
		  
	  }
	  
	  public static void printBottomNodesAtKDistance(Node node, int distance){
		  
		  if(node==null){
			  return;
		  }
		  
		  if(distance==0){
			  System.out.println(node.data);
			  return;
		  }
		  
		  printBottomNodesAtKDistance(node.left,distance-1);
		  printBottomNodesAtKDistance(node.right,distance-1);
	  }
	  
	  
	    // Driver program to test the above functions
	    public static void main(String args[]) 
	    {
	    	NodesKDistanceFromGivenNode tree = new NodesKDistanceFromGivenNode();
	  
	        /* Let us construct the tree shown in above diagram */
	        tree.root = new Node(0);
	        tree.root.left = new Node(1);
	        tree.root.right = new Node(2);
	        
	        tree.root.left.left = new Node(3);
	       // tree.root.left.right = new Node(12);
	        tree.root.left.left.left = new Node(7);
	        tree.root.left.left.right = new Node(8);
	        
	        tree.root.right.right=new Node(6);
	        tree.root.right.left = new Node(5);
	        
	        tree.root.right.left.right = new Node(12);
	        tree.root.right.left.left = new Node(11);
	        
	        tree.root.right.left.left.right = new Node(16);
	        tree.root.right.left.left.left = new Node(15);
	        
	        tree.root.right.left.left.left.left = new Node(17);
	        tree.root.right.left.left.left.right = new Node(18);
	        
	        Node target = tree.root.right.left;
	        tree.printkdistanceNode(tree.root, target, 3);
	    }
	}
	  
	// This code has been contributed by Mayank Jaiswal


