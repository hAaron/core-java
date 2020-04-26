package com.aaron.datastructure.tree.binarytree;

/**
 * 二叉树节点
 * 
 * @author Aaron
 * @date 2019年12月9日
 * @version 1.0
 * @package_type com.aaron.datastructure.tree.binarytree.BinaryTreeNode
 */
public class BinaryTreeNode<T> {
	/**
	 * 根节点
	 */
	private T data;
	/**
	 * 左子树
	 */
	private BinaryTreeNode<T> left;
	/**
	 * 右子树
	 */
	private BinaryTreeNode<T> right;

	public BinaryTreeNode() {
	}

	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}
