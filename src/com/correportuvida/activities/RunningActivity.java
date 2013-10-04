package com.correportuvida.activities;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.correportuvida.R;
import com.correportuvida.services.GoogleMapsService;
import com.correportuvida.util.HexColor;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.PolylineOptions;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RunningActivity extends FragmentActivity /*implements LocationListener*/  {
	
	private Marker currentMarker;
	private Location currentLocation;
	private float distance = 0;
	private GoogleMapsService googleMapService;
	private LocationListener locationListener; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_running);
		
		initVariablesAndListeners();
        
        if(googleMapService.servicesConnected()){
        
        	googleMapService.updateCurrentLocation(getLocationListener());
            Location location = googleMapService.getCurrentLocation();
 
            if(location != null){
            	currentLocation = location;
                getLocationListener().onLocationChanged(location);
            }else{
            	Toast.makeText( getApplicationContext(), "Location not available", Toast.LENGTH_LONG ).show();
            }
        }else{
        	Toast.makeText( getApplicationContext(), "Map not available", Toast.LENGTH_SHORT ).show();
        }

	}

	private void initVariablesAndListeners() {
		googleMapService = new GoogleMapsService(getBaseContext(), this, getSupportFragmentManager(), R.id.map);
		locationListener = createLocationListener();
		
		addButtonCancelBehaviour();
		updateDistanceTraveled();
	}

	private void updateDistanceTraveled() {
		
		TextView valorDistancia = (TextView) findViewById(R.id.valueDistanceTraveled);
		//TODO: esto tendria que hablar con el trainer y que el trainer se comunique
		//con el navigato para que le devuelva distance!
		valorDistancia.setText(new DecimalFormat("##.##").format(distance/1000) + " Km");

//		Old Way
//		TextView valueDistanceTraveled = (TextView) findViewById(R.id.valueDistanceTraveled);
//		int roundedDistance = (int) Math.round(distance);
//		valueDistanceTraveled.setText(Integer.toString(roundedDistance));
		
	}

	private void updateCurrentSpeed() {
		TextView valorDistancia = (TextView) findViewById(R.id.valueDistanceTraveled);
		//updateCurrentSpeed
	}

	private void addButtonCancelBehaviour() {
		Button buttonCancel = (Button) findViewById(R.id.button_cancel);
		buttonCancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//TODO: como referencio a la clase y no al listener!?
				//ActivityController.OpenActivity(this, TrainingDetailActivity.class);
				goToTrainingDetailActivity(v);
			}
		});
	}
	
	//TODO: refactor, codigo duplicado
	 public void goToTrainingDetailActivity(View view) {
    	Intent intent = new Intent(this, TrainingDetailActivity.class);
    	startActivity(intent);
	    	
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalle_plan, menu);
		return true;
	}
	
	public LocationListener getLocationListener(){
		return locationListener;
	}
	
	public LocationListener createLocationListener(){
		
		return new LocationListener() {
			
			@Override
		    public void onLocationChanged(Location location) {
		    	
		    	ArrayList<LatLng> positions = new ArrayList<LatLng>();
		    	if (currentMarker != null) {
		    		positions.add(currentMarker.getPosition());
		    		currentMarker.remove();
		    	}
				
		        LatLng coordinates = GoogleMapsService.getLatLng(location);
		        
		        positions.add(coordinates);
		        
		        if (positions.size() > 1){
					drawPrimaryLinePath(positions);
				}
		        
		        currentMarker = googleMapService.drawMarker(coordinates, "Exactas is cool", getCorrePorTuVidaIcon(), "Posicion actual");

		        //googleMapService.moveToPositionInGoogleMapWithEffect(currentMarker);
		        googleMapService.moveToPositionInGoogleMap(currentMarker);
		        
				if (currentLocation != null){
					distance += location.distanceTo(currentLocation);
				}
				currentLocation = location;
				
				updateDistanceTraveled();
				updateCurrentSpeed();
		 
		    }
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			 @Override
		    public void onProviderDisabled(String provider) {
		    	Toast.makeText( getApplicationContext(), "Gps Disabled", Toast.LENGTH_SHORT ).show();
		    }
		 
		    @Override
		    public void onProviderEnabled(String provider) {
		    	Toast.makeText( getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT ).show();
		    }
			
		};
	}
	
    private void drawPrimaryLinePath( ArrayList<LatLng> locationsToDraw )
    {
        if( !googleMapService.servicesConnected()){
            return;
        }

        if(locationsToDraw.size() < 2){
            return;
        }

        PolylineOptions options = new PolylineOptions();

        options.color( Color.parseColor(HexColor.BLUE) );
        options.width( 5 );
        options.visible( true );

        for (LatLng locRecorded : locationsToDraw){
            options.add(locRecorded);
        }

        //googleMap.addPolyline( options );
        googleMapService.addPolyLine(options);
        

    }
    
    private BitmapDescriptor getCorrePorTuVidaIcon() {
		return BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);
	}

}
