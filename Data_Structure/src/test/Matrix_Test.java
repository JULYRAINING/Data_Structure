package test;

import org.junit.Test;

import b_5.Matrix;

public class Matrix_Test {
	@Test
	public void test_matrix() throws Exception{
		
		int m1[][] = {{1,2,3}, {4,5,6}};
		
		Matrix a = new Matrix(m1);
		
		int m2[][] = {{1,0,0}, {0,1,0}};
		Matrix b = new Matrix(m2);
		
		System.out.println("Matrix a:\n"+a.toString());
		System.out.println("Matrix b:\n"+b.toString());
		a.add(b);
		System.out.println("Matrix a:\n"+a.toString());
		a.subtract(b);
		System.out.println("Matrix a:\n"+a.toString());
		
		int m3[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		Matrix c = new Matrix(m3);
		System.out.println("Matrix c:\n"+c.toString());
		//×ªÖÃºó
		
		System.out.println("Matrix c transfer:\n"+c.transfer().toString());
		
		System.out.println("Matrix c :\n"+c.toString());
		
		
	}
	@Test
	public void multiply(){
		int n  = 220;
		int m[][] = new int[n][n];
		for(int i = 0; i< n; i++){
			for(int j = 0; j< n; j++){
				m[i][j] = (int)(1+Math.random()*(100-1+1));
			}
		}
		Matrix c = new Matrix(m);
		System.out.println("Matrix c:\n" + c.toString());
		//Ïà³Ë
		System.out.println("begin");
		long begin = System.currentTimeMillis();
		System.out.println("Matrix multiply:\n" + c.multiply(c));
		System.out.println("end");
		System.out.println("total :" +String.valueOf( System.currentTimeMillis() - begin));
	}
}
