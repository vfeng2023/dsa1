package sorting;

public class AdvancedSorts {

	
	
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		T[] buffer = (T[])(new Comparable[list.length]);
		mergeSort(list, 0, list.length-1, buffer);
	}
	
	private static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j, T[] buffer) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(i >= j){
			return;
		}
		else{
			int mid = (i+j)/2;
			mergeSort(list, i,mid, buffer);
			mergeSort(list, mid+1, j, buffer);
			merge(list, i, mid, j, buffer);
		}
	}
	
	private static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j, T[] buffer) {
		/* TODO: IMPLEMENT THIS METHOD */
		int i1 = i;
		int i2 = mid+1;
		int pos = i;
		while(i1 <=mid && i2 <=j){
			if(list[i1].compareTo(list[i2]) < 0){
				buffer[pos] = list[i1];
				i1 ++;

			}else{
				buffer[pos] = list[i2];
				i2 ++;
			}
			pos ++;
		}

		while(i1 <=mid){
			buffer[pos] = list[i1];
			i1 ++;
			pos ++;

		}
		while (i2 <=j){
			buffer[pos] = list[i2];
			i2 ++;
			pos ++;
		}
		for(int idx=i; idx <= j; idx++){
			list[idx] = buffer[idx];
		}
	}
	
	
	
	
	
	
	public static<T extends Comparable<T>> void swap(T[] list, int i, int j){
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length-1);
	}
	
	private static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		if(i>=j){
			return;
		}
		//partition
		int pivotpos = partition(list, i, j);
		//sort subarrays left and right of pivot
		swap(list, i, pivotpos);
		quickSort(list, i, pivotpos-1);
		quickSort(list, pivotpos+1, j);
	}
	
	private static<T extends Comparable<T>> int partition(T[] list, int i, int j) {
		/* TODO: IMPLEMENT THIS METHOD */
		T pivotval = list[i];
		int low = i+1;
		int high = j;
		while(low <= high){
			if(list[low].compareTo(pivotval) < 0){
				low++;
			}else if(list[high].compareTo(pivotval) > 0){
				high --;
			}
			else{
				swap(list, low, high);
				low ++;
				high --;
			}
		}
		return high;
		//choose i to be the pivot
		//use the lomuto parition scheme		return 0;
	}
	
	
	
	
	
	
	
	

}