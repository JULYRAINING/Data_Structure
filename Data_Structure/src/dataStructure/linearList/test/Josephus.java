package dataStructure.linearList.test;

import dataStructure.LList;
import dataStructure.linearList.SeqList;
import dataStructure.linearList.SinglyLinkedList;

public class Josephus {
	
	private LList<String>list;
	
	public Josephus(int number, int start, int distance) {
//		������ʵ��
//		this.list = new SinglyLinkedList<>();
		//˳���ʵ��
		this.list = new SeqList<>(number);
		System.out.println("��ʼ����");
		long begin = System.currentTimeMillis();
		for(int i = 0; i< number; i++){
			this.list.add(new String((char)('A'+i) + ""));
		}
		System.out.println("Լɪ��:"+number + "," + start + "," +distance);
		System.out.println(this.list.toString());
		
		int index = start -1;
		while(this.list.length()>1){
			index = (index + distance -1)%this.list.length();
			System.out.print("ɾ��" + this.list.remove(index).toString() + ",");
			System.out.println(this.list.toString());
			
		}
		System.out.println("����������"+list.get(0).toString());
		System.out.println("����ʱ�䣺"+(System.currentTimeMillis()-begin));
	}

	public static void main(String[] args) {
		new Josephus(25, 1, 2);
	}
}
