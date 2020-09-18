package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable<? super T>> List<Comparable> sort(List<T> list){

		// makes a copy of the list
		List<Comparable> sortedList = new ArrayList<Comparable>();
		for (int i = 0, size = list.size(); i < size; i++) {
			sortedList.add(list.get(i));
		}
		
		// sorts list using Merge sort method
		mergeSort(sortedList);
		
		// returns the sorted list
		return sortedList;
	}
	
	@SuppressWarnings({ "rawtypes" })
	private static<T extends Comparable<? super T>> List<Comparable> merge(List<T> left, List<T> right) {
        
		List<Comparable> merged = new ArrayList<Comparable>();
        
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T extends Comparable<? super T>> void mergeSort(List<T> list){
        if (list.size() != 1) {
            List<Comparable> left = new ArrayList<Comparable>();
            List<Comparable> right = new ArrayList<Comparable>();
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
