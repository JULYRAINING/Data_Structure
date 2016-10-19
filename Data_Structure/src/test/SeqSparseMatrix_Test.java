package test;

import org.junit.Test;

import b_5.Element;
import b_5.SeqSparseMatrix;

public class SeqSparseMatrix_Test {
	@Test
	public void test(){
		
		Element[] item = {new Element(0,2,11),
				new Element(0,4,17),
				new Element(1,1,20),
				new Element(3,0,19),
				new Element(3,5,28),
				new Element(4,4,50)};
		
		SeqSparseMatrix smata = new SeqSparseMatrix(item);
		smata.add(new Element(4,3,50));
		smata.add(new Element(6,5,50));
		System.out.println("A "+smata.toString());
		
		
		System.out.println("transpose A " + smata.transpose().toString());
		
		SeqSparseMatrix smatb = new SeqSparseMatrix(5,6,4);
		smatb.add(new Element(0,2,10));
		smatb.add(new Element(1,4,9));
		smatb.add(new Element(4,5,20));
		smatb.add(new Element(2,3,30));
		System.out.println("B "+smatb.toString());
		System.out.println("A+B "+smatb.add(smatb).toString());
		
	}
	
}
