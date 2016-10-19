package dataStructure.linearList;

import java.util.Iterator;

import dataStructure.LList;
/**
 * 带头结点的单链表
 * @author TF
 *
 * @param <E>
 */
public class HSLinkedList<E> implements LList<E> {

	protected Node<E>head;
	protected Node<E>rear;
	protected int n;
	
	public HSLinkedList(){
		this.head = new Node<E>(null);
		this.rear = this.head;
		this.n = 0;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.head.next == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return this.n;
	}

	@Override
	public E get(int index) {
		if(this.head!=null && index >= 0){
			int j = 0;
			Node<E>p = this.head;
			while(p.next!=null&&j<index){
				j++;
				p = p.next;
			}
			if(p.next!=null){
				return (E)p.next.data;
			}
		}
		return null;
	}

	@Override
	public E set(int index, E element) {
		if(this.head!=null && index >=0 &&element !=null){
			int j = 0;
			Node<E>p = this.head;
			while(p.next != null && j<index){
				j++;
				p = p.next;
			}
			if(p.next!=null){
				E old = (E)p.next.data;
				p.next.data = element;
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
		if(index > this.n){
			return this.add(element);
		}else{
			int j = 0;
			Node<E>p = this.head;
			while(p.next!=null&&j<index){
				j++;
				p = p.next;
			}
			Node<E>q = new Node(element, p.next);
			p.next = q;
			this.n++;
			return true;
		}
		
	}

	@Override
	public boolean add(E element) {
		if(element == null){
			return false;
		}
		this.rear.next = new Node(element);
		this.rear = this.rear.next;
		this.n++;
		return true;
	}

	@Override
	public E remove(int index) {
		E old = null;
		if(index >= 0){
			int j = 0;
			Node<E>p = this.head;
			while(p.next!=null&&j<index){
				j++;
				p = p.next;
			}
			if(p.next!=null){
				old = (E)p.next.data;
				if(p.next == this.rear){
					this.rear = p;
				}
				p.next = p.next.next;
				this.n--;
			}
		}
		return old;
	}

	@Override
	public void clear() {
		this.head.next = null;
		this.rear = this.head;
		this.n = 0;

	}
	public String toString(){
		String str = "(";
		Node<E>p = this.head.next;
		while(p!=null){
			str+=p.data.toString();
			p = p.next;
			if(p!=null){
				str+=",";
			}
		}
		return str + ")";
	}
	
	
	
}
