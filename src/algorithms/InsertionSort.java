package algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable<? super T>> List<Comparable> sort(List<T> list){
		// makes a copy of the list
		List<Comparable> sortedList = new ArrayList<Comparable>();
		for(int i = 0, size = list.size(); i < size; i++ ){
			sortedList.add(list.get(i));
		}
	    
		// sorts list using Insertion sort method
		for (int i = 1, size = list.size(); i < size; i++){
			
			Comparable temp = sortedList.get(i);
			int j = i;
			
			while ((j > 0) && (sortedList.get(j-1).compareTo(temp) > 0)){
				sortedList.set(j, sortedList.get(j-1));
				j -= 1;
			}
			
			sortedList.set(j, temp);
		}
	    
		// returns the sorted list
		return sortedList;
	}

}
