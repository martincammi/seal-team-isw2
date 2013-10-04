package com.correportuvida.model.runningstate;

import com.correportuvida.model.Navigator;
import com.correportuvida.model.base.GeographicalPosition;
import com.correportuvida.model.base.Velocity;
@Deprecated
public class RunningStateActive extends RunningState{
	public RunningStateActive(Navigator navigator)
	{
		super(navigator);
		//TODO: completar
	}

	@Override
	public void updateContext() {
		Velocity newVelocity = _navigator.getVelocity();
		GeographicalPosition position = _navigator.getPosition();
		
		//TODO: hay que hacer algo con la velocidad y la position... avisarle a la pantallita
		//para que refresque, que se yo
		
		
	}
}
