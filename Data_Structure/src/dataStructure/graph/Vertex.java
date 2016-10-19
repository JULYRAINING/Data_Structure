package dataStructure.graph;

import dataStructure.linearList.SortedHSLinkedList;

/**
 * 图-邻接表表示
 * @author TF
 *
 * @param <E>
 */
public class Vertex<E> {
	public E data;
	public SortedHSLinkedList<Edge>adjlink;
	
	public Vertex(E data, SortedHSLinkedList<Edge>adjlink){
		this.data = data;
		this.adjlink = adjlink;
	}
	public Vertex(E data){
		this(data, new SortedHSLinkedList<>());
	}
	public String toString(){
		return this.data.toString();
	}
}
