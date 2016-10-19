package dataStructure.linearList.test;


import java.util.Iterator;

import org.junit.Test;

import dataStructure.linearList.CHDoublyLinkedList;
import dataStructure.linearList.HSLinkedList;
import dataStructure.linearList.LinkedQueue;
import dataStructure.linearList.LinkedStack;
import dataStructure.linearList.SeqStack;
import dataStructure.linearList.SinglyLinkedList;

public class Test_Class {
	@Test
	public void testHSLinkedList_get(){
		HSLinkedList<String> list = new HSLinkedList<String>();
		list.add(new String("a"));
		
		System.out.println(list.set(0, "b"));
		System.out.println(list.get(0));
		
	}
	/**
	 * 带头结点的双向链表的add方法和remove方法存在问题
	 * error
	 */
	@Test
	public void testCHDoublyLinkedList(){
		CHDoublyLinkedList<String> list = new CHDoublyLinkedList<>();
		System.out.println(list.add("a"));
		System.out.println(list.add("b"));
		System.out.println(list.add("c"));
		int a = 1;
		System.out.println(a);
//		System.out.println(list.remove(2));
		
//		System.out.println(list.set(0, "aa"));
//		System.out.println(list.set(1, "bb"));
//		System.out.println(list.set(2, "cc"));
	}
	@Test
	public void testIterator_SinglyLinkedList(){
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		for(int i = 0; i<10; i++){
			list.add(new String((char)('A'+i)+""));
		}
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	@Test
	public void test_Seq_Stack(){
		SeqStack<String> stack = new SeqStack<>();
		for(int i = 0; i<10; i++){
			stack.push(new String((char)('A'+i)+""));
		}
		System.out.println(stack);
		System.out.println(stack.pop());
		
	}
	@Test
	public void test_Linked_Stack(){
		LinkedStack<String> stack = new LinkedStack<>();
		for(int i = 0; i<10; i++){
			stack.push(new String((char)('A'+i)+""));
		}
		System.out.println(stack);
		
		for(int i = 0; i<10; i++){
			System.out.println(stack.pop());
		}
	}
	@Test
	public void test_LinkedQueue(){
		LinkedQueue<String> queue = new LinkedQueue<>();
		for(int i = 0; i<10; i++){
			queue.enqueue(new String((char)('A'+i)+""));
			
		}
		for(int i = 0; i<10; i++){
			System.out.println(queue.dequeue());
		}
		
		
	}
}
