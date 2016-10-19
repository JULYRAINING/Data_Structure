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
	 * ����v��w�����һ���ڽӶ������� 
	 * @param v
	 * @param w
	 * @return
	 */
	int getNextNeighbor(int v, int w);
}
