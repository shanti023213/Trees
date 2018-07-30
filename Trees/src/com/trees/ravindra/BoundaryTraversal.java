package com.trees.ravindra;

import java.util.ArrayList;

public class BoundaryTraversal {
	
	Node root;

	public static void main(String[] args) {
		BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);

	}

	public void printBoundary(Node node){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(node.data);
		leftBoundary(node.left, list);
		leavesView(node.left,list);
		leavesView(node.right,list);
		rightBoundary(node.right,list);
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	public static void leftBoundary(Node node, ArrayList<Integer> list){
		
		if(node!=null){
			
			if(node.left!=null){
				list.add(node.data);
				leftBoundary(node.left,list);
			}else if(node.right!=null){
				list.add(node.data);
				leftBoundary(node.right,list);
			}
		}
	}
	
	public static void leavesView(Node node, ArrayList<Integer> list){
		
		if(node!=null){
			
			leavesView(node.left,list);
			if(node.left ==null && node.right==null){
				list.add(node.data);
			}
			leavesView(node.right,list);
		}
	}
	
	public static void rightBoundary(Node node, ArrayList<Integer> list){

		if(node!=null){
			
			if(node.right!=null){
				
				rightBoundary(node.right,list);
				list.add(node.data);
			}else if(node.left!=null){
				list.add(node.data);
				rightBoundary(node.left,list);
			}
		}
	}
}
