package com.trees.ravindra;

public class LevelOfNode {

	public static int LevelOfGivenNode(Node node, int key){
		if(node==null){
			return 0;
		}else{
			return levelUtils(node,key,1);
		}
	}

	
	public static int levelUtils(Node node, int key, int level){
		
		if(node == null){
			return 0;
		}
		
		if(node.data == key){
			return level;
		}
		int result = levelUtils(node.left,key,level+1);
		if(result!=0){
			return result;
		}
		result = levelUtils(node.right,key,level+1);
		if(result!=0){
			return result;
		}
		
		return 0;
	}
	public static void main(String args[])
    {
        Node tree = new Node(0);
		
	    tree.left = new Node(1);
	    tree.right = new Node(2);
	    
	    tree.left.left = new Node(3);
	    tree.left.right = new Node(4);
	    
	    tree.left.left.left = new Node(7);
	    tree.left.left.left.right = new Node(8);
	    
	    tree.left.right.left = new Node(14);
	    tree.left.right.right = new Node(24);
	    
	    tree.left.right.left.left = new Node(34);
	    
        System.out.println("The diameter of given binary tree is : "
                           + LevelOfGivenNode(tree, 8));
    }
}
