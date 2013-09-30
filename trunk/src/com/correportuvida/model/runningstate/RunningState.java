package com.correportuvida.model.runningstate;

import com.correportuvida.model.Navigator;
import com.correportuvida.model.statistics.RunStatistics;
import com.correportuvida.model.training.Training;

/*TODO:
 * Este es el que vaa usar el navegador para pedirle velocidad y esas cosas
 * */
public abstract class RunningState {
	private final Navigator _navigator;
	private RunStatistics _statistics;
	
	public RunningState(Navigator navigator)
	{
		_navigator = navigator;
		_statistics = new RunStatistics();
	}

	public void refreshInfo()
	{
		updateContext();
		_statistics.update();
	}
	
	public abstract void updateContext();
	
	//TODO: convert to abstract method
	public void startTraining(Training training) {
		// TODO Auto-generated method stub
		
	}

	//TODO: convert to abstract method
	public void cancelTraining() {
		// TODO Auto-generated method stub
		
	}
}
