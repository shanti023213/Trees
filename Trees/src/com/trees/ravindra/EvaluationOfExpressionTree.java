package com.trees.ravindra;


class ExpressionNode {
	int data;
	char expression;
	ExpressionNode left,right;
	
	public ExpressionNode(int data){
		this.data = data;
	}
	
	public ExpressionNode(char expression){
		this.expression = expression;
	}
}

public class EvaluationOfExpressionTree {

	public static void main(String[] args) {
		ExpressionNode node = new ExpressionNode('+');
		node.left=new ExpressionNode('/');
		node.right=new ExpressionNode('-');
		
		node.left.left=new ExpressionNode('*');
		node.left.right=new ExpressionNode(5);
		
		node.left.left.left=new ExpressionNode(10);
		node.left.left.right=new ExpressionNode(2);
		
		
		node.right.left=new ExpressionNode(100);
		node.right.right=new ExpressionNode('*');
		
		node.right.right.left=new ExpressionNode(3);
		node.right.right.right=new ExpressionNode(30);
		
		int value = evaluateExpression(node);
		
		System.out.println("Value:"+ value);

	}
	
	public static int evaluateExpression(ExpressionNode node){
		if(node==null){
			return 0;
		}
		
		if(node.left==null && node.right==null){
			return node.data;
		}
		int leftValue =evaluateExpression(node.left);
		int rightValue =evaluateExpression(node.right);
		
		if(node.expression == '*'){
			return leftValue*rightValue;
		}	 
		
		if(node.expression == '/'){
			return leftValue/rightValue;
		}
		
		if(node.expression == '+'){
			return leftValue+rightValue;
		}
		
		if(node.expression == '-'){
			return leftValue-rightValue;
		}
		return 0;
	}

}
