package utils;

import java.util.Date;

public class WeatherData implements Comparable<WeatherData>{
	private Date date;
	private double temperatureInst;
	private double temperatureMax;
	private double temperatureMin;
	private double airHumidityInst;
	private double airHumidityMax;
	private double airHumidityMin;
	private double dewPointInst;
	private double dewPointMax;
	private double dewPointMin;
	private double pressureInst;
	private double pressureMax;
	private double pressureMin;
	private double windVelocity;
	private double windDirection;
	private double windGust;
	private double radiation;
	private double rain;
	
	public WeatherData() {
		super();
	}

	public WeatherData(Date date, double temperatureInst, double temperatureMax, double temperatureMin,
			double airHumidityInst, double airHumidityMax, double airHumidityMin, double dewPointInst,
			double dewPointMax, double dewPointMin, double pressureInst, double pressureMax, double pressureMin,
			double windVelocity, double windDirection, double windGust, double radiation, double rain) {
		super();
		this.date = date;
		this.temperatureInst = temperatureInst;
		this.temperatureMax = temperatureMax;
		this.temperatureMin = temperatureMin;
		this.airHumidityInst = airHumidityInst;
		this.airHumidityMax = airHumidityMax;
		this.airHumidityMin = airHumidityMin;
		this.dewPointInst = dewPointInst;
		this.dewPointMax = dewPointMax;
		this.dewPointMin = dewPointMin;
		this.pressureInst = pressureInst;
		this.pressureMax = pressureMax;
		this.pressureMin = pressureMin;
		this.windVelocity = windVelocity;
		this.windDirection = windDirection;
		this.windGust = windGust;
		this.radiation = radiation;
		this.rain = rain;
	}
	
	@Override
	public int compareTo(WeatherData wd) {
		// TODO, compare by what ???
		if(this.temperatureInst > wd.getTemperatureInst()){
			return 1;
		}
		else if(this.temperatureInst < wd.getTemperatureInst()){
			return -1;
		}
		else{
			return 0;
		}
		
	}
	
	@Override
	public String toString() {
		return "WeatherData [date=" + date + ", temperatureInst=" + temperatureInst + ", temperatureMax="
				+ temperatureMax + ", temperatureMin=" + temperatureMin + ", airHumidityInst=" + airHumidityInst
				+ ", airHumidityMax=" + airHumidityMax + ", airHumidityMin=" + airHumidityMin + ", dewPointInst="
				+ dewPointInst + ", dewPointMax=" + dewPointMax + ", dewPointMin=" + dewPointMin + ", pressureInst="
				+ pressureInst + ", pressureMax=" + pressureMax + ", pressureMin=" + pressureMin + ", windVelocity="
				+ windVelocity + ", windDirection=" + windDirection + ", windGust=" + windGust + ", radiation="
				+ radiation + ", rain=" + rain + "]";
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTemperatureInst() {
		return temperatureInst;
	}
	public void setTemperatureInst(double temperatureInst) {
		this.temperatureInst = temperatureInst;
	}
	public double getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(double temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public double getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(double temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public double getAirHumidityInst() {
		return airHumidityInst;
	}
	public void setAirHumidityInst(double airHumidityInst) {
		this.airHumidityInst = airHumidityInst;
	}
	public double getAirHumidityMax() {
		return airHumidityMax;
	}
	public void setAirHumidityMax(double airHumidityMax) {
		this.airHumidityMax = airHumidityMax;
	}
	public double getAirHumidityMin() {
		return airHumidityMin;
	}
	public void setAirHumidityMin(double airHumidityMin) {
		this.airHumidityMin = airHumidityMin;
	}
	public double getDewPointInst() {
		return dewPointInst;
	}
	public void setDewPointInst(double dewPointInst) {
		this.dewPointInst = dewPointInst;
	}
	public double getDewPointMax() {
		return dewPointMax;
	}
	public void setDewPointMax(double dewPointMax) {
		this.dewPointMax = dewPointMax;
	}
	public double getDewPointMin() {
		return dewPointMin;
	}
	public void setDewPointMin(double dewPointMin) {
		this.dewPointMin = dewPointMin;
	}
	public double getPressureInst() {
		return pressureInst;
	}
	public void setPressureInst(double pressureInst) {
		this.pressureInst = pressureInst;
	}
	public double getPressureMax() {
		return pressureMax;
	}
	public void setPressureMax(double pressureMax) {
		this.pressureMax = pressureMax;
	}
	public double getPressureMin() {
		return pressureMin;
	}
	public void setPressureMin(double pressureMin) {
		this.pressureMin = pressureMin;
	}
	public double getWindVelocity() {
		return windVelocity;
	}
	public void setWindVelocity(double windVelocity) {
		this.windVelocity = windVelocity;
	}
	public double getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(double windDirection) {
		this.windDirection = windDirection;
	}
	public double getWindGust() {
		return windGust;
	}
	public void setWindGust(double windGust) {
		this.windGust = windGust;
	}
	public double getRadiation() {
		return radiation;
	}
	public void setRadiation(double radiation) {
		this.radiation = radiation;
	}
	public double getRain() {
		return rain;
	}
	public void setRain(double rain) {
		this.rain = rain;
	}
}