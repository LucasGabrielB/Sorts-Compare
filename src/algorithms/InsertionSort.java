package algorithms;

import java.util.ArrayList;

public class InsertionSort {
	
	public static ArrayList<Integer> sort(ArrayList<Integer> list){

		// makes a copy of the list
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for (int i = 0, size = list.size(); i < size; i++) {
			sortedList.add(list.get(i));
		}
	    
		// sorts list using Insertion sort method
		for (int i = 1, size = list.size(); i < size; i++){
			
			int tempN = sortedList.get(i);
			int j = i;
			
			while ((j > 0) && (sortedList.get(j-1) > tempN)){
				sortedList.set(j, sortedList.get(j-1));
				j -= 1;
			}
			
			sortedList.set(j, tempN);
		}
	    
		// returns the sorted list
		return sortedList;
	}

}
