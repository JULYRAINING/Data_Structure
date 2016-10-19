package dataStructure.tree;

import dataStructure.linearList.LinkedQueue;
import dataStructure.linearList.LinkedStack;

public class BinaryTree<E> {
	protected BinaryNode<E> root;
	
	public BinaryTree(){
		root = null;
	}
	public BinaryTree(BinaryNode<E> root){
		this.root = root;
	}
	/**
	 * 以表明空子树的先根序列构造一棵二叉树
	 * @param preorder
	 */
	public BinaryTree(E[] preorder){
		root = create(preorder);
	}
	
	
	private int i = 0;
	private BinaryNode<E> create(E[] preorder) {
		BinaryNode<E>p = null;
		if(i<preorder.length){
			E elem = preorder[i];
			i++;
			if(elem != null){
				p = new BinaryNode<E>(elem);
				p.left = create(preorder);
				p.right = create(preorder);
			}
		}
		return p;
	}
	
	
	/**
	 * 将element元素座位p结点的孩子结点插入在二叉树中，p原来的孩子成为新结点的孩子，默认左子树
	 * @return
	 */
	public void insert(BinaryNode<E>p, E element){
		insert(p, element, true);
	}
	public void insert(BinaryNode<E>p, E element, boolean leftChild){
		if(p!=null){
			if(leftChild){
				p.left = new BinaryNode<E>(element, p.left, null);
			}else{
				p.right = new BinaryNode<E>(element, null, p.right);
			}
		}
	}
	
	/**
	 * 删除指定结点的子树，默认左子树
	 * @return
	 */
	public void remove(BinaryNode<E>p){
		remove(p, true);
	}
	public void remove(BinaryNode<E>p, boolean leftChild){
		if(p!=null){
			if(leftChild){
				p.left = null;
			}else{
				p.right = null;
			}
		}
	}
	
	
	
	
	public boolean isEmpty(){
		return this.root == null;
		
	}
	public BinaryNode<E> getRoot(){
		return this.root;
	}
	/**
	 * 层次遍历
	 */
	public void levelOrder(){
		LinkedQueue<BinaryNode<E>>que = new LinkedQueue<>();
		BinaryNode<E>p = this.root;
		System.out.println("层次遍历：");
		while(p!=null){
			System.out.println(p.data);
			if(p.left!=null){
				que.enqueue(p.left);
			}
			if(p.right!=null){
				que.enqueue(p.right);
			}
			p = que.dequeue(); 
		}
	}
	/*
	 * 先根遍歷
	 */
	public void preOrder(){
		System.out.println("\n先根遍歷：");
		preOrder(root);
	}
	private void preOrder(BinaryNode<E> p) {
		if(p != null){
			System.out.print(p.data + "");
			preOrder(p.left);
			preOrder(p.right);
		}
		
	}
	/**
	 * 先序遍历的非递归算法
	 */
	public void preOrderTraverse(){
		System.out.println("\n先根遍历（非递归）：");
		LinkedStack<BinaryNode<E>>stack = new LinkedStack<>();
		BinaryNode<E>p = this.root;
		while(p!=null||!stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				System.out.print(p.data);
				p = p.left;
				
			}else{
				p = stack.pop();
				
				p = p.right;
			}
			
		}
	}
	/*
	 * 中根遍歷
	 */
	public void inOrder(){
		System.out.println("\n中根遍歷：");
		inOrder(root);
	}
	private void inOrder(BinaryNode<E> p) {
		if(p != null){
			
			inOrder(p.left);
			System.out.print(p.data + "");
			inOrder(p.right);
		}
		
	}
	/**
	 * 中序遍历的非递归算法
	 */
	public void inOrderTraverse(){
		System.out.println("\n中根遍历（非递归）：");
		LinkedStack<BinaryNode<E>>stack = new LinkedStack<>();
		BinaryNode<E>p = this.root;
		while(p!=null||!stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				System.out.print(p.data);
				p = p.right;
			}
			
		}
	}
	/*
	 * 后根遍歷
	 */
	public void postOrder(){
		System.out.println("\n后根遍歷：");
		postOrder(root);
	}
	private void postOrder(BinaryNode<E> p) {
		if(p != null){
			
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data + "");
		}
		
	}
	/**
	 * 求節點個數
	 * @return
	 */
	public int count(){
		return count(root);
	}
	private int count(BinaryNode<E>p){
		if(p!=null){
			return 1 + count(p.left) + count(p.right);
		}else{
			return 0;
		}
	}
	/**
	 * 求高度
	 * @return
	 */
	public int height(){
		return height(root);
	}
	private int height(BinaryNode<E> p) {
		if(p!=null){
			int ld = height(p.left);
			int rd = height(p.right);
			return (ld>rd)?ld+1:rd+1;
		}
		return 0;
	}
	/**
	 * 查找節點
	 * @param value
	 * @return
	 */
	public BinaryNode<E> search(E value){
		return search(root, value);
	}
	private BinaryNode<E> search(BinaryNode<E> p, E value) {
		BinaryNode<E> find = null;
		if(p!=null&&value!=null){
			if(p.data.equals(value)){
				find = p;
			}else{
				find = search(p.left, value);
				if(find == null){
					find = search(p.right, value);
				}
			}
		}
		return find;
	}
	
	/**
	 * 获得父母结点
	 */
	public BinaryNode<E>getParent(BinaryNode<E>node){
		if(root == null || node == null ||root == node){
			return null;
		}
		return getParent(root, node);
	}
	private BinaryNode<E> getParent(BinaryNode<E> p, BinaryNode<E> node) {
		BinaryNode<E>find = null;
		if(p != null){
			if(p.left == node ||p.right == node){
				find = p;
			}else{
				find = getParent(p.left, node);
				if(find == null){
					find = getParent(p.right, node);
				}
			}
		}
		return find;
	}
}
