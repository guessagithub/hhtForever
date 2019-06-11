package com.hht.算法.二叉树.自己的;

import java.util.List;

public class MyBinaryTree<T extends Comparable<T>> {
	
	private MyBinaryNode<T> root;
	
	public class MyBinaryNode<T extends Comparable<T>> {
		private T value;
		private MyBinaryNode<T> left;
		private MyBinaryNode<T> right;
		
		MyBinaryNode(T value){
			this.value = value;
		}
	}
	
	public void insert(T value) {
		MyBinaryNode<T> node = new MyBinaryNode<T>(value);
		
		MyBinaryNode<T> nodex = root;
		MyBinaryNode<T> nodey = null;
		
		while(nodex != null) {
			nodey = nodex;
			int cmp = node.value.compareTo(nodex.value);
			if(cmp < 0) {
				nodex = nodex.left;
			}else {
				nodex = nodex.right;
			}
		}
		
		if(nodey == null) {
			root = node;
		}else {
			int cmp = node.value.compareTo(nodey.value);
			if(cmp < 0) {
				nodey.left = node;
			}else {
				nodey.right = node;
			}
		}
	}
	
	public void insert(List<T> list) {
		for(T val : list) {
			insert(val);
		}
	}
	
	/**
	 * 前序遍历二叉树
	 */
	public void prePrint() {
		prePrint(root);
	}
	
	private void prePrint(MyBinaryNode<T> node) {
		if(node != null) {
			System.out.print(node.value + " ");
			prePrint(node.left);
			prePrint(node.right);
		}
	}
	
	
	/**
	 * 中序遍历二叉树
	 */
	public void inPrint() {
		inPrint(root);
	}
	
	private void inPrint(MyBinaryNode<T> node) {
		if(node != null) {
			inPrint(node.left);
			System.out.print(node.value + " ");
			inPrint(node.right);
		}
	}
	
	
	/**
	 * 后序遍历二叉树
	 */
	public void postPrint() {
		postPrint(root);
	}
	
	private void postPrint(MyBinaryNode<T> node) {
		if(node != null) {
			postPrint(node.left);
			postPrint(node.right);
			System.out.print(node.value + " ");
		}
	}
	
	/**
	 * 获取最大值
	 */
	public T getMaxValue() {
		MyBinaryNode<T> node = getMaxNode(root);
		return node.value;
	}
	
	private MyBinaryNode<T> getMaxNode(MyBinaryNode<T> node) {
		if(node!=null && node.right!=null) {
			return getMaxNode(node.right);
		}
		return node;
	}
	
	/**
	 * 获取最小值
	 */
	public T getMixValue() {
		MyBinaryNode<T> node = getMixNode(root);
		return node.value;
	}
	
	private MyBinaryNode<T> getMixNode(MyBinaryNode<T> node){
		if(node!=null && node.left!=null) {
			return getMixNode(node.left);
		}
		return node;
	}
	
	
	
	
	
	
	

}
