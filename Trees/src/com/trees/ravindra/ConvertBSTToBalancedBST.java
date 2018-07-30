package com.trees.ravindra;

import java.util.ArrayList;

public class ConvertBSTToBalancedBST {

	public static void main(String[] args) {
		
		Node root = new Node(9);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.left.left = new Node(6);
        root.left.left.left.left = new Node(5);
        
        Node n = convertToBalancedBST(root);
        
        System.out.println("Here i am ");

	}
	
	
	public static Node convertToBalancedBST(Node node){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		inOrderTraversal(node,list);
		
		Node n = buildTree(list,0,list.size()-1);
		
		return n;
	}
	
	public static void inOrderTraversal(Node n, ArrayList<Integer> list){
		if(n==null){
			return;
		}
		inOrderTraversal(n.left,list);
		list.add(n.data);
		inOrderTraversal(n.right,list);
	}
	
	
	public static Node buildTree(ArrayList<Integer> list, int start, int end){
		if(start<=end){
		int mid = (start+end)/2;
		Node node = new Node(list.get(mid));
		node.left = buildTree(list,start,mid-1);
		node.right = buildTree(list,mid+1,end);
		return node;
		}
		return null;
	}

}
