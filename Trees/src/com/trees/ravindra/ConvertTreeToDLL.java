package com.trees.ravindra;

public class ConvertTreeToDLL {
	
	// Convert tree to Linkedlist - order is inorder
	public static void main(String[] args){
	
	/*Node tree = new Node(0);
    tree.left = new Node(1);
    tree.right = new Node(2);
    
    tree.left.left = new Node(3);
    tree.left.right = new Node(4);
    
    tree.left.left.left = new Node(7);
    tree.left.left.right = new Node(8);
    
 
    tree.left.right.left = new Node(9);
    tree.left.right.right = new Node(10);
    
    tree.right.left = new Node(5);
    tree.right.right = new Node(6);
    
    tree.right.left.left =new Node(11);
    tree.right.left.right =new Node(12);
    
    tree.right.right.right = new Node(13);*/
		
    Node tree = new Node(1);
    tree.left = new Node(2);
    tree.right = new Node(3);
    tree.left.left = new Node(4);
    tree.left.right = new Node(5);
    tree.right.left = new Node(6);
    tree.right.right = new Node(7);
    tree.left.left.left = new Node(8);
    tree.left.left.right = new Node(9);
    tree.left.left.left.right = new Node(10);
    tree.left.left.left.right.left = new Node(11);
    
    Node head = convertTreeToLinkedList(tree);
    
    while(head.left!=null){
    	head =head.left;
    }
    
    while(head!=null){
    	System.out.println(head.data);
    	head = head.right;
    }
   // System.out.println(head.data);
	}
	
	public static Node convertTreeToLinkedList(Node node){
		
		if(node ==null){
			return null;
		}
	
		
		Node left = convertTreeToLinkedList(node.left);
		
		if(left!=null){
			
			while(left.right!=null){
				left =left.right;
			}
			left.right =node;
			node.left= left;
		}
		
		Node right = convertTreeToLinkedList(node.right);
		
		
		if(right!=null){
			
			while(right.left!=null){
				right =right.left;
			}
			right.left =node;
			node.right =right;
		}
		
		return node;
	}
}
