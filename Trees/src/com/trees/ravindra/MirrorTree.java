package com.trees.ravindra;

public class MirrorTree {

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
        
       preOrder(mirrorTree(tree));

	}
	
	public static Node mirrorTree(Node node){
		
		if(node==null  || (node.left==null && node.right==null)){
			return null;
		}
		
		Node left = mirrorTree(node.left);
		Node right = mirrorTree(node.right);
		
		
		Node temp = left;
		left = right;
		right = temp;
		
		return node;
	}
	
public static void preOrder(Node node){
		
		if(node!=null){
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
		}
	}

}
