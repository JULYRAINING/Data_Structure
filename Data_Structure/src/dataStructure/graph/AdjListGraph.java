package dataStructure.graph;

import org.junit.experimental.theories.Theories;

import dataStructure.linearList.SeqList;
import dataStructure.linearList.SortedHSLinkedList;

public class AdjListGraph<E> extends AbstractGraph<E> implements GGraph<E>{
	
	protected SeqList<Vertex<E>>vertexlist;
	public AdjListGraph(int n) {
		this.vertexlist = new SeqList<>(n);
	}
	
	public AdjListGraph(E[] vertices, Edge[] edges) {
		this(vertices.length);
		for(int i = 0; i<vertices.length; i++){
			insertVertex(vertices[i]);
		}
		for(int j = 0; j<edges.length; j++){
			insertEdge(edges[j]);
		}
	}
	@Override
	public int vertexCount() {
		// TODO Auto-generated method stub
		return this.vertexlist.length();
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return this.vertexlist.get(i).data;
	}

	@Override
	public boolean insertVertex(E vertex) {
		
		return this.vertexlist.add(new Vertex<E>(vertex));
	}

	@Override
	public boolean insertEdge(int i, int j, int weight) {
		
		if(i>=0&&i<vertexCount()&&j>=0&&j<vertexCount()&&i!=j){
			SortedHSLinkedList<Edge> slink = this.vertexlist.get(i).adjlink;
			return slink.add(new Edge(i, j, weight));
		}
		return false;
	}
	public boolean insertEdge(Edge edge){
		if(edge!=null){
			return insertEdge(edge.start, edge.dest, edge.weight);
		}
		return false;
	}
	@Override
	public boolean removeVertex(int v) {
		int n = vertexCount();
		if(v>=0&&v<n){
			SortedHSLinkedList<Edge> slink = this.vertexlist.get(v).adjlink;
			int i = 0;
			Edge edge = slink.get(i);
			while(edge!=null){
				//delete symmetric edge
				this.removeEdge(edge.dest, edge.start);
				i++;
				edge = slink.get(i);
			}
			this.vertexlist.remove(v);
			//change vertex's order number
			for(i = 0; i<n-1; i++){
				slink = this.vertexlist.get(i).adjlink;
				int j = 0;
				edge = slink.get(j);
				while(edge!=null){
					if(edge.start>v){
						edge.start--;
					}
					if(edge.dest>v){
						edge.dest--;
					}
					j++;
					edge = slink.get(j);
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEdge(int i, int j) {
		if(i>=0&&i<vertexCount()&&j>=0&&j<vertexCount()&&i!=j){
			SortedHSLinkedList<Edge>slink = this.vertexlist.get(i).adjlink;
			return slink.remove(new Edge(i, j, 1));
		}
		return false;
	}
	/**
	 * return :the next vertex of the v,default:-1
	 */
	@Override
	public int getFirstNeighbor(int v) {
		// TODO Auto-generated method stub
		return getNextNeighbor(v, -1);
	}
	
	@Override
	public int getNextNeighbor(int v, int w) {
		if(v>=0&&v<vertexCount()&&w>=-1&&w<vertexCount()){
			SortedHSLinkedList<Edge>slink = this.vertexlist.get(v).adjlink;
			Edge edge = slink.get(0);
			int i = 0;
			while(edge!=null){
				if(edge.dest>w){
					return edge.dest;
				}
				i++;
				edge = slink.get(i);
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		String str = "顶点集合："+vertexlist.toString()+"\n";
		str += "边表：\n";
		for(int i = 0; i<vertexCount(); i++){
			str += this.vertexlist.get(i).adjlink.toString() + "\n";
		}
		return str;
	}

}
