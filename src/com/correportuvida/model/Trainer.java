package com.correportuvida.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.correportuvida.controllers.Controller;
import com.correportuvida.controllers.RunningController;
import com.correportuvida.model.base.TimeLapse;
import com.correportuvida.model.base.Velocity;
import com.correportuvida.model.interfaces.NotifyPhaseChange;
import com.correportuvida.model.interfaces.NotifyPositionVelocityChange;
import com.correportuvida.model.runningstate.ActiveNavigator;
import com.correportuvida.model.runningstate.NavigatorState;
import com.correportuvida.model.runningstate.StoppedNavigator;
import com.correportuvida.model.timekeeper.TimeKeeper;
import com.correportuvida.model.timekeeper.TimeKeeperPhaseChangeNotice;
import com.correportuvida.model.timekeeper.TimeKeeperPositionVelocityNotice;
import com.correportuvida.model.training.Training;

public class Trainer implements NotifyPhaseChange, NotifyPositionVelocityChange {
	
	private static Trainer _trainer;
	private TimeKeeper _phaseTimeKeeper; //TODO: Verificar si al perder scope deja de actualizar.
	private RunningController _controller;
	
	private final SportsDoctor _doctor;
	private Map<String, Plan> _plans = new HashMap<String, Plan>();
	private NavigatorState _navigatorState;
	
	
	public static Trainer createInitialInstance(SportsDoctor sportDoctor) {
		
		if(_trainer == null){
			_trainer = new Trainer (sportDoctor);
		}
		
		return _trainer;
	}
	
	public static Trainer getInstance() {
		
		return _trainer;
	}
	
	private Trainer(SportsDoctor sportDoctor) 
	{
		_doctor = sportDoctor;
		_navigatorState = new StoppedNavigator();
	}
	
	public void setController(RunningController controller){
		_controller = controller;
	}
	
	public RunningController getController() {
		return _controller;
	}

	public Plan createPlan(String name){
		Plan newPlan = new Plan(name, _doctor.getTrainings()); 
		_plans.put(name, newPlan);
		return newPlan;
	}
	
	public Plan getPlan(String planName){
		return _plans.get(planName);
	}
	
	public List<Plan> getPlans(){
		return new ArrayList<Plan>(_plans.values());
	}
	
	public List<Training> getTrainings(String planName){
		return _plans.get(planName).getTrainings();
	}
	
	public Training getTraining(String planName, String trainingName){
		return _plans.get(planName).getTraining(trainingName);
	}
	
	public void startTraining(Training training, Navigator navigator){
		
		TimeLapse phaseLapse = new TimeLapse(1, TimeLapse.SECONDS); //TODO: valores de prueba para empezar
		_phaseTimeKeeper = new TimeKeeper(new TimeKeeperPhaseChangeNotice(this), phaseLapse);
		
		TimeLapse positionVelocityLapse = new TimeLapse(3, TimeLapse.SECONDS);
		navigator.start(new TimeKeeperPositionVelocityNotice(this), positionVelocityLapse);
		
		_navigatorState = new ActiveNavigator(navigator);
	}
	
	public void cancelTraining(){
		//TODO: ver si el objeto sigue vivo _navigatorState.stopNavigation();
		_navigatorState = new StoppedNavigator();
	}
	
	@Override
	public void notifyPhaseChanged() {
		_controller.notifyPhaseChanged(this);
	}

	@Override
	public void notifyPositionVelocityChanged() {

		_navigatorState.updateCurrentLocation();
		_controller.notifyPositionVelocityChanged(this);
		
	}
	
	public Velocity getCurrentVelocity()
	{
		return _navigatorState.getCurrentSpeed();
	}
}
