package com.trees.ravindra;

import java.util.ArrayList;

public class PrintKdistanceFromLeaf {

	public static void main(String[] args) {
		
		
		
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        //list.add(0);
        boolean[] visited = new boolean[1000];
        printKDistanceFromLeaf(root,list,0,2,visited);
	}
	
	public static void printKDistanceFromLeaf(Node node ,ArrayList<Integer> list, int level,int k,boolean[] visited){
		
		if(node==null){
			return;
		}
		
		list.add(level,node.data);
		visited[level] =false;
		if(node.left==null && node.right==null && !visited[level-k]){
			System.out.println("Element: "+ list.get(level-k));
			visited[level-k] =true;
		}
		
		printKDistanceFromLeaf(node.left,list,level+1,k,visited);
		printKDistanceFromLeaf(node.right,list,level+1,k,visited);
	}

}
