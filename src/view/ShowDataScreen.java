package view;

import java.util.List;

public class ShowDataScreen {
	public <T extends Comparable<? super T>> ShowDataScreen(List<T> list){
		for (T t : list) {
			System.out.println(t);
		}
		
	}

}
