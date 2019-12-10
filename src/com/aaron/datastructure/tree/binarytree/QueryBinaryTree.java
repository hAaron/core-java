package com.aaron.datastructure.tree.binarytree;

/**
 * 先序遍历：遍历顺序规则为【根左右】
 * 
 * 中序遍历：遍历顺序规则为【左根右】
 * 
 * 后序遍历：遍历顺序规则为【左右根】
 * 
 * 递归方式
 * 
 * @author Aaron
 * @date 2019年12月10日
 * @version 1.0
 * @package_type com.aaron.datastructure.tree.binarytree.QueryBinaryTree
 */
public class QueryBinaryTree {

	/**
	 * 前序遍历--递归方式
	 * 
	 * @param root
	 */
	public static void preOrder(BinaryTreeNode<String> root) {

		if (root != null) {
			System.out.print(root.getData() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	/**
	 * 中序遍历--递归方式
	 * 
	 * @param root
	 */
	public static void inOrder(BinaryTreeNode<String> root) {

		if (root != null) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrder(root.getRight());
		}
	}

	/**
	 * 后序遍历--递归方式
	 * 
	 * @param root
	 */
	public static void afterOrder(BinaryTreeNode<String> root) {
		if (root != null) {
			afterOrder(root.getLeft());
			afterOrder(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}

}
