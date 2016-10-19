package dataStructure.linearList;

import dataStructure.LList;

public class CHDoublyLinkedList<E> implements LList<E>{

	protected DLinkNode<E> head;
	
	protected int n;
	
	public CHDoublyLinkedList(){
		this.head = new DLinkNode<E>(null);
		this.head.prev = head;
		this.head.next = head;
		
		
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next == head;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public E get(int index) {
		E old = null;
		if(this.head!=null&&index >= 0&&index<this.n){
			int j = 0;
			DLinkNode<E>p = this.head;
			while(p.next!=null&&j<index){
				j++;
				p = p.next;
			}
			if(p.next!=null){
				old = p.next.data;
				return old;
			}		
		}
		return null;
	}

	@Override
	public E set(int index, E element) {
		E old  = null;
		if(this.head!=null&&index>=0 &&element!=null){
			int j = 0;
			DLinkNode<E>p = this.head;
			while(p.next!=null&&j<index){
				j++;
				p = p.next;
			}
			if(p.next!=null){
				old = p.next.data;
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
		
			int j = 0;
			DLinkNode<E>p = this.head;
			while(p.next!=null&&j<index){
				j++;
				p = p.next;
			}
			
			DLinkNode<E>q = new DLinkNode<E>(element);
			if(j == 0){
				
			}else{
				q.prev = p.prev;
				q.next = p;
				p.prev.next = q;
				p.prev = q;
			}
			
			this.n++;
		
		
		return true;
	}

	@Override
	public boolean add(E element) {
		if(element == null){
			return false;
		}
		this.add(Integer.MAX_VALUE, element);
		return true;
	}

	@Override
	public E remove(int index) {
		E old = null;
		if(index >= 0 &&index <this.n){
			int j = 0;
			DLinkNode<E>p = this.head;
			while(p.next!=null&&j<index){
				j++;
				p = p.next;
			}
			old = p.data;
			p.prev.next = p.next;
			if(p.next!=null){
				p.next.prev = p.prev;
				
			}
			this.n--;
			return old;
		}
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
