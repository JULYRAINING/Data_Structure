package dataStructure.graph;

import java.awt.event.MouseWheelEvent;

import javax.print.attribute.standard.MediaSize;

import dataStructure.linearList.SeqList;

/**
 * 图-邻接矩阵表示
 * @author TF
 *
 * @param <E>
 */
public class AdjMatrixGraph<E> extends AbstractGraph<E> implements GGraph<E>{

	
	protected SeqList<E>vertexlist;
	protected int[][] adjmatrix;
	private final int MAX_WEIGHT = Integer.MAX_VALUE;
	
	
	public AdjMatrixGraph(int n){
		this.vertexlist = new SeqList<>(n);
		this.adjmatrix = new int[n][n];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				this.adjmatrix[i][j] = (i==j)?0:MAX_WEIGHT;
			}
		}
	}
	
	public AdjMatrixGraph(E[] vertices, Edge[] edges){
		this(vertices.length);
		for(int i =0; i<vertices.length; i++){
			insertVertex(vertices[i]);
		}
		for(int j = 0; j<edges.length; j++){
			insertEdge(edges[j]);
		}
	}
	public AdjMatrixGraph(SeqList<E>list, Edge[] edges){
		this(list.length());
		this.vertexlist = list;
		
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
		return this.vertexlist.get(i);
	}

	@Override
	public boolean insertVertex(E vertex) {
		boolean isInsert = this.vertexlist.add(vertex);
		int n = this.vertexlist.length();
		if(adjmatrix.length<n){
			int[][]temp = adjmatrix;
			adjmatrix = new int[n][n];
			for(int m = 0; m<n; m++){
				for(int p = 0; p<n; p++){
					//copy origin array
					if(m<n-1&&p<n-1){
						this.adjmatrix[m][p] = temp[m][p];
					//outer edge
					}else if(m == n-1&& p == n-1){
						this.adjmatrix[m][p] = 0;
					//cornor point
					}else {
						this.adjmatrix[m][p] = MAX_WEIGHT;
					}
					
				}
			}
		}
		return isInsert;
	}
	/**
	 * update weight of edge
	 * @return
	 */
	public boolean updateEdge(Edge edge){
		return false;
	}
	@Override
	public boolean insertEdge(int i, int j, int weight) {
		//if the count of vertexlist is bigger than edge's count,expand it
	
		int n = vertexCount();
		if(adjmatrix.length<n){
			int[][]temp = adjmatrix;
			adjmatrix = new int[n][n];
			for(int m = 0; m<n; m++){
				for(int p = 0; p<n; p++){
					//copy origin array
					if(m<n-1&&p<n-1){
						this.adjmatrix[m][p] = temp[m][p];
					//outer edge
					}else if(m == n-1&& p == n-1){
						this.adjmatrix[m][p] = 0;
					//cornor point
					}else {
						this.adjmatrix[m][p] = MAX_WEIGHT;
					}
					
				}
			}
		}
		if(i>=0&&i<vertexCount()&&
				j>=0&&j<vertexCount()
				&&i!=j&&adjmatrix[i][j] == MAX_WEIGHT){
			this.adjmatrix[i][j] = weight;
			return true;
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
			this.vertexlist.remove(v);
			for(int i = v; i<n-1;i++){
				for(int j = 0; j< n ; j++){
					this.adjmatrix[i][j] = this.adjmatrix[i+1][j];
				}
			}
			//双层for循环优化，运行次数多的放在内层
			for(int j = v; j<n-1;j++){
				for(int i = 0; i< n ; i++){
					this.adjmatrix[i][j] = this.adjmatrix[i][j+1];
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEdge(int i, int j) {
		if(i>=0&&i<vertexCount()&&
				j>=0&&j<vertexCount()
				&&i!=j&&adjmatrix[i][j] != MAX_WEIGHT){
			this.adjmatrix[i][j] = MAX_WEIGHT;
			return true;
		}
		return false;
	}

	@Override
	public int getFirstNeighbor(int v) {
		return getNextNeighbor(v, -1);
		
	}
	/**
	 * if v == w; return -1
	 */

	@Override
	public int getNextNeighbor(int v, int w) {
		if(v>0&&v<vertexCount()&&w>=-1&&w<vertexCount()&&v!=w){
			for(int j = w+1; j < vertexCount(); j++){
				
				if(adjmatrix[v][j]>0&&adjmatrix[v][j]<MAX_WEIGHT){
					return j;
				}
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		String str = "顶点集合："+vertexlist.toString()+"\n";
		str += "邻接矩阵：\n";
		int n = vertexCount();
		for(int i = 0; i<n;i++){
			for(int j = 0; j<n; j++){
				if(adjmatrix[i][j]==MAX_WEIGHT){
					str += " ∞";//alt(按住)+41438(小键盘)： ∞
				}else {
					str += " "+adjmatrix[i][j];
				}
				
			}
			str += "\n";
		}
		return str;
	}
	/**
	 * prim算法，构造最小生成树
	 */
	public AdjMatrixGraph<E> minSpanTree_prim(){
		Edge[] mst = new Edge[vertexCount()-1];
		for(int i = 0; i<mst.length; i++){
			mst[i] = new Edge(0, i+1, adjmatrix[0][i+1]);
		}
		for(int i = 0; i<mst.length; i++){
			int minweight = MAX_WEIGHT;
			int min = i;
			for(int j = i; j<mst.length; j++){
				if (mst[j].weight<minweight) {
					minweight = mst[j].weight;
					min = j;
				}
			}
			Edge temp = mst[i];
			mst[i] = mst[min];
			mst[min] = temp;
			
			int u = mst[i].dest;
			for(int j = i+1; j<mst.length; j++){
				int v = mst[j].dest;
				if(adjmatrix[u][v]<mst[j].weight){
					mst[j].weight = adjmatrix[u][v];
					mst[j].start = u;
				}
			}
		}
		return new AdjMatrixGraph<>(this.vertexlist, mst);
	}
	/**
	 * 判断图是否存在孤立点
	 */
	
	public SeqList<E> hasIsoland(){
		SeqList<E>isolist = null;
		isolist = new SeqList<>();
		int n = vertexCount();
		
		for(int i = 0; i<n; i++){
			
			for(int j = 0; j<n; j++){
				if(i == j){
					//ignore self
				}else if(adjmatrix[i][j] ==MAX_WEIGHT&&adjmatrix[j][i] ==MAX_WEIGHT){
					
				}else {
					break;
				}
				if(j == n-1){
					isolist.add(this.vertexlist.get(i));
				}
				
			}
		}
		return isolist;
	}
	
	
	
}
