package algorithms;

import java.util.List;

public class BubbleSort{

	public static <T extends Comparable<? super T>> void sort(List<T> list){
		
		// sorts list using Bubble sort method
		T temp;
		for(int i = 0, size = list.size(); i < size; i++){
			for(int j = 0; j < size-1; j++){
				if(list.get(j).compareTo(list.get(j + 1)) > 0){
					temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j + 1, temp);
				}
			}
		}
	}
}
