package com.trees.ravindra;

public class LeftView {
	
	static class MaxLevel
	{
		int max;
		
		public MaxLevel(int max){
			this.max=max;
		}
	}
	public static void main(String[] args) {

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
		MaxLevel max= new MaxLevel(0);
		leftViewOfABinaryTree(tree,max,1);
	
	}
	
	public static void leftViewOfABinaryTree(Node node, MaxLevel  max, int level){
		if(node==null){
			return;
		}
		if(level>max.max){
			System.out.println(node.data);
			max.max=level;
		}
		
		leftViewOfABinaryTree(node.left,max,level+1);
		leftViewOfABinaryTree(node.right,max,level+1);
	}

}
