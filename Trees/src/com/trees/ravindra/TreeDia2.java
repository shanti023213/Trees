package com.trees.ravindra;

//A utility class to pass heigh object
	class Height
	{
	    int h;
	}
	 

public class TreeDia2 {
	
	public static int diameterOpt(Node node, Height height){
		
		Height lh = new Height(); Height rh = new Height();
		if(node==null){
			return 0;
		}
	
		int leftDia = diameterOpt(node.left,lh);
		int rightDia = diameterOpt(node.right, rh);
	
		height.h = 1+ Math.max(lh.h, rh.h);
		int rootDia = lh.h+rh.h;
		
		return Math.max(Math.max(leftDia, rightDia),rootDia);
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
	                           + diameterOpt(tree, new Height()));
	    }
	}


