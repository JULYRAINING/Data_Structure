package sort.test;

import sort.Array;

public class TopK_Find {
	public static void main(String[] args) {
		
		int n = 1000000;
		
		int[] array = new int[n];
		for(int i = 0; i<n; i++){
			array[i] = i;
		}
		int k = 10;
		int[] top_array = new int[k];
		
		for(int i = 0; i<k; i++){
			top_array[i] = array[i];
		}
		
//		Array.print(array);
		Array.print(top_array);
		Array.heapSort(top_array);
		
		for(int j = k; k<n; k++){
			if(array[k]<top_array[0]){
				continue;
			}
			top_array[0] = array[k];
			Array.heapSort(top_array);
			System.out.println(top_array[0]);
		}
		
	}
}
