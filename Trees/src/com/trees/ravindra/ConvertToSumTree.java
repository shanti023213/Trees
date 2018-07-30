package com.trees.ravindra;

public class ConvertToSumTree {
	
	
	public static void main(String[] args){
	  Node root = new Node(50);
      root.left = new Node(7);
      root.right = new Node(2);
      root.left.left = new Node(3);
      root.left.right = new Node(5);
      root.right.left = new Node(1);
      root.right.right = new Node(30);
      
      convertToSumTree(root);
      
      printInorder(root);
      
	}
	
	 public static void printInorder(Node node) 
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
	
	public static void convertToSumTree(Node node){
		
		int leftSum =0; int rightSum=0;
		if(node == null || (node.left==null && node.right==null)){
			return ;
		}
		
		
		convertToSumTree(node.left);
		convertToSumTree(node.right);
		
		if(node.left!=null){
		 leftSum = node.left.data;
		}
		
		if(node.right!=null){
			 rightSum = node.right.data;
		}
		
		int diff = leftSum+rightSum-node.data;
		if(diff>0){
			node.data = leftSum+rightSum;
		}else{
			increaseSum(node,-diff);
		}
	}
	
	public static void increaseSum(Node n, int diff){
		
		if(n.left!=null){
			n.left.data = n.left.data+diff;
			increaseSum(n.left,diff);
		}else if(n.right!=null){
			n.right.data = n.right.data+diff;
			increaseSum(n.right,diff);
		}
	}

}
