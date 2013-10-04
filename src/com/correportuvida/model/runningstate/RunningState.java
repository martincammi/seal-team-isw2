package com.correportuvida.model.runningstate;

import com.correportuvida.model.Navigator;
import com.correportuvida.model.training.Training;


/*TODO:
 * Este es el que vaa usar el navegador para pedirle velocidad y esas cosas
 * */
public abstract class RunningState {
	protected final Navigator _navigator;
	
	//Tan pronto como se crea el estado este empieza a trabajar
	public RunningState(Navigator navigator)
	{
		_navigator = navigator;
	}

	public void refreshInfo()
	{
		updateContext();
	}
	
	public abstract void updateContext();
	
}
