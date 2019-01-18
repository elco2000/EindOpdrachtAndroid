package com.example.elcoo.blijdorpapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.errors.ApiException;

import java.io.IOException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private String TAG;

    public MapsActivity() throws InterruptedException, ApiException, IOException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        int route = getIntent().getIntExtra("ROUTE", 0);


        mapFragment.getMapAsync(this);


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
    @SuppressLint("SetTextI18n")
    @Override
    public void onMapReady(GoogleMap googleMap) {


        final LatLng VISSEN = new LatLng(51.928579, 4.445204);
        final LatLng IJSBEREN = new LatLng(51.927431, 4.444811);
        final LatLng VLINDERS = new LatLng(51.927852, 4.446774);
        final LatLng LEEUWEN = new LatLng(51.928423, 4.450094);
        final LatLng GIRAFFEN = new LatLng(51.925633, 4.449941);
        final LatLng KAMELEN = new LatLng(51.928137, 4.453134);
        final LatLng GORILLAS = new LatLng(51.925087, 4.451513);

        int route = getIntent().getIntExtra("ROUTE", 0);
//        SQLiteDatabase blijdorpDB = this.openOrCreateDatabase("blijdorpDB", MODE_PRIVATE, null);


        mMap = googleMap;

        LatLng sydney2 = new LatLng(51.928168, 4.444017);
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Marker in Blijdorp"));
        TextView textView2 = (TextView) findViewById(R.id.textView2);


        if (route == 0) {
            // Add a marker in Sydney and move the camera
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney2));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney2, 18));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

            textView2.setText("  Diergaarde \n  Blijdorp");

            Marker vissen = mMap.addMarker(new MarkerOptions()
                    .position(VISSEN)
                    .title("Vissen")
                    .snippet("Voedertijden: 14:00, 15:00, 16:00"));

            Marker ijsberen = mMap.addMarker(new MarkerOptions()
                    .position(IJSBEREN)
                    .title("Ijsberen")
                    .snippet("Voedertijden: 14:30, 15:30, 16:30"));

            Marker vlinders = mMap.addMarker(new MarkerOptions()
                    .position(VLINDERS)
                    .title("Vlinders")
                    .snippet("Voedertijden: 14:15, 15:15, 16:15"));

            Marker leeuwen = mMap.addMarker(new MarkerOptions()
                    .position(LEEUWEN)
                    .title("Leeuwen")
                    .snippet("Voedertijden: 14:00, 15:00, 16:00"));

            Marker giraffen = mMap.addMarker(new MarkerOptions()
                    .position(GIRAFFEN)
                    .title("Giraffen")
                    .snippet("Voedertijden: 13:30, 14:30, 15:30"));

            Marker kamelen = mMap.addMarker(new MarkerOptions()
                    .position(KAMELEN)
                    .title("Kamelen")
                    .snippet("Voedertijden: 13:15, 14:15, 15:15"));

            Marker gorillas = mMap.addMarker(new MarkerOptions()
                    .position(GORILLAS)
                    .title("Gorillas")
                    .snippet("Voedertijden: 13:20, 14:20, 15:20"));


        }

        if (route == 1) {

            textView2.setText("  14:00 - Vissen \n  14:30 - IJsberen \n  15:30 - Giraffen");

            // Add a marker in Sydney and move the camera
            Marker vissen = mMap.addMarker(new MarkerOptions()
                    .position(VISSEN)
                    .title("Vissen")
                    .snippet("Voedertijden: 14:00, 15:00, 16:00"));

            Marker ijsberen = mMap.addMarker(new MarkerOptions()
                    .position(IJSBEREN)
                    .title("Ijsberen")
                    .snippet("Voedertijden: 14:30, 15:30, 16:30"));

            Marker giraffen = mMap.addMarker(new MarkerOptions()
                    .position(GIRAFFEN)
                    .title("Giraffen")
                    .snippet("Voedertijden: 13:30, 14:30, 15:30"));

            mMap.moveCamera(CameraUpdateFactory.newLatLng(VISSEN));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(VISSEN, 18));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

        }

        if (route == 2) {
            textView2.setText("  14:15 - Vlinders \n  15:15 - Kamelen \n  16:00 - Leeuwen");

            Marker vlinders = mMap.addMarker(new MarkerOptions()
                    .position(VLINDERS)
                    .title("Vlinders")
                    .snippet("Voedertijden: 14:15, 15:15, 16:15"));

            Marker leeuwen = mMap.addMarker(new MarkerOptions()
                    .position(LEEUWEN)
                    .title("Leeuwen")
                    .snippet("Voedertijden: 14:00, 15:00, 16:00"));

            Marker kamelen = mMap.addMarker(new MarkerOptions()
                    .position(KAMELEN)
                    .title("Kamelen")
                    .snippet("Voedertijden: 13:15, 14:15, 15:15"));
            // Add a marker in Sydney and move the camera
            mMap.moveCamera(CameraUpdateFactory.newLatLng(VLINDERS));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(VLINDERS, 18));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

        }

        if (route == 3) {

            textView2.setText("  13:30 - Giraffen \n  14:00 - Kamelen \n  15:30 - IJsberen");
            Marker leeuwen = mMap.addMarker(new MarkerOptions()
                    .position(LEEUWEN)
                    .title("Leeuwen")
                    .snippet("Voedertijden: 14:00, 15:00, 16:00"));

            Marker giraffen = mMap.addMarker(new MarkerOptions()
                    .position(GIRAFFEN)
                    .title("Giraffen")
                    .snippet("Voedertijden: 13:30, 14:30, 15:30"));

            Marker ijsberen = mMap.addMarker(new MarkerOptions()
                    .position(IJSBEREN)
                    .title("Ijsberen")
                    .snippet("Voedertijden: 14:30, 15:30, 16:30"));
            // Add a marker in Sydney and move the camera
            mMap.moveCamera(CameraUpdateFactory.newLatLng(GIRAFFEN));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GIRAFFEN, 18));
            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomIn());
            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

        }
        // 51.928579, 4.445204 Vissen


