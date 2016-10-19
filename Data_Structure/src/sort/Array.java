package sort;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Sort Algorithm
 * @author TF
 *
 */
public class Array {
	/**
	 * generate random array
	 * @param n
	 * @return
	 */
	public static int[] random(int n){
		if(n>0){
			int table[] = new int[n];
			for(int i = 0; i<table.length;i++){
				table[i] = (int)(Math.random()*100);
			}
			return table;
		}
		return null;
	}
	/**
	 * print table
	 * @param table
	 */
	public static void print(int[] table){
		for(int element:table){
			System.out.print(element + " ");
		}
		System.out.println();
		
	}
	public static void insertSort(int[] table){
		for(int i = 1; i<table.length;i++){
			int temp = table[i];
			int j;
			System.out.print("第"+i+"趟:    ");
			for(j = i-1; j>-1&&temp<table[j]; j--){
				table[j+1] = table[j];
				
				
			}
			table[j+1] = temp;
			
			print(table);
		}
	}
	/**
	 * binary insert sort
	 * @param table
	 */
	public static void binary_insertSort(int[] table){
		for(int i = 1; i < table.length; i++){
			int temp = table[i];
			int low = 0;
			int high = i - 1;
			while(low <= high){
				int mid = (low + high) / 2;
				if(temp < table[mid]){
					high = mid - 1;
				}
				else{
					low = mid + 1;
				}
			}
			for(int j = i; j >= low + 1; j--){
				table[j] = table[j - 1];
			}
			table[low] = temp;
			System.out.print("第"+i+"趟:    ");

			print(table);
		}
	}
	
	public static void shellSort(int[] table){
		for(int delta = table.length/2; delta > 0; delta/=2){
			for(int i = delta; i<table.length; i++){
				int temp = table[i];
				int j = i-delta;
				while (j>=0&&temp<table[j]) {
					table[j+delta] = table[j];
					j-=delta;
				}
				table[j+delta] = temp;
			}
			System.out.print("第"+delta+"趟:    ");
			print(table);
		}
		
	}
	
	public static void bubbleSort(int[] table){
		//
		boolean exchange = true;
		
		for(int i = 1; i<table.length&&exchange; i++){
			exchange = false;
			for(int j = 0; j<table.length -i; j++){
				if(table[j]>table[j+1]){
					int temp = table[j];
					table[j] = table[j+1];
					table[j+1] = temp;
					exchange = true;
				}
			}
			System.out.print("第"+i+"趟:    ");
			print(table);
		}
		
	}
	
	public static void quickSort(int[] table){
		quickSort(table, 0, table.length-1);
	}
	private static void quickSort(int[] table, int low, int high) {
		if(low <high){
			int i = low;
			int j = high;
			int vot = table[i];
			while (i!=j) {
				while (i<j&&vot<=table[j]) {
					j--;
				}
				if(i<j){
					table[i] = table[j];
					i++;
				}    
				while (i<j&&table[i]<vot) {
					i++;
				}
				if(i<j){
					table[j] = table[i];
					j--;
				}
			}
			table[i] = vot;
			System.out.println(low+".."+high+", vot=" + vot + "   ");
			print(table);
			quickSort(table, low, j-1);
			quickSort(table, i+1, high);
		}
		
	}
	public static void selectSort(int[] table){
		int count = 0;
		for(int i =0; i<table.length - 1; i++){
			int min = i;
			for(int j = i+1; j<table.length; j++){
				if(table[j] <= table[min]){
					min = j;
				}
				
			}
			System.out.print("第"+i+"趟:    ");
			if(min!=i){
				int temp = table[i];
				table[i] = table[min];
				table[min] = temp;
				
				System.out.print("第"+(count++)+"次交换 ");
				System.out.println();
			}
			
			print(table);
		}
		
		
	}
	
	
	private static void sift_big(int[] table, int low, int high){
		int i = low;
		int j = 2*i+1;
		int temp = table[i];
		while(j<=high){
			if(j<high&&table[j]<table[j+1]){
				j++;
			}
			if(temp<table[j]){
				table[i]=table[j];
				i = j;
				j = 2*i+1;
			}else {
				j = high +1;
			}
		}
		table[i] = temp;
	}
	/**
	 * 
	 * @param table
	 * @param low
	 * @param high
	 */
	private static void sift_small(int[] table, int low, int high){
		int i = low;
		int j = 2*i+1;
		int temp = table[i];
		while(j<=high){
			if(j<high&&table[j]>table[j+1]){
				j++;
			}
			if(temp>table[j]){
				table[i]=table[j];
				i = j;
				j = 2*i+1;
			}else {
				j = high +1;
			}
		}
		table[i] = temp;
	}
	public static void heapSort(int[] table){
		int n = table.length;
		for(int j = n/2-1; j>=0; j--){
			sift_big(table, j, n-1);
		}
		for(int j = n-1; j>0; j--){
			int temp = table[0];
			table[0] = table[j];
			table[j] = temp;
			sift_big(table, 0, j-1);
		}
		print(table);
	}
}
