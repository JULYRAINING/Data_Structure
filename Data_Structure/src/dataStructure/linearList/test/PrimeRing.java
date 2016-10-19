package dataStructure.linearList.test;

import dataStructure.linearList.LinkedQueue;
import dataStructure.linearList.SeqList;

/**
 * 素数环
 * @author TF
 *
 */
public class PrimeRing {
	public PrimeRing(int n){
		SeqList<Integer>ring = new SeqList<Integer>(n);
		ring.add(new Integer(1));
		LinkedQueue<Integer>q = new LinkedQueue<>();
		for(int i = 2; i <= n; i++){
			q.enqueue(new Integer(i));
		}
		int i = 0;
		while(!q.isEmpty()&&i < n*10){
			int k = q.dequeue().intValue();
			if(isPrime(ring.get(i)+k)){
				i++;
				ring.add(new Integer(k));
				System.out.println("已求得第" + i +"个数："+ k);
				System.out.println("剩余:"+q.toString());
			}else{
//				System.out.println("重新入栈。");
				q.enqueue(new Integer(k));
			}
			
			
		}
		System.out.println("素数环:"+ring.toString());
		System.out.println("剩余:"+q.toString());
	}
	public boolean isPrime(int k){
		if(k == 2){
			return true;
		}
		if(k <2 ||k>2 && k%2 == 0){
			return false;
		}
		int j = (int)Math.sqrt(k);
		if(j%2 == 0){
			j--;
		}
		while(j>2&&k%j!=0){
			j-=2;
		}
		return j<2;
	}
	public static void main(String[] args) {
		new PrimeRing(20);
	}
}
