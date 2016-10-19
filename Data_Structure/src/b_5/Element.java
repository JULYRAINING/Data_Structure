package b_5;

import java.awt.event.ItemEvent;

/**
 * 稀疏矩阵三元组类
 * @author raining
 *
 */
public class Element implements Comparable<Element>{

	
	 int row;
	 int column;
	 int value;
	
	
	
	
	public Element(){
		this(0,0,0);
	}
	
	
	
	public Element(int row, int column, int value) {
		
		this.row = row;
		this.column = column;
		this.value = value;
	}


	/**
	 * 返回对称位置矩阵元素的三元组
	 * @return
	 */
	public Element toSymmetry(){
		return new Element(this.column, this.row, this.value);
	}




	@Override
	public String toString() {
		return "("+ row + "," + column + "," + value + ")";
	}



	@Override
	public int compareTo(Element item) {
		if(this.row<item.row||this.row==item.row&&this.column<item.column){
			return -1;
		}
		if(this.row == item.row && this.column == item.column){
			return 0;
		}
		return 1;
	}
	
}
