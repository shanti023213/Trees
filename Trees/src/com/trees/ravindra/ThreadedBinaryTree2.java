package com.trees.ravindra;

class Node2{
    Node2 left;
    Node2 right;
    int data;
    boolean rightThread;
    public Node2(int data){
        this.data = data;
        rightThread = false;
    }
}
    
public class ThreadedBinaryTree2 {
	
	public static void main(String[] args) {
	    	
	    	Node2 root = new Node2(10);
	        root.left = new Node2(5);
	        root.right = new Node2(15);
	        root.left.left = new Node2(1);
	        root.left.right = new Node2(7);
	        root.right.left = new Node2(12);
	        root.right.right = new Node2(20);

	        ThreadedBinaryTree2 bsTtoTBST = new ThreadedBinaryTree2();
	        bsTtoTBST.convert(root);
	        System.out.println("Inorder Traversal: ");
	        bsTtoTBST.print(root);
	    }
	
	public void convert(Node2 root){
        inorder(root, null);
    }

    public void inorder(Node2 root, Node2 previous){
        if(root==null){
            return;
        }else{
            inorder(root.right, previous);
            if(root.right==null &&  previous!=null){
                root.right = previous;
                root.rightThread=true;
            }
            inorder(root.left, root);
        }
    }

    public void print(Node2 root){
        //first go to most left node
        Node2 current = leftMostNode2(root);
        //now travel using right pointers
        while(current!=null){
            System.out.print(" " + current.data);
            //check if node has a right thread
            if(current.rightThread)
                current = current.right;
            else // else go to left most node in the right subtree
                current = leftMostNode2(current.right);
        }
        System.out.println();
    }

    public Node2 leftMostNode2(Node2 node){
        if(node==null){
            return null;
        }else{
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }
    }

}


