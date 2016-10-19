package dataStructure.graph;

import dataStructure.linearList.SeqQueue;

public abstract class AbstractGraph<E> implements GGraph<E>{
	
	public abstract int vertexCount();
	public abstract E get(int i);
	public abstract int getFirstNeighbor(int i);
	public abstract int getNextNeighbor(int i, int j);
	/**
	 * Depth First Search start with v;
	 * @param v
	 */
	public void DFSTraverse(int v){
		boolean[] visted = new boolean[vertexCount()];
		int i = v;
		do{
			if(!visted[i]){
				System.out.print("{");
				depthfs(i, visted);
				System.out.print("}");
			}
			i = (i+1)%vertexCount();
		}while(i!=v);
		System.out.println();
	}
	private void depthfs(int v, boolean[] visted) {
		System.out.print(this.get(v));
		visted[v] = true;
		int w = getFirstNeighbor(v);
		while (w!=-1) {
			if(!visted[w]){
				depthfs(w, visted);
			}
			w = getNextNeighbor(v, w);
		}
		
	}
	/**
	 * Breadth First Search start with v;
	 * @param v
	 */
	public void BFSTraverse(int v){
		boolean[] visted = new boolean[vertexCount()];
		int i = v;
		do{
			if(!visted[i]){
				System.out.print("{");
				breadthfs(i, visted);
				System.out.print("}");
			}
			i = (i+1)%vertexCount();
		}while(i!=v);
		System.out.println();
	}
	private void breadthfs(int v, boolean[] visted) {
		System.out.print(this.get(v));
		visted[v] = true;
		SeqQueue<Integer>queue = new SeqQueue<>(vertexCount());
		queue.enqueue(new Integer(v));
		while (!queue.isEmpty()) {
			v = queue.dequeue().intValue();
			int w = getFirstNeighbor(v);
			while (w!=-1) {
				if(!visted[w]){
					System.out.print(this.get(w));
					visted[w] = true;
					queue.enqueue(new Integer(w));
				}
				w = getNextNeighbor(v, w);
			}
		}
		
	}
}
