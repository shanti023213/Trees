package com.trees.ravindra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class ListNode{
	Node n;
	int position;
	
	public ListNode(Node n, int position){
		this.n=n;
		this.position =position;
	}
}

public class TopView {

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
		topViewOfABinaryTree(tree);
	

	}
	
	public static void topViewOfABinaryTree(Node node){
		
		if(node==null){
			return;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		Queue<ListNode> queue = new LinkedList<ListNode>();
		queue.add(new ListNode(node,0));
		
		while(!queue.isEmpty()){
			ListNode n = queue.poll();
			if(!set.contains(n.position)){
				System.out.println("Element:" + n.n.data);
				set.add(n.position);
			}
			
			if(n.n.left!=null){
				queue.add(new ListNode(n.n.left,n.position-1));
			}
			
			if(n.n.right!=null){
				queue.add(new ListNode(n.n.right,n.position+1));
			}
		}
		
	}

}
