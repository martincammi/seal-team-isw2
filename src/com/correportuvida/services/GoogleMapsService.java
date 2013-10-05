package com.correportuvida.services;

import android.app.Dialog;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.correportuvida.model.base.TimeLapse;
import com.correportuvida.model.interfaces.Reportable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Service to interact with the google maps.
 *
 */
public class GoogleMapsService {
	
	private Context context;
	private FragmentActivity fragmentActivity;
	private FragmentManager fragmentManager;
	private int mapId;
	private GoogleMap googleMap;
	private Location currentLocation;
	private TimeLapse timeLapseForUpdate;
	private LocationListener _locationListener;
	
	public GoogleMapsService(Context context, FragmentActivity fragmentActivity, FragmentManager fragmentManager, int mapId) {
		this.context = context;
		this.fragmentActivity = fragmentActivity;
		this.fragmentManager = fragmentManager;
		this.mapId = mapId;
		this.googleMap = getGoogleMap();
	}

	private GoogleMap getGoogleMap() {
		
		int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getContext());
		
		 // Showing status
	    if(status != ConnectionResult.SUCCESS){ // Google Play Services are not available

	        int requestCode = 10;
	        Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, fragmentActivity, requestCode);
	        dialog.show();
	        return null;
	    }else{
	    	Log.d("Location Updates", "Google Play services is available.");
	    	SupportMapFragment mapFrag = (SupportMapFragment) getFragmentManager().findFragmentById(mapId);
	    	return mapFrag.getMap();
	    }
	}
	
	public boolean servicesConnected(){
		  return googleMap != null;
	}
	
	public Location getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * Updates the current location every TimeLapse seconds.
	 */
	public void startProcessingLocation(final Reportable reportable, TimeLapse timeLapse){
	
		timeLapseForUpdate = timeLapse;
		
		_locationListener = new LocationListener() {
			
			@Override
			public void onLocationChanged(Location location) {
				currentLocation = location;
				reportable.report();
			}
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			
			@Override
			public void onProviderEnabled(String provider) {}
			
			@Override
			public void onProviderDisabled(String provider) {}
		
		};
		
		LocationManager locationManager = getLocationManager(); 
		Criteria criteria = new Criteria();
		String provider = locationManager.getBestProvider(criteria, true);
		locationManager.requestLocationUpdates(provider, timeLapse.getLapse() , 0, _locationListener);
	}
	
	public void drawBlueMarker(LatLng latlong, String iconTitle){
		String snippet = "Lat:" + latlong.latitude + "Lng:"+ latlong.longitude;
		BitmapDescriptor icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);
		drawMarker(latlong, snippet, icon, iconTitle);
	}
	
	public Marker drawMarker(LatLng latlng, String snippet, BitmapDescriptor icon, String iconTitle){
		
		if(latlng != null){
			
			MarkerOptions markerOptions = new MarkerOptions();
			markerOptions.position(latlng);
			markerOptions.snippet(snippet);
			markerOptions.icon(icon).title(iconTitle);
			
			Marker marker = googleMap.addMarker(markerOptions);
			
			
	        return marker;
		}
		
		return null;
	}
	
	private LocationManager getLocationManager(){
		return (LocationManager) fragmentActivity.getSystemService(Context.LOCATION_SERVICE);
	}
	
	public void moveToPositionInGoogleMapWithEffect(Marker marker){
		
		LatLng position = marker.getPosition();
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 7));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null); 
	}
	
	public void moveToPositionInGoogleMap(Marker marker){
		
		LatLng position = marker.getPosition();
		CameraPosition cameraPosition = new CameraPosition.Builder()
	    .target(position)
	    .zoom(15)                   
	    .build();                   
	    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}
	
	public static LatLng getLatLng(Location location){
		double latitude = location.getLatitude();
	    double longitude = location.getLongitude();
	 
	    LatLng coordinates = new LatLng(latitude, longitude);
	    return coordinates;
	}
	
	
	public TimeLapse getTimeLapseForUpdate() {
		return timeLapseForUpdate;
	}

	public void addPolyLine(PolylineOptions options){
		googleMap.addPolyline(options);
	}
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public FragmentManager getFragmentManager() {
		return fragmentManager;
	}

	public void setFragmentManager(FragmentManager fragmentManager) {
		this.fragmentManager = fragmentManager;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public void stopMapRefreshing() {
		getLocationManager().removeUpdates(_locationListener);
	}
	
	
}
