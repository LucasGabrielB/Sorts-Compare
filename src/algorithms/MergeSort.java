package algorithms;

import java.util.ArrayList;

public class MergeSort {
	
	public static ArrayList<Integer> sort(ArrayList<Integer> list){

		// makes a copy of the list
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for (int i = 0, size = list.size(); i < size; i++) {
			sortedList.add(list.get(i));
		}
		
		// sorts list using Merge sort method
		mergeSort(sortedList);
		
		// returns the sorted list
		return sortedList;
	}
	
	private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> merged = new ArrayList<>();
        
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.get(0).compareTo(right.get(0)) <= 0) {
                merged.add(left.remove(0));
            } 
            else {
                merged.add(right.remove(0));
            }
        }
        
        merged.addAll(left);
        merged.addAll(right);
        
        return merged;
    }

    private static void mergeSort(ArrayList<Integer> list) {
        if (list.size() != 1) {
            ArrayList<Integer> left = new ArrayList<Integer>();
            ArrayList<Integer> right = new ArrayList<Integer>();
            boolean logicalSwitch = true;
            
            while (!list.isEmpty()) {
                if (logicalSwitch) {
                    left.add(list.remove(0));
                } 
                else {
                    right.add(list.remove(0));
                }
                
                logicalSwitch = !logicalSwitch;
            }
            
            mergeSort(left);
            mergeSort(right);
            
            list.addAll(merge(left, right));
            
        }
        
    }
    
}
