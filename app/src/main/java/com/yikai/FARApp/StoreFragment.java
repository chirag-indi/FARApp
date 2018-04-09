package com.yikai.FARApp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Yikai on 2016/5/29.
 */
public class StoreFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_store, container, false);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        return  rootview;

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        MapFragment mapFragment = new MapFragment();

        mapFragment.getMapAsync(this);

        ft.replace(R.id.contain_map, mapFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng ourstore = new LatLng(32.998, -96.732);
        mMap.addMarker(new MarkerOptions().position(ourstore).title("Our store"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ourstore));

        float zoom=12;

        CameraPosition cameraPosition = new CameraPosition(ourstore, zoom, 0, 0);


        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


    }
}
