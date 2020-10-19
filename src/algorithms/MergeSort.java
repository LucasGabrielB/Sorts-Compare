package algorithms;

import java.util.List;

public class MergeSort{
	
	
	public static <T extends Comparable<? super T>> void sort(List<T> list){
		
		mergeSort(list, 0, list.size()-1);
		
	}

    public static <T extends Comparable<? super T>> void mergeSort(List<T> list, int start, int end){
        if((end - start) >= 2){
            int mid = (end - start)/2;
            mergeSort(list, start, start + mid);
            mergeSort(list, start + mid +1, end);

            int i=start;
            int j=start + mid +1;
            while(i<j && j<=end){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    list.add(i, list.remove(j));
                    i++;
                    j++;
                }else if(list.get(i) == list.get(j)){
                    list.add(i+1, list.remove(j));
                    i++;
                    j++;
                }else{
                    i++;
                }
            }  

        }else{
            if(end > start){
                if(list.get(start).compareTo(list.get(end)) > 0){
                    T endValue = list.remove(end);
                    list.add(start, endValue);
                }                
            }
        }
    }

}