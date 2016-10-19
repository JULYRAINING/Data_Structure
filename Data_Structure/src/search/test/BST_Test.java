package search.test;

import search.BinarySortTree;

public class BST_Test {
	public static void main(String[] args) {
		BinarySortTree<Integer>binarySortTree = new BinarySortTree<>();
		System.out.print("插入： ");
		int[]key = {54,18,66,87,36,12,54,81,15,76,57,6,40,99,85};
		for(int i = 0; i<key.length;i++){
			if(binarySortTree.insert_recursion(new Integer(key[i]))){
				System.out.print(key[i] + " ");
			}
			
			
		}
		System.out.println();
		binarySortTree.inOrder();
		Integer element = new Integer(key[key.length-1]);
		System.out.println("查找"+element+","+((binarySortTree.search_recursion(element)!=null?"":"不")+"成功"));
		element = new Integer(50);
		System.out.println("查找"+element+","+((binarySortTree.search_recursion(element)!=null?"":"不")+"成功"));
	
	}
}
