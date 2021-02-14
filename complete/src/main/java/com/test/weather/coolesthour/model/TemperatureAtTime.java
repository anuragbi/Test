package com.test.weather.coolesthour.model;

import java.time.LocalDateTime;

public class TemperatureAtTime implements Comparable<TemperatureAtTime> {
	private double value;
	private LocalDateTime time;
	private double minValue;

	public TemperatureAtTime(double value, LocalDateTime time, double minValue) {
		super();
		this.value = value;
		this.time = time;
		this.minValue = minValue;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public int compareTo(TemperatureAtTime o) {
		return Double.compare(getValue(), o.getValue());
	}
}
