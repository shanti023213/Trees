package com.trees.ravindra;

public class Diameter {
	
	public static void main(String[] args){
		
		
		Diameter d = new Diameter();
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
	    
	    
        Node tree1 = new Node(1);
        tree1.left = new Node(2);
        tree1.right = new Node(3);
        tree1.left.left = new Node(4);
        tree1.left.right = new Node(5);
        
	    //int[] result = diameterOfTree(tree);
	    //System.out.println(result[1]);
	    
	 
	    int result1 = d.diameterOpt(tree,d.new Height());
	    System.out.println(result1);
	   
	}
	
	
	class Height
	{
	    int h;
	}
	
	public static int[] diameterOfTree(Node node){
		
		int[] dh = new int[2];
		
		if(node==null){
			return new int[2];
		}
		
		int[] left = diameterOfTree(node.left); //0
		int[] right = diameterOfTree(node.right); //  1 
		dh[0] = 1+ Math.max(left[0], right[0]);
		
		int rootDia = left[0]+right[0];
		dh[1] = Math.max(Math.max(left[1], right[1]) ,rootDia);
	
		
		return dh;
	}
	
	  int diameterOpt(Node root, Height height)
	    {
	        /* lh --> Height of left subtree
	           rh --> Height of right subtree */
	        Height lh = new Height(), rh = new Height();
	 
	        if (root == null)
	        {
	            height.h = 0;
	            return 0; /* diameter is also 0 */
	        }
	         
	        /* ldiameter  --> diameter of left subtree
	           rdiameter  --> Diameter of right subtree */ 
	        /* Get the heights of left and right subtrees in lh and rh
	         And store the returned values in ldiameter and ldiameter */
	        //lh.h++;     rh.h++; 
	        int ldiameter = diameterOpt(root.left, lh);
	        int rdiameter = diameterOpt(root.right, rh);
	 
	        /* Height of current node is max of heights of left and
	         right subtrees plus 1*/
	        height.h = Math.max(lh.h, rh.h) + 1;
	 
	        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
	    }
}
