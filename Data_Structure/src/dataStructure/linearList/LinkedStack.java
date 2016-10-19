package dataStructure.linearList;

public class LinkedStack<E> implements SStack<E>{

	private Node<E> top;
	
	public LinkedStack(){
		this.top = null;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.top == null;
	}

	@Override
	public boolean push(E element) {
		if(element == null){
			return false;
		}
		this.top = new Node(element, this.top);
		return true;
	}

	@Override
	public E pop() {
		if(!isEmpty()){
			E temp = this.top.data;
			this.top = this.top.next;
			return temp;
		}
		return null;
	}

	@Override
	public E get() {
		if(!isEmpty()){
			return this.top.data;
		}
		return null;
	}
	public String toString(){
		String str = "(";
		Node<E>p = this.top;
		while(p.next!=null){
			str += p.data + ", ";
			p = p.next;
		}
		str += p.data +")";
		return str;   
	}

}
