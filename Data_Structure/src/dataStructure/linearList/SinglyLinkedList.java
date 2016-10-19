package dataStructure.linearList;

import java.util.Iterator;

import dataStructure.LList;

public class SinglyLinkedList<E> extends AbstractList<E> implements LList<E> {

	protected Node<E>head;
	
	
	public SinglyLinkedList() {
		this.head = null;
	}
	public SinglyLinkedList(Node<E>head) {
		this.head = head;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head == null;
	}

	@Override
	public int length() {
		int i = 0;
		Node<E>p = this.head;
		while (p!=null) {
			i++;
			p = p.next;
			
		}
		return i;
	}

	@Override
	public E get(int index) {
		if(this.head!=null && index >= 0){
			int j = 0;
			Node<E>p = this.head;
			while(p!=null&&j<index){
				j++;
				p = p.next;
			}
			if(p!=null){
				return (E)p.data;
			}
		}
		return null;
	}

	@Override
	public E set(int index, E element) {
		if(this.head!=null && index >=0 &&element !=null){
			int j = 0;
			Node<E>p = this.head;
			while(p != null && j<index){
				j++;
				p = p.next;
			}
			if(p!=null){
				E old = (E)p.data;
				p.data = element;
				return old;
			}
		}
		return null;
	}

	@Override
	public boolean add(int index, E element) {
		if(element == null){
			return false;
		}
		if(this.head == null || index <= 0){
			Node<E>q = new Node<>(element);
			q.next = this.head;
			this.head = q;
//			this.head = new Node<>(element, this.head);
		}else{
			int j = 0;
			Node<E> p = this.head;
			while(p.next!=null&&j<index-1){
				j++;
				p = p.next;
			}
			Node<E>q = new Node<>(element);
			q.next = p.next;
			p.next = q;
//			p.next = new Node<>(element, p.next);
			
		}
		return true;
	}

	@Override
	public boolean add(E element) {
		// TODO Auto-generated method stub
		return add(Integer.MAX_VALUE, element);
	}

	@Override
	public E remove(int index) {
		E old = null;
		if(this.head!=null&&index>=0){
			if(index==0){
				old = (E)this.head.data;
				this.head = this.head.next;
			}else{
				int j = 0;
				Node<E> p = this.head;
				while(p.next!=null&&j<index-1){
					j++;
					p = p.next;
				}
				if(p.next!=null){
					old = (E)p.next.data;
					p.next = (p.next).next;
				}
			}
		}
		return old;
	}

	@Override
	public void clear() {
		this.head = null;
		
	}
	public String toString(){
		String str = "(";
		Node<E>p = this.head;
		while(p!=null){
			str+=p.data.toString();
			p = p.next;
			if(p!=null){
				str+=",";
			}
		}
		return str + ")";
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Itr();
	}
	private class Itr implements Iterator<E>{

		private Node<E>cursor = head;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor!=null&&cursor.next!=null;
		}

		@Override
		public E next() {
			if(cursor!=null&&cursor.next!=null){
				E element = cursor.next.data;
				cursor = cursor.next;
				return element;
			}
			return null;
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	public Node<E> search(E element, Node<E>start){
		if(this.head == null || element ==null){
			return null;
		}
		Node<E>p = start;
		while (p!=null&&!element.equals(p.data)) {
			p = p.next;
		}
		return p;
	}
	public Node<E> search(E element){
		return search(element, this.head);
	}
	public boolean contain(E element){
		return this.search(element)!=null;
	}
	
	public boolean remove(E element){
		
		if(this.head == null || element ==null){
			return false;
		}
		if(element.equals(this.head.data)){
			this.head = this.head.next;
			return true;
		}
		Node<E>front = this.head;
		Node<E>p = this.head.next;
		while (p!=null&&!element.equals(p.data)) {
			front =p;
			p = p.next;
		}
		if(p!=null){
			front.next = p.next;
			return true;
		}
		return false;
		
	}

}
