package com.trees.ravindra;

public class LeastCommonAncestor {

	public static void main(String[] args) {
		 
		Node tree = new Node(50);
        tree.left = new Node(30);
        tree.right = new Node(70);
        
        tree.left.left = new Node(20);
        tree.left.right = new Node(40);
  
        tree.left.right.left = new Node(35);
        tree.left.right.right = new Node(45);
        
        tree.right.left = new Node(60);
        tree.right.right = new Node(80);
        
        tree.right.left.left = new Node(90);
        tree.right.left.right = new Node(10);
        
        tree.right.left.left.left = new Node(2);
        tree.right.left.left.right = new Node(5);
        
        System.out.println(LCA(tree,2,90).data);
	}
	
	public static Node LCA(Node n, int p, int q){
		
		if(n==null){
			return n;
		}
		
		if(n.data == p || n.data ==q)
		{
			return n;
		}
		Node left = LCA(n.left ,p,q);
		Node right = LCA(n.right ,p,q);
	
		if(left!=null &&right!=null)
			return n;
		else
			return (left!=null)?left:right;
	}

}
