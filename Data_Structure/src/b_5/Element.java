package b_5;

import java.awt.event.ItemEvent;

/**
 * ϡ�������Ԫ����
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
	 * ���ضԳ�λ�þ���Ԫ�ص���Ԫ��
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
