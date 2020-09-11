package algorithms;

import java.util.ArrayList;

public class BubbleSort {

	public static ArrayList<Integer> sort(ArrayList<Integer> list){
		
		// makes a copy of the list
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for (int i = 0, size = list.size(); i < size; i++) {
			sortedList.add(list.get(i));
		}
		
		// sorts list using Bubble sort method
		for(int i = 0, tempN = 0, size = list.size(); i < size; i++){
			for(int j = 0; j < size-1; j++){
				if(sortedList.get(j) > sortedList.get(j + 1)){
					tempN = sortedList.get(j);
					sortedList.set(j, sortedList.get(j+1));
					sortedList.set(j + 1, tempN);
				}
			}
		}
		
		// returns the sorted list
		return sortedList;
	}
}
