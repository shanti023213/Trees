package com.trees.ravindra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class NodeElement{
	 Node node;
	 int position;
	 
	 public NodeElement(Node node, int position){
		 this.node= node;
		 this.position =position;
	 }
	
}
public class BottomView {

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
		bottomViewOfABinaryTree(tree);
	
	}
	
	public static void bottomViewOfABinaryTree(Node n){
		
		if(n==null){
			return;
		}
		
		Queue<NodeElement> queue = new LinkedList<NodeElement>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		queue.add(new NodeElement(n,0));
		while(!queue.isEmpty()){
			NodeElement node = queue.poll();
			map.put(node.position, node.node.data);
			
			if(node.node.left!=null){
				queue.add(new NodeElement(node.node.left , node.position-1));
			}
			
			if(node.node.right!=null){
				queue.add(new NodeElement(node.node.right , node.position+1));
			}
		}
		
		for(int key:map.keySet()){
			System.out.println(map.get(key));
		}
		
	}

}
