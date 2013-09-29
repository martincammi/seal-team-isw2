package com.correportuvida.activities;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.annotation.TargetApi;
import android.content.Context;
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
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.PolylineOptions;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RunningActivity extends FragmentActivity /*implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener implements LocationListener*/  {
	
	static final String BLUE_COLOR = "#CC0000FF";
	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	static final LatLng CIUDAD_UNIVERSITARIA = new LatLng(-34.541672, -58.442189);
	//private GoogleMap googleMap;
	private Marker currentMarker;
	private Location currentLocation;
	private float distance = 0;
	Context context;
	GoogleMapsService googleMapService;
	LocationListener locationListener; 
	
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_running);
		googleMapService = new GoogleMapsService(getBaseContext(), this, getSupportFragmentManager(), R.id.map);
		locationListener = createLocationListener();
		context = this;
		
		addButtonCancelBehaviour();
		updateDistanceTraveled();
        //googleMap = googleMapService.getGooleMap();
        
        if(googleMapService.servicesConnected()){
        
        	googleMapService.updateCurrentLocation(getLocationListener());
        	
            Location location = googleMapService.getCurrentLocation();
 
            if(location!=null){
            	currentLocation = location;
                getLocationListener().onLocationChanged(location);
            }
            
            //locationManager.requestLocationUpdates(provider, 20000, 0, this);
        }

	}

	private void updateDistanceTraveled() {
		
		TextView valorDistancia = (TextView) findViewById(R.id.valueDistanceTraveled);
		valorDistancia.setText(new DecimalFormat("##.##").format(distance/1000) + " Km");

//		Old Way
//		TextView valueDistanceTraveled = (TextView) findViewById(R.id.valueDistanceTraveled);
//		int roundedDistance = (int) Math.round(distance);
//		valueDistanceTraveled.setText(Integer.toString(roundedDistance));
		
	}

	private void addButtonCancelBehaviour() {
		Button buttonCancel = (Button) findViewById(R.id.button_cancel);
		buttonCancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				goToTrainingDetailActivity(v);
			}
		});
	}
	
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
		        
//		        if (positions.size() > 1){
//		        	drawPrimaryLinePath(positions);
//		        }
		        
				if (currentLocation != null){
					distance += location.distanceTo(currentLocation);
				}
				currentLocation = location;
				
				updateDistanceTraveled();
//				TextView valorDistancia = (TextView) findViewById(R.id.valueDistanceTraveled);
//				valorDistancia.setText(new DecimalFormat("##.##").format(distance/1000) + " Km");
				
		 
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

        options.color( Color.parseColor(BLUE_COLOR) );
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
