package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AlgorithmsRank {
	private ArrayList<AlgorithmStatistics> algorithmsRank;
	
	public AlgorithmsRank(){
		this.algorithmsRank = new ArrayList<AlgorithmStatistics>();
	}
	
	public void addAlgorithm(AlgorithmStatistics algorithmStatistics){
		this.algorithmsRank.add(algorithmStatistics);
	}
	
	// return a ArrayList of AlgorithmStatistics in sorted order
	public ArrayList<AlgorithmStatistics> getRank(){
		Collections.sort(algorithmsRank, new Comparator<AlgorithmStatistics>() {
	        @Override
	        public int compare(AlgorithmStatistics AS2, AlgorithmStatistics AS1)
	        {
	            return  AS1.compareTo(AS2);
	        }
	    });
		
		return this.algorithmsRank;
	}
}
