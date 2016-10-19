package dataStructure.graph;

public class Edge implements Comparable<Edge>{
	
	public int start;
	public int dest;
	public int weight;
	public Edge(int start, int dest, int weight) {
		
		this.start = start;
		this.dest = dest;
		this.weight = weight;
	}
	/**
	 * ignore weight
	 */
	@Override
	public int compareTo(Edge e) {
		if(this.start!=e.start){
			return this.start - e.start;
		}else{
			return this.dest - e.dest;
		}
	}
	
	@Override
	public String toString() {
		return "(" + start + "," + dest + ","+ weight + ")";
	}
}
