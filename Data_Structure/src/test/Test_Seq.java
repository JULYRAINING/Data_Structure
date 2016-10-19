package test;

import org.junit.Test;

import dataStructure.linearList.SeqList;

public class Test_Seq {

	@Test
	public void test(){
		SeqList<Integer>list = new SeqList<>(5);
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		list.add(3, 4);
		System.out.println(list);
		
	}
}
