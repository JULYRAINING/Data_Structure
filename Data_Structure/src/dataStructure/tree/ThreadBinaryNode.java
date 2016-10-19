package dataStructure.tree;

public class ThreadBinaryNode<E> {
	public E data;
	public ThreadBinaryNode<E>left, right;
	public int ltag, rtag;
	
	public ThreadBinaryNode(E data, ThreadBinaryNode<E> left, ThreadBinaryNode<E> right){
		this.data = data;
		this.left = left;
		this.right = right;
		this.ltag = this.rtag = 0;
	}
	
	public ThreadBinaryNode(E data){
		this(data, null, null);
	}
	public ThreadBinaryNode(){
		this(null, null, null);
	}
}
