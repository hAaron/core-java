package com.aaron.datastructure.tree.binarytree;

import java.util.Stack;

/**
 * 先序遍历：遍历顺序规则为【根左右】
 * 
 * 中序遍历：遍历顺序规则为【左根右】
 * 
 * 后序遍历：遍历顺序规则为【左右根】
 * 
 * 非递归方式
 * 
 * @author Aaron
 * @date 2019年12月10日
 * @version 1.0
 * @package_type com.aaron.datastructure.tree.binarytree.QueryBinaryTree
 */
public class QueryBinaryTreeByNonRecursive {

	/**
	 * 前序遍历
	 * 
	 * @param root
	 */
	public static void preOrderNonRecursive(BinaryTreeNode<String> root) {

		Stack<BinaryTreeNode<String>> stack = new Stack<BinaryTreeNode<String>>();
		while (true) {
			while (root != null) {
				System.out.print(root.getData() + " ");
				stack.push(root);
				root = root.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			root = root.getRight();
		}

	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public static void inOrderNonRecursive(BinaryTreeNode<String> root) {

		Stack<BinaryTreeNode<String>> stack = new Stack<BinaryTreeNode<String>>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			System.out.print(root.getData() + " ");
			root = root.getRight();
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public static void afterOrderNonRecursive(BinaryTreeNode<String> root) {
		Stack<BinaryTreeNode<String>> stack = new Stack<BinaryTreeNode<String>>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.isEmpty())
					return;

				if (null == stack.lastElement().getRight()) {
					root = stack.pop();
					System.out.print(root.getData() + " ");
					while (root == stack.lastElement().getRight()) {
						System.out.print(stack.lastElement().getData() + " ");
						root = stack.pop();
						if (stack.isEmpty()) {
							break;
						}
					}
				}

				if (!stack.isEmpty())
					root = stack.lastElement().getRight();
				else
					root = null;
			}
		}
	}

}
