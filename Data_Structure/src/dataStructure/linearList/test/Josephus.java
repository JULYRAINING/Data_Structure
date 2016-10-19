package dataStructure.linearList.test;

import dataStructure.LList;
import dataStructure.linearList.SeqList;
import dataStructure.linearList.SinglyLinkedList;

public class Josephus {
	
	private LList<String>list;
	
	public Josephus(int number, int start, int distance) {
//		单链表实现
//		this.list = new SinglyLinkedList<>();
		//顺序表实现
		this.list = new SeqList<>(number);
		System.out.println("开始运行");
		long begin = System.currentTimeMillis();
		for(int i = 0; i< number; i++){
			this.list.add(new String((char)('A'+i) + ""));
		}
		System.out.println("约瑟夫环:"+number + "," + start + "," +distance);
		System.out.println(this.list.toString());
		
		int index = start -1;
		while(this.list.length()>1){
			index = (index + distance -1)%this.list.length();
			System.out.print("删除" + this.list.remove(index).toString() + ",");
			System.out.println(this.list.toString());
			
		}
		System.out.println("被赦免者是"+list.get(0).toString());
		System.out.println("运行时间："+(System.currentTimeMillis()-begin));
	}

	public static void main(String[] args) {
		new Josephus(25, 1, 2);
	}
}
