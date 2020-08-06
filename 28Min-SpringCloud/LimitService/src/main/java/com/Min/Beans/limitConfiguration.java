package com.Min.Beans;

public class limitConfiguration {

	private int Min;
	private int Max;

	protected limitConfiguration() {
	}

	public limitConfiguration(int min, int max) {
		super();
		Min = min;
		Max = max;
	}

	public int getMin() {
		return Min;
	}

	public int getMax() {
		return Max;
	}

}
