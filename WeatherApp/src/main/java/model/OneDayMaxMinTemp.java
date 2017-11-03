package model;

public class OneDayMaxMinTemp {
	public final double maxTemperature;
	public final double minTemperature;
	
	public OneDayMaxMinTemp(double maxTemperature, double minTemperature) {
		super();
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
	}

	@Override
	public String toString() {
		return "OneDayMaxMinTemp [maxTemperature=" + maxTemperature + ", minTemperature=" + minTemperature + "]";
	}
	
}
