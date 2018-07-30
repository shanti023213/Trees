package com.trees.ravindra;

public class BSTFromSortedArray {

	public static void main(String[] args) {

		//int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
		int arr[] = new int[]{10, 20, 30, 40, 50};
		
		Node n = binarySearchTree(arr, 0, arr.length-1);

		System.out.println("Node");
	}
	
	
	public static Node binarySearchTree(int[] arr ,int start , int end){
		
		if(start<=end){
			int mid = (start+end)/2;
		
			Node node = new Node(arr[mid]);
			
			node.left = binarySearchTree(arr, start, mid-1);
			node.right = binarySearchTree(arr, mid+1, end);
			
		return node;
		}
		return null;
}
}