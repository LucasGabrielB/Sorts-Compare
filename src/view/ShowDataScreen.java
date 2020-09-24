package view;

import java.util.List;

public class ShowDataScreen {
	public <T extends Comparable<? super T>> ShowDataScreen(List<T> list){
		System.out.println(list);

	}

}
