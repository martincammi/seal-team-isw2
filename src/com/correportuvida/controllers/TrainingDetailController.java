package com.correportuvida.controllers;

import android.view.View;
import android.widget.TextView;

import com.correportuvida.R;
import com.correportuvida.activities.PlansListActivity;
import com.correportuvida.activities.RunningActivity;
import com.correportuvida.activities.TrainingDetailActivity;
import com.correportuvida.activities.TrainingListActivity;
import com.correportuvida.model.Trainer;
import com.correportuvida.model.training.Training;

public class TrainingDetailController extends Controller {

	public TrainingDetailController(TrainingDetailActivity activity){
		super(activity);
	}

	@Override
	public void updateView() {
		
		String planName = (String) getActivity().getIntent().getSerializableExtra(PlansListActivity.PLAN_NAME);
		String trainingName = (String) getActivity().getIntent().getSerializableExtra(TrainingListActivity.TRAINING_NAME);
		
		Training training = Trainer.getInstance().getTraining(planName, trainingName);
		
		TextView valuePlanName = (TextView) getActivity().findViewById(R.id.valueNombrePlan);
		valuePlanName.setText(training.getPlan().getName());
		
		TextView valueTrainingName = (TextView) getActivity().findViewById(R.id.valueNombreEntrenamiento);
		valueTrainingName.setText(training.getName());
		
		TextView buttonStart = (TextView) getActivity().findViewById(R.id.button_start);
		
		buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	goToActivity(RunningActivity.class);
            }
        });
		
	}
	
}