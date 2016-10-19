package search;

public class BSArray {
	public static int binarySearch(Comparable[]table, Comparable cobj, int low, int high){
		if(table!=null&&cobj!=null){
			while (low<high) {
				int mid = (low + high)/2;
				System.out.println(table[mid]+"?");
				if(cobj.compareTo(table[mid]) == 0){
					return mid;
					
				}else {
					if(cobj.compareTo(table[mid]) < 0){
						high = mid -1;
					}else {
						low = mid + 1;
					}
				}
			}
		}
		return -1;
	}
	public static int binarySearch(Comparable[]table, Comparable cobj){
		return binarySearch(table, cobj, 0, table.length-1);
	}
}
