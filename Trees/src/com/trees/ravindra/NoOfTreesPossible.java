package com.trees.ravindra;

public class NoOfTreesPossible {

	public static void main(String[] args) {
		
	System.out.print(countTrees(5));
		

	}
	
	
	public static int countTrees(int n){
		int[] BT= new int[n+1];
		 BT[0] = BT[1] = 1;
		 
		    // Start finding from 2 nodes, since
		    // already know for 1 node.
		    for (int i = 2; i <= n; i++) 
		        for (int j = 0; j < i; j++)
		            BT[i] += BT[j] * BT[i - j - 1];
		 
		    return BT[n];
	}

}
