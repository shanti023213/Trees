package com.trees.ravindra;

public class TreesEquality {

	static Node tree;
	static Node tree1;

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
      
    	tree1 = new Node(50);
        tree1.left = new Node(30);
        tree1.right = new Node(70);
        
        tree1.left.left = new Node(20);
        tree1.left.right = new Node(40);
  
        tree1.left.right.left = new Node(35);
        tree1.left.right.right = new Node(45);
        
        tree1.right.left = new Node(60);
        tree1.right.right = new Node(80);
        
        System.out.println("Is CompleteTree: "+ isEqual(tree,tree1));
   
	}
	
	public static boolean isEqual(Node n1, Node n2){
		
		if(n1==null && n2==null){
			return true;
		}
		
		if(n1==null || n2==null){
			return false;
		}
		
		if(n1.data==n2.data){
			
				return isEqual(n1.left,n2.left)&&isEqual(n1.right,n2.right);
			}
		
		return false;
	}
}
