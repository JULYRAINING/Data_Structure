package dataStructure.tree;

public class HaffmanNode {
	
	int weight;
	int parent, left, right;
	
	public HaffmanNode(int weight){
		this.weight = weight;
		this.parent = this.left = this.right = -1;
	}
	public HaffmanNode(){
		this(0);
	}
	public String toString(){
		return this.weight + ","+this.parent + ","
				+this.left+","+this.right;
	}
}
