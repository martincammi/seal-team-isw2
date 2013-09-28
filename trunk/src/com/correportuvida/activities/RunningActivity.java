package com.correportuvida.activities;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.correportuvida.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RunningActivity extends FragmentActivity /*implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener*/ implements LocationListener  {
	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);
	static final LatLng CIUDAD_UNIVERSITARIA = new LatLng(-34.541672, -58.442189);
	private GoogleMap map;
	private Marker currentMarker;
	private Location currentLocation;
	private float distance = 0;
	Context context;
	
//    private static final int MILLISECONDS_PER_SECOND = 1000;
//    public static final int UPDATE_INTERVAL_IN_SECONDS = 5;
//    private static final long UPDATE_INTERVAL = MILLISECONDS_PER_SECOND
//                    * UPDATE_INTERVAL_IN_SECONDS;
//    private static final int FASTEST_INTERVAL_IN_SECONDS = 1;
//    private static final long FASTEST_INTERVAL = MILLISECONDS_PER_SECOND
//                    * FASTEST_INTERVAL_IN_SECONDS;

	/*
     * Define a request code to send to Google Play services This code is
     * returned in Activity.onActivityResult
     */
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_running);
		context = this;

		Button buttonCancel = (Button) findViewById(R.id.button_cancel);
		TextView valorDistancia = (TextView) findViewById(R.id.valueDistancia);
		int roundedDistance = (int) Math.round(distance);
		valorDistancia.setText(Integer.toString(roundedDistance));
		buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	goToTrainingDetailActivity(v);
            }
        });

		SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		
        map = mapFrag.getMap();
//        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        map.setMyLocationEnabled(true);
//        
//        mLocationClient = new LocationClient(this, this, this);
//
//        if (servicesConnected()) {
//            mLocationRequest = LocationRequest.create();
//            mLocationRequest
//                            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//            mLocationRequest.setInterval(UPDATE_INTERVAL);
//            mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
//	    } else {
//	            Toast.makeText(context, "Position Unavailable", Toast.LENGTH_SHORT)
//	                            .show();
//	    }

        
//		 Location mCurrentLocation = mLocationClient.getLastLocation();
        if(servicesConnected()){
        
            map.setMyLocationEnabled(true);
 
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
 
            Criteria criteria = new Criteria();

            String provider = locationManager.getBestProvider(criteria, true);

            Location location = locationManager.getLastKnownLocation(provider);
 
            if(location!=null){
            	currentLocation = location;
                onLocationChanged(location);
            }
            
            locationManager.requestLocationUpdates(provider, 20000, 0, this);
        }
/*		 
        if (map!=null){
		      
			 Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG).title("Hamburg"));
		      
		      Marker kiel = map.addMarker(new MarkerOptions()
		          .position(KIEL)
		          .title("Kiel")
		          .snippet("Kiel is cool")
		          .icon(BitmapDescriptorFactory
		              .fromResource(R.drawable.ic_launcher)));
		      
		      Marker ciudad = map.addMarker(new MarkerOptions()
	          .position(CIUDAD_UNIVERSITARIA)
	          .title("Ciudad universitaria")
	          .snippet("Exactas is cool")
	          .icon(BitmapDescriptorFactory
	              .fromResource(R.drawable.ic_launcher)));
		      
		      
		   }
		 
		 map.moveCamera(CameraUpdateFactory.newLatLngZoom(CIUDAD_UNIVERSITARIA, 7));
		 
		 map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null); 
		 
	*/	 
	}
	
	  /**
     * Check that Google Play services is available
     * 
     * @return
     */
    private boolean servicesConnected() {
            int resultCode = GooglePlayServicesUtil
                            .isGooglePlayServicesAvailable(this);
            if (ConnectionResult.SUCCESS == resultCode) {
                    Log.d("Location Updates", "Google Play services is available.");
                    return true;
            } else {
                    Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(
                                    resultCode, this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
                    if (errorDialog != null) {
                            errorDialog.show();
                    }
                    return false;
            }
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
	
    @Override
    public void onLocationChanged(Location location) {
    	
    	ArrayList<LatLng> positions = new ArrayList<LatLng>();
    	if (currentMarker != null) {
    		positions.add(currentMarker.getPosition());
    		currentMarker.remove();
    	}
		
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
 
        LatLng coordinates = new LatLng(latitude, longitude);
        
        positions.add(coordinates);
        if (positions.size() > 1){
			drawPrimaryLinePath(positions);
		}
        
        Marker markerActual = map.addMarker(new MarkerOptions()
        .position(coordinates)
        .title("Posicion actual")
        .snippet("Exactas is cool")
        .icon(BitmapDescriptorFactory
            .fromResource(R.drawable.ic_launcher)));
        
        currentMarker = markerActual;
        
        CameraPosition cameraPosition = new CameraPosition.Builder()
        .target(coordinates)
        .zoom(15)                   
        .build();                   
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
		
		if (currentLocation != null){
			distance += location.distanceTo(currentLocation);
		}
		currentLocation = location;
		
		TextView valorDistancia = (TextView) findViewById(R.id.valueDistancia);
		valorDistancia.setText(new DecimalFormat("##.##").format(distance/1000) + " Km");
		
 
    }
	
    @Override
    public void onProviderDisabled(String provider) {
    	Toast.makeText( getApplicationContext(), "Gps Disabled", Toast.LENGTH_SHORT ).show();
    }
 
    @Override
    public void onProviderEnabled(String provider) {
    	Toast.makeText( getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT ).show();
    }
 
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }
    
    private void drawPrimaryLinePath( ArrayList<LatLng> locationsToDraw )
    {
        if ( map == null )
        {
            return;
        }

        if ( locationsToDraw.size() < 2 )
        {
            return;
        }

        PolylineOptions options = new PolylineOptions();

        options.color( Color.parseColor( "#CC0000FF" ) );
        options.width( 5 );
        options.visible( true );

        for ( LatLng locRecorded : locationsToDraw )
        {
            options.add(locRecorded);
        }

        map.addPolyline( options );

    }
    
//	@Override
//	protected void onStart() {
//		 super.onStart();
//	     // Connect the client.
//	     mLocationClient.connect();
//	}
//	
//	@Override
//    protected void onStop() {
//        // Disconnecting the client invalidates it.
//        mLocationClient.disconnect();
//        super.onStop();
//    }


//	@Override
//	public void onConnectionFailed(ConnectionResult arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onConnected(Bundle arg0) {
//		  Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
//	}
//
//	@Override
//	public void onDisconnected() {
//		// TODO Auto-generated method stub
//		
//	}

}
