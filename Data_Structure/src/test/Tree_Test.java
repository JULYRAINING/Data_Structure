package test;

import org.junit.Test;

import dataStructure.tree.BinaryNode;
import dataStructure.tree.BinaryTree;
import dataStructure.tree.CompleteBinaryTree;
import dataStructure.tree.HaffmanTree;
import dataStructure.tree.ThreadBinaryTree;

public class Tree_Test {
	@Test
	public void test_Tree_Traverse(){
		BinaryNode<String> child_f, child_d, child_c, child_b,child_a;
		child_d = new BinaryNode<String>("D", null, new BinaryNode<String>("G"));
		child_b = new BinaryNode<String>("B", child_d, null);
		child_f = new BinaryNode<String>("F", new BinaryNode<String>("H"), null);
		child_c = new BinaryNode<String>("C", new BinaryNode<String>("E"), child_f);
		child_a = new BinaryNode<String>("A", child_b, child_c);
		
		BinaryTree<String> bitree = new BinaryTree<>(child_a);
		
		bitree.preOrder();
		bitree.inOrder();
		bitree.postOrder();
	}
	
	@Test
	public void tree_Test_constructor(){
		String[] preorder = {"A", "B", "D", null, "G", null, null, null, "C", "E", null, null, "F", "H"};
		BinaryTree<String>bitree = new BinaryTree<String>(preorder);
		bitree.preOrder();
		
		String value = "H";
		BinaryNode<String>find = bitree.search(value);
		if(find == null){
			System.out.println("\n 未找到" + value);
			
		}else{
			BinaryNode<String> parent = bitree.getParent(find);
			System.out.println("\n"+ find.data + "的祖先结点是");
			while(parent != null){
				System.out.print(parent.data+ "");
				parent = bitree.getParent(parent);
			}
		}
	}
	
	@Test
	public void test_complete_tree(){
		String[] levelorder = {"A", "B", "C", "D", "E", "F", "G", "H"};
		CompleteBinaryTree<String>cbtree = new CompleteBinaryTree<>(levelorder);
		
		cbtree.preOrder();
		cbtree.preOrderTraverse();
		
		cbtree.inOrder();
		cbtree.inOrderTraverse();
		int count = cbtree.count();
		int height = cbtree.height();
		System.out.println("\n结点数："+count);
		System.out.println("\n树高度："+height);
	}
	@Test
	public void test_thread_binary_tree(){
		String[] preorder = {"A", "B", "D", null, "G", null, null, null, "C", "E", null, null, "F", "H"};
		ThreadBinaryTree<String>tbtree = new ThreadBinaryTree<String>(preorder);
		tbtree.inOrder();
	}
	@Test
	public void test_haffman(){
		int[] weight = {5,29,7,8,14,23,3,11};
		HaffmanTree hTree = new HaffmanTree(weight);
		System.out.println("哈弗曼树的结点数组：\n"+hTree.toString());
		String[] codes = hTree.haffmanCode();
		for(String code :codes){
			System.out.println(code);
		}
	}
}
