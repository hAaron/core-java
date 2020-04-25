package com.aaron.datastructure.tree.binarytree;

/**
 * 测试类
 * 
 * @author Aaron
 * @date 2019年12月10日
 * @version 1.0
 * @package_type com.aaron.datastructure.tree.binarytree.QueryBinaryTreeTest
 */
public class QueryBinaryTreeTest {

	public static void main(String[] args) {

		BinaryTreeNode<String> node9 = new BinaryTreeNode<String>("K", null, null);
		BinaryTreeNode<String> node8 = new BinaryTreeNode<String>("H", null, null);
		BinaryTreeNode<String> node7 = new BinaryTreeNode<String>("G", node8, node9);
		BinaryTreeNode<String> node6 = new BinaryTreeNode<String>("F", node7, null);
		BinaryTreeNode<String> node3 = new BinaryTreeNode<String>("E", null, node6);
		BinaryTreeNode<String> node5 = new BinaryTreeNode<String>("D", null, null);
		BinaryTreeNode<String> node4 = new BinaryTreeNode<String>("C", node5, null);
		BinaryTreeNode<String> node2 = new BinaryTreeNode<String>("B", null, node4);
		BinaryTreeNode<String> node1 = new BinaryTreeNode<String>("A", node2, node3);

		System.out.println("递归方式遍历二叉树");
		System.out.println("********前序遍历********");
		QueryBinaryTree.preOrder(node1);
		System.out.println("\n********中序遍历********");
		QueryBinaryTree.inOrder(node1);
		System.out.println("\n********后序遍历********");
		QueryBinaryTree.afterOrder(node1);

		System.out.println("\n\n非递归方式遍历二叉树");
		System.out.println("********前序遍历********");
		QueryBinaryTreeByNonRecursive.preOrderNonRecursive(node1);
		System.out.println("\n********中序遍历********");
		QueryBinaryTreeByNonRecursive.inOrderNonRecursive(node1);
		System.out.println("\n********后序遍历********");
		QueryBinaryTreeByNonRecursive.afterOrderNonRecursive(node1);
	}

}
