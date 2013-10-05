package com.correportuvida.model.runner;

import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.TimeLapse;

public class RunnerObjective {

	private final Distance _distance;
	private TimeLapse expectedTime;
	
	public RunnerObjective(Distance distance) {
		_distance = distance;
	}

	public Distance getDistance() {
		return _distance;
	}

	public TimeLapse getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(TimeLapse expectedTime) {
		this.expectedTime = expectedTime;
	}
}
