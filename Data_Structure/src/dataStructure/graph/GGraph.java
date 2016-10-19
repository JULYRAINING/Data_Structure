package dataStructure.graph;

public interface GGraph<E> {
	
	int vertexCount();
	E get(int i);
	boolean insertVertex(E vertex);
	boolean insertEdge(int i, int j, int weight);
	boolean removeVertex(int v);
	boolean removeEdge(int i, int j);
	int getFirstNeighbor(int v);
	
	/**
	 * 返回v在w后的下一个邻接顶点的序号 
	 * @param v
	 * @param w
	 * @return
	 */
	int getNextNeighbor(int v, int w);
}
