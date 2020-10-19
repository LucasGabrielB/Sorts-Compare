package utils;

public class AlgorithmStatistics implements Comparable<AlgorithmStatistics>{
	private long timeTaken;
	private String name;
	
	public AlgorithmStatistics(){
		name = "Não informado.";
	}
	
	public AlgorithmStatistics(String name){
		this.name = name;
	}

	public AlgorithmStatistics(String name, long timeTake) {
		super();
		this.timeTaken = timeTake;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTake) {
		this.timeTaken = timeTake;
	}

	@Override
	public int compareTo(AlgorithmStatistics algorithmStatistics) {
		if(algorithmStatistics.getTimeTaken() > timeTaken){
			return 1;
		}
		else if(algorithmStatistics.getTimeTaken() < timeTaken){
			return -1;
		}
		else{
			return 0;
		}
	}

}
