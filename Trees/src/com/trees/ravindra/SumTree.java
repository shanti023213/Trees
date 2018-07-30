package com.trees.ravindra;

public class SumTree {

	public static void main(String[] args) {
		

		
        Node root = new Node(26);
        root.left = new Node(13);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        int sum = sumTree(root);
        if(sum==-1){
        	 System.out.println("Not a sum tree");
        }else{
        	 System.out.println("sum Tree");
        }
       
	}
	
	
	public static int sumTree(Node node){
		if(node==null){
			return 0;
		}
		
		if(node.left ==null && node.right==null){
			return node.data;
		}
		int leftSum = sumTree(node.left);
		int rightSum = sumTree(node.right);
		
		if(leftSum +rightSum != node.data){
			return -1;
		}
		return 2*node.data;
	}

}
