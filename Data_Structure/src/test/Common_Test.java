package test;

import org.junit.Test;

import dataStructure.linearList.Node;

public class Common_Test {
	@Test
	public void test_array(){
		int[][][][][] array = new int[2][2][2][2][2];
		for(int a = 0; a<2; a ++){
			for(int b = 0; b<2; b ++){
				for(int c = 0; c<2; c ++){
					for(int d = 0; d<2; d ++){
						for(int e = 0; e<2; e ++){
							array[a][b][c][d][e] = e;
						}
					}
				}
			}
		}
	}
	
	@Test
	public void test_Class_array(){
		Node[][][] node_array= null;
	}
}
