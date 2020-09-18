package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable<? super T>> List<Comparable> sort(List<T> list){
		
		// makes a copy of the list
		List<Comparable> sortedList = new ArrayList<Comparable>();
		for (int i = 0, size = list.size(); i < size; i++) {
			sortedList.add(list.get(i));
		}
		
		// sorts list using Bubble sort method
		Comparable temp;
		for(int i = 0, size = list.size(); i < size; i++){
			for(int j = 0; j < size-1; j++){
				if(sortedList.get(j).compareTo(sortedList.get(j + 1)) > 0){
					temp = sortedList.get(j);
					sortedList.set(j, sortedList.get(j+1));
					sortedList.set(j + 1, temp);
				}
			}
		}
		
		// returns the sorted list
		return sortedList;
	}
}
