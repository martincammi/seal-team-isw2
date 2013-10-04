package com.correportuvida.model;

import java.util.ArrayList;
import java.util.List;

import com.correportuvida.model.base.TimeLapse;
import com.correportuvida.model.interfaces.NotifyPhaseChange;
import com.correportuvida.model.interfaces.NotifyPositionVelocityChange;
import com.correportuvida.model.runner.RunnerAvailability;
import com.correportuvida.model.runner.RunnerObjective;
import com.correportuvida.model.runner.RunnerProfile;
import com.correportuvida.model.runner.RunnerState;
import com.correportuvida.model.runningstate.RunningState;
import com.correportuvida.model.runningstate.RunningStateActive;
import com.correportuvida.model.runningstate.RunningStateStopped;
import com.correportuvida.model.timekeeper.TimeKeeper;
import com.correportuvida.model.timekeeper.TimeKeeperPhaseChangeNotice;
import com.correportuvida.model.timekeeper.TimeKeeperPositionVelocityNotice;
import com.correportuvida.model.training.Training;

public class Trainer implements NotifyPhaseChange, NotifyPositionVelocityChange{
	private final SportsDoctor _doctor;
	private final Navigator _navigator;
	
	private TimeKeeper _phaseTimeKeeper;
	private TimeKeeper _positionVelocityTimeKeeper;
	private RunningState _runningState;
	private List<Plan> _plans;
	
	//TODO: los lapsos iniciales deberia saberlo el entrenador
	public Trainer(SportsDoctor doctor) 
	{
		
		//Set deportologo
		_doctor = doctor;
		
		//Set navegador
		_navigator = new Navigator();
		
		//Set estado (corriendo o detenido)
		_runningState = new RunningStateStopped(_navigator);
		
		//Set lista de planes.
		_plans = new ArrayList<Plan>();
		
		//TODO: implementar correctamente
	}

	//TODO: el plan donde lo guardamos?
	//TODO: alguna vez se querra borrar un plan???
	public Plan createPlan(String name, RunnerProfile profile, RunnerObjective objective, 
			   RunnerAvailability availability, RunnerState state){
		Plan newPlan = _doctor.createPlan(name, profile, objective, availability, state);
		_plans.add(newPlan);
		return newPlan;
	}
	
	public void startTraining(Training training){
		//TODO: Set Temporizadores, hay que levantarlos o de un archivo de config
		//o de parametros del seteo del training
		TimeLapse phaseLapse = new TimeLapse(1); //TODO: valores de prueba para empezar
		TimeLapse positionVelocityLapse = new TimeLapse(3);
		_phaseTimeKeeper = new TimeKeeper(new TimeKeeperPhaseChangeNotice(this), phaseLapse);
		_positionVelocityTimeKeeper = new TimeKeeper(new TimeKeeperPositionVelocityNotice(this), positionVelocityLapse);
	
		_runningState = new RunningStateActive(_navigator);
	}
	
	public void cancelTraining(){
		_runningState = new RunningStateStopped(_navigator);
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
		_runningState.refreshInfo();
	}
}
