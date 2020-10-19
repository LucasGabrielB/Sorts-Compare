package algorithms;

import java.util.List;

public class InsertionSort{
	
	public static <T extends Comparable<? super T>> void sort(List<T> list){
		// sorts list using Insertion sort method
		for (int i = 1, size = list.size(); i < size; i++){
			
			T temp = list.get(i);
			int j = i;
			
			while ((j > 0) && (list.get(j-1).compareTo(temp) > 0)){
				list.set(j, list.get(j-1));
				j -= 1;
			}
			
			list.set(j, temp);
		}
	    
	}

}
