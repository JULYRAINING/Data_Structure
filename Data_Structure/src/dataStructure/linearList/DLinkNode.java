package dataStructure.linearList;

public class DLinkNode<E> {
	public E data;
	public DLinkNode<E>prev, next;
	
	public DLinkNode(E data, DLinkNode<E>prev, DLinkNode<E>next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public DLinkNode(E data){
		this(data, null, null);
	}
	public DLinkNode(){
		this(null, null, null);
	}
}
