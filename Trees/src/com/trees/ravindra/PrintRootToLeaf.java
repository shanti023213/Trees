package com.trees.ravindra;

import java.util.ArrayList;

public class PrintRootToLeaf {

	public static void main(String[] args) {
		Node tree = new Node(0);
	    tree.left = new Node(1);
	    tree.right = new Node(2);
	    
	    tree.left.left = new Node(3);
	    tree.left.right = new Node(4);
	    
	    tree.left.left.left = new Node(7);
	    tree.left.left.right = new Node(8);
	    
	 
	    tree.left.right.left = new Node(9);
	    tree.left.right.right = new Node(10);
	    
	    tree.right.left = new Node(5);
	    tree.right.right = new Node(6);
	    
	    tree.right.left.left =new Node(11);
	    tree.right.left.right =new Node(12);
	    
	    tree.right.right.right = new Node(13);
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    printRootToLeaf(tree,list,0);

	}

	public static void printRootToLeaf(Node n, ArrayList<Integer> list, int level){
		
		if(n==null){
			return;
		}
	
		list.add(level, n.data);
		if(n.left==null && n.right==null){
			printListUntilLevel(list,level);
		}
	
		printRootToLeaf(n.left,list,level+1);
		printRootToLeaf(n.right,list,level+1);
		
	}
	
	public static void printListUntilLevel(ArrayList<Integer> list , int level){
		
		for(int i=0;i<=level;i++){
			System.out.println("Elements: "+ list.get(i));
		}
	}
}
