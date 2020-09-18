package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Quicksort {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable<? super T>> List<Comparable> sort(List<T> list){

		// makes a copy of the list
		List<Comparable> sortedList = new ArrayList<Comparable>();
		for (int i = 0, size = list.size(); i < size; i++) {
			sortedList.add(list.get(i));
		}
		
		// sorts list using Quicksort method
		quickSort(sortedList, 0, sortedList.size() - 1);
		
		// returns the sorted list
		return sortedList;
	
	}
	
	private static <T extends Comparable<? super T>> void quickSort(List<T> list, int begin, int end) {
		// check the indices and continue only if there are still elements to be sorted
		if (begin < end) {
			// we get the index of the sorted pivot and use it to recursively 
			// call partition() method with the same parameters as the 
			// quickSort() method, but with different indices
			int partitionIndex = partition(list, begin, end);
			quickSort(list, begin, partitionIndex - 1);
			quickSort(list, partitionIndex + 1, end);
        
		}
	
	}
	
	private static <T extends Comparable<? super T>> int partition(List<T> list, int begin, int end) {
		T pivot = list.get(end);
		int i = begin - 1;
		
		// checks each element and swaps it before the pivot if its value is smaller.
		for (int j = begin; j < end; j++) {
			if (list.get(j).compareTo(pivot) < 0 ) {
				i++;
	 
				T temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		
		}
		 
		T temp = list.get(i + 1);
		list.set(i + 1, list.get(end));
		list.set(end, temp);
		
		// all elements less then the pivot are on the left of it 
		// and all elements greater then the pivot are on the right of it
		
		// returns pivot final sorted position 
		return i + 1;
   
	}

}