//        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
//                .clickable(true)
//                .add(
//                        new LatLng(51.928579, 4.445204),
//                        new LatLng(51.927431, 4.444811)));





    }


    //    public void getFish(){
//        SQLiteDatabase blijdorpDB = this.openOrCreateDatabase("blijdorpDB", MODE_PRIVATE, null);
//
//
//        Cursor c = blijdorpDB.rawQuery("SELECT * FROM animal WHERE Name = 'vissen'",
//                null);
//        int Column1 = c.getColumnIndex("Name");
//        int Column2 = c.getColumnIndex("Description");
//        c.moveToLast();
//        String Name = c.getString(Column1);
//        String Description = c.getString(Column2);
//
//
//    }
//    LatLng origin = new LatLng(51.928579, 4.445204);
//    LatLng destination = new LatLng(51.928423, 4.450094);


//    private GeoApiContext getGeoContext() {
//        GeoApiContext geoApiContext = new GeoApiContext();
//        return geoApiContext.setQueryRateLimit(3).setApiKey(String.valueOf("AIzaSyDogPD1i_MgKzjOhnPX1fnhtYTep1VS8LQ")).setConnectTimeout(1, TimeUnit.SECONDS).setReadTimeout(1, TimeUnit.SECONDS).setWriteTimeout(1, TimeUnit.SECONDS);
//    }
//
//    DateTime now = new DateTime();
//    DirectionsResult result = DirectionsApi.newRequest(getGeoContext()).mode(TravelMode.WALKING).origin(String.valueOf(origin)).destination(String.valueOf(destination)).departureTime(now).await();
//
//    private void addPolyline(DirectionsResult results, GoogleMap mMap) {
//        List<LatLng> decodedPath = PolyUtil.decode(results.routes[0].overviewPolyline.getEncodedPath());
//        mMap.addPolyline(new PolylineOptions().addAll(decodedPath));
//    }
}

