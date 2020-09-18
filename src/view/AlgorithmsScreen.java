package view;

import java.util.ArrayList;

import algorithms.BubbleSort;
import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.Quicksort;

public class AlgorithmsScreen {
	public AlgorithmsScreen(ArrayList<Integer> list){
		
		System.out.println("Normal: " + list);
		System.out.println("Bubble Sort: " + BubbleSort.sort(list));
		System.out.println("Insertion Sort: " + InsertionSort.sort(list));
		System.out.println("Merge Sort: " + MergeSort.sort(list));
		System.out.println("Quicksort: " + Quicksort.sort(list));

	}
}
