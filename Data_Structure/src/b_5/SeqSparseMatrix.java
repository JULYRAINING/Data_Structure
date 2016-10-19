package b_5;

import dataStructure.linearList.SeqList;

/**
 * ϡ��������Ԫ��˳���
 * @author raining
 *
 */
public class SeqSparseMatrix {
	private int rowCount, columnCount;
	private SeqList<Element>list;
	
	public SeqSparseMatrix(){
		this(0,0,10);
	}

	public SeqSparseMatrix(int rowCount, int columnCount, int count) {
		
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.list = new SeqList<Element>(count);
	}
	public SeqSparseMatrix(int rowCount, int columnCount, Element[] items) {
		this(rowCount, columnCount, items.length);
		for(int i = 0; i<items.length; i++){
			this.add(items[i]);
		}
	}
	public SeqSparseMatrix(Element[] items){
		this(0,0,items);
	}
	
	
	public boolean add(Element item){
		if(this.rowCount <= item.row){
			this.rowCount = item.row + 1;
		}
		if(this.columnCount <= item.column){
			this.columnCount = item.column +1;
		}
		
		int i = 0;
		Element temp = this.list.get(i);
		while(i<this.list.length() && item.compareTo(temp)>0){
			i++;
			temp = this.list.get(i);
		}
		return this.list.add(i, item);
	}
	public String toString(){
		String str = "ϡ����� " + rowCount + "�У�" + columnCount +"�У�"+this.list.length() 
		+ "������Ԫ��\n";
		str += "��Ԫ�����Ա�" + this.list.toString() + "\n";
		str += "ϡ�����\n";
		int k = 0;
		Element temp = this.list.get(k++);
		for(int i = 0; i<this.rowCount; i++){
			for(int j = 0; j <this.columnCount; j++){
				if(temp!=null && i == temp.row && j == temp.column){
					str += temp.value + " ";
					temp = this.list.get(k++);
				}else {
					str += 0+ "  ";
				}
			}
			str += "\n";
		}
		return str;
	}
	/**
	 * ת�þ���
	 * @return
	 */
	public SeqSparseMatrix transpose(){
		SeqSparseMatrix trans = new SeqSparseMatrix(columnCount, rowCount, this.list.length());
		for(int i = 0; i<this.list.length();i++){
			trans.add(this.list.get(i).toSymmetry());
		}
		return trans;
	}
	/**
	 * ������ӣ����ı䵱ǰ����
	 * @param matb
	 * @return
	 */
	public SeqSparseMatrix add(SeqSparseMatrix matb){
		
		SeqSparseMatrix matc = new SeqSparseMatrix(rowCount, columnCount, this.list.length());
		int i=0,j = 0;
		Element tempa = this.list.get(i++);
		Element tempb = matb.list.get(j++);
		while(tempa != null && tempb !=null){
			if(tempa.compareTo(tempb) == 0){
				matc.list.add(new Element(tempa.row, tempa.column, tempa.value + tempb.value));
				tempa = this.list.get(i++);
				tempb = matb.list.get(j++);
			}else if (tempa.compareTo(tempb) < 0) {
				matc.list.add(tempa);
				tempa = this.list.get(i++);
			}else {
				matc.list.add(tempb);
				tempb = matb.list.get(j++);
			}
			
			
		}
		
		while(tempa != null){
			matc.list.add(tempa);
			tempa = this.list.get(i++);
		}
		while(tempb != null){
			matc.list.add(tempb);
			tempb = matb.list.get(j++);
		}
		
		return matc;
	}
	
}
