package dataStructure.tree;

public class HaffmanTree {

	private int leafNum;
	private HaffmanNode[] hnodes;
	
	public HaffmanTree(int[] weight){
		int n = weight.length;
		this.leafNum = n;
		this.hnodes = new HaffmanNode[2*n-1];
		for(int i = 0; i<n; i++){
			this.hnodes[i] = new HaffmanNode(weight[i]);
		}
		//构造n-1个2度节点
		for(int i = 0; i< n-1; i++){
			int min1,x1;//最小值及其index
			int min2,x2;//第二小值及其index
			min1 = min2 = Integer.MAX_VALUE;
			x1 = x2 = -1;
			for(int j = 0; j < n+i; j++){
				if(hnodes[j].weight<min1&&hnodes[j].parent==-1){
					min2 = min1;
					x2 = x1;
					min1 = hnodes[j].weight;
					x1 = j;
					
				}else if (hnodes[j].weight<min2&&hnodes[j].parent==-1) {
					min2 = hnodes[j].weight;
					x2 = j;
					
				}
			}
			
			hnodes[x1].parent = n+i;
			hnodes[x2].parent = n+i;
			this.hnodes[n+i] = new HaffmanNode();
			hnodes[n+i].weight = hnodes[x1].weight + hnodes[x2].weight;
			hnodes[n+i].left = x1;
			hnodes[n+i].right = x2;
		}
	}
	public String toString(){
		String str = "";
		for(int i = 0; i<this.hnodes.length&&hnodes[i]!=null;i++){
			str += i+", "+this.hnodes[i].toString()+"\n";
		}
		return str;
	}
	public String[] haffmanCode(){
		String[] code = new String[this.leafNum];
		for(int i = 0; i<this.leafNum; i++){
			code[i] = "";
			int child = i;
			int parent = hnodes[child].parent;
			while(parent!=-1){
				if(hnodes[parent].left == child){
					code[i] = "0" + code[i];
				}else {
					code[i] = "1" + code[i];
				}
				child = parent;
				parent = hnodes[child].parent;
			}
		}
		return code;
	}
}
