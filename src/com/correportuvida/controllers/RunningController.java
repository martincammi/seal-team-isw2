package com.correportuvida.controllers;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.correportuvida.R;
import com.correportuvida.activities.PlansListActivity;
import com.correportuvida.activities.TrainingListActivity;
import com.correportuvida.adapters.DistanceAdapter;
import com.correportuvida.adapters.PhaseAdapter;
import com.correportuvida.adapters.VelocityAdapter;
import com.correportuvida.model.Navigator;
import com.correportuvida.model.Phase;
import com.correportuvida.model.Trainer;
import com.correportuvida.model.base.Distance;
import com.correportuvida.model.base.Velocity;
import com.correportuvida.model.training.Training;
import com.correportuvida.services.GoogleMapsService;

public  class RunningController extends Controller {
	private final String _planName;
	private final String _trainingName;
	
	public RunningController(Activity activity) {
		super(activity);
		
		_planName = (String) getActivity().getIntent().getSerializableExtra(PlansListActivity.PLAN_NAME);
		_trainingName = (String) getActivity().getIntent().getSerializableExtra(TrainingListActivity.TRAINING_NAME);
	}

	@Override
	public void updateView() {
		
		try {
			addButtonCancelBehaviour();
			
			setTrainingName(_trainingName);
			
			Trainer trainer = Trainer.getInstance();
			trainer.setController(this);
			Training training = trainer.getTraining(_planName, _trainingName);
			
			Navigator navigator;
			navigator = getNavigator();
			trainer.startTraining(training, navigator);
			
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText( getActivity().getApplicationContext(), "Map not available", Toast.LENGTH_LONG ).show();
		}
		
	}

	private Navigator getNavigator() throws Exception {
		GoogleMapsService googleMapService = new GoogleMapsService(getActivity().getBaseContext(), (FragmentActivity)getActivity(), ((FragmentActivity)getActivity()).getSupportFragmentManager(), R.id.map);
		Navigator navigator = new Navigator(googleMapService, getActivity());
		return navigator;
	}
	
	private void addButtonCancelBehaviour() {
		Button buttonCancel = (Button) getActivity().findViewById(R.id.button_cancel);
		buttonCancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Trainer.getInstance().cancelTraining();
				goToActivity(TrainingListActivity.class, PlansListActivity.PLAN_NAME, _planName);
			}
		});
	}
	
	public void notifyPositionVelocityChanged(Trainer trainer) {
		updateVelocity(trainer);
		updateDistanceTraveled(trainer);
	}

	private void setTrainingName(String trainingName)
	{
		TextView trainingView = (TextView) getActivity().findViewById(R.id.labelEntretainmentName);
		trainingView.setText(trainingName);
	}
	
	private void updateDistanceTraveled(Trainer trainer) {
		Distance currentDistance = trainer.getCurrentDistance();
		TextView distanceValue = (TextView) getActivity().findViewById(R.id.valueDistanceTraveled);
		distanceValue.setText((new DistanceAdapter(currentDistance)).toString());
	}

	private void updateVelocity(Trainer trainer) {
		Velocity velocity = trainer.getCurrentVelocity();
		TextView currentVelocity = (TextView) getActivity().findViewById(R.id.valueVelocidadActual);
		currentVelocity.setText((new VelocityAdapter(velocity)).toString());
	}

	public void notifyPhaseChanged(Trainer trainer) {
		Phase currentPhase = trainer.getCurrentPhase();
		TextView phaseValue = (TextView) getActivity().findViewById(R.id.valueFase);
		phaseValue.setText((new PhaseAdapter(currentPhase)).toString());
	}
}
