package com.correportuvida.model;

import java.io.Console;

import com.correportuvida.model.base.TimeLapse;
import com.correportuvida.model.interfaces.*;

public class Trainer implements NotifyPhaseChange, NotifyPositionVelocityChange{
	private final TimeKeeper _phaseTimeKeeper;
	private final TimeKeeper _positionVelocityTimeKeeper;
	
	//TODO: los lapsos iniciales deberia saberlo el entrenador
	public Trainer(TimeLapse phaseLapse, TimeLapse positionVelocityLapse) 
	{
		//Set Temporizadores
		_phaseTimeKeeper = new TimeKeeper(new TimeKeeperPhaseChangeNotice(this), phaseLapse);
		_positionVelocityTimeKeeper = new TimeKeeper(new TimeKeeperPositionVelocityNotice(this), positionVelocityLapse);
		
		//TODO: implementar correctamente
	}

	@Override
	public void notifyPhaseChanged() {
		// TODO Auto-generated method stub
		System.out.println("NotificarCambioFase");
	}

	@Override
	public void notifyPositionVelocityChanged() {
		// TODO Auto-generated method stub
		System.out.println("NotificarCambioPosicionVelocidad");
	}
}
