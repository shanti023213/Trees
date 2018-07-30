package com.trees.ravindra;

public class IsCompleteTree {

	static Node tree;

	public static void main(String[] args) {
		
		tree = new Node(50);
        tree.left = new Node(30);
        tree.right = new Node(70);
        
        tree.left.left = new Node(20);
        tree.left.right = new Node(40);
  
        tree.left.right.left = new Node(35);
        tree.left.right.right = new Node(45);
        
        tree.right.left = new Node(60);
        tree.right.right = new Node(80);
      
        System.out.println("Is CompleteTree: "+ isComplete(tree));
   
	}
	
	
	public static boolean isComplete(Node node){
		
		if(node == null){
			return true;
		}
		
		if(node.left==null && node.right==null){
			return true;
		}

		if(node.left==null || node.right==null){
			return false;
		}
		
		return isComplete(node.left) && isComplete(node.right);
		
	}
}
