package sort.test;

import sort.Array;

public class Test {
	public static void main(String[] args) {
		int[] table = Array.random(5);
		/*
		int size = 5;
		int[] table = new int[size];
		for(int i = 0; i<size; i++){
			table[i] = 5-i;
			if(i == size -1){
				table[i] = table[i-1];
			}
		}
		*/
		/*
		int size = 5;
		int[] table = new int[size];
		for(int i = 0; i<size; i++){
			table[i] = 5-i;
			if(i == 1){
				table[i] = table[i-1];
			}
		}
		*/
		System.out.print("¹Ø¼ü×ÖÐòÁÐ£º  ");
		Array.print(table);
//		Array.insertSort(table);
//		Array.shellSort(table);
//		Array.bubbleSort(table);
//		Array.quickSort(table);
//		Array.selectSort(table);
		Array.heapSort(table);
		/*
		long begin = System.currentTimeMillis();
		Array.binary_insertSort(table);
		Array.insertSort(table);
		System.out.println("cost:" + String.valueOf(System.currentTimeMillis()-begin));
		*/
	}
}
