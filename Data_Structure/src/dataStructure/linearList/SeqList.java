package dataStructure.linearList;

import java.util.Iterator;

import dataStructure.LList;

public class SeqList<E> extends AbstractList<E> implements LList<E> {

	private Object[] table;
	private int n;
	
	public SeqList(int capacity) {
		
		this.table = new Object[Math.abs(capacity)];
		this.n = 0;
	}
	public SeqList() {
		this(16);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.n == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return this.n;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(index >= 0 &&index < this.n){
			return (E)this.table[index];
		}
		return null;
	}

	@Override
	public E set(int index, E element) {
		if(index >= 0 && index < this.n &&element !=null){
			E old = (E)this.table[index];
			this.table[index] = element;
			return old;
		}
		return null;
	}

	/**
	 * 插入到指定index位置
	 */
	@Override
	public boolean add(int index, E element) {
		if(element == null){
			return false;
		}
		if(this.n == table.length){
			Object[] temp = this.table;
			this.table = new Object[temp.length*2];
			for(int i = 0; i<temp.length;i++){
				this.table[i] = temp[i];
			}
			
		}
		if(index <0){
			index = 0;
		}
		if(index > this.n){
			index = this.n;
		}
		for(int j = this.n-1; j>=index; j--){
			this.table[j+1] = this.table[j];
		}
		this.table[index] = element;
		this.n++;
		
		return true;
	}

	@Override
	public boolean add(E element) {
		// TODO Auto-generated method stub
		return this.add(this.n, element);
	}

	@Override
	public E remove(int index) {
		if(this.n!=0&& index >= 0 && index <this.n){
			E old = (E)this.table[index];
			for(int i = index; i<this.n-1;i++){
				this.table[i] = this.table[i+1];
			}
			
			this.table[this.n-1] = null;
			this.n--;
			return old;
		}
		return null;
	}

	@Override
	public void clear() {
		if(this.n !=0){
			for(int i = 0; i<this.n;i++){
				this.table[i] = null;
				this.n = 0;
			}
		}

	}
	public String toString(){
		String string = "(";
		if(this.n != 0){
			for(int i = 0; i <this.n-1; i++){
				string += this.table[i].toString() + ",";
			}
			string += this.table[this.n-1].toString();
		}
		return string + ")";
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Itr();
	}

	private class Itr implements Iterator<E>{

		int cursor = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor!=0;
		}

		@Override
		public E next() {
			if(cursor!=n){
				E next = get(cursor);
				cursor++;
				return next;
			}
			return null;
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
	}
	public int indexOf(E element){
		if(element != null){
			for(int i = 0; i<this.n;i++){
				if(this.table[i].equals(element)){
					return i;
				}
			}
		}
		return -1;
		
	}
	public boolean contain(E element){
		return this.indexOf(element)>=0;
	}
	
	
}
