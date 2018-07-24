package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_detail.xml layout file
        setContentView(R.layout.activity_detail);

        // Place details from MainActivity
        final String placeTitle = getIntent().getStringExtra("PLACE_NAME");
        final String placeDesc = getIntent().getStringExtra("PLACE_DESC");
        final String placeWebsite = getIntent().getStringExtra("PLACE_WEBSITE");
        final String placeAddress = getIntent().getStringExtra("PLACE_ADDRESS");
        final String placePhone = getIntent().getStringExtra("PLACE_PHONE");
        final int placeImage = getIntent().getIntExtra("PLACE_IMAGE", 0);

        // Find views for the selected Place
        TextView selectedPlaceTitleTextView = findViewById(R.id.toolbar_title);
        TextView selectedPlaceDescTextView = findViewById(R.id.place_desc);
        TextView selectedPlaceWebsiteTextView = findViewById(R.id.place_website);
        TextView selectedPlaceAddressTextView = findViewById(R.id.place_address);
        TextView selectedPlacePhoneTextView = findViewById(R.id.place_phone);
        ImageView selectedPlaceImageImageView = findViewById(R.id.background_image);

        // Set the TextViews for the values of the selected Place
        if (placeTitle.equals("") || placeTitle.equals("N/A")) {
            selectedPlaceTitleTextView.setVisibility(View.GONE);
        } else {
            selectedPlaceTitleTextView.setText(placeTitle);
        }

        if (placeDesc.equals("") || placeDesc.equals("N/A")){
            selectedPlaceDescTextView.setVisibility(View.GONE);
        } else {
            selectedPlaceDescTextView.setText(placeDesc);
        }

        if (placeWebsite.equals("") || placeWebsite.equals("N/A")){
            selectedPlaceWebsiteTextView.setVisibility(View.GONE);
        } else {
            selectedPlaceWebsiteTextView.setText(placeWebsite);
        }

        if (placeAddress.equals("") || placeAddress.equals("N/A")){
            selectedPlaceAddressTextView.setVisibility(View.GONE);
        } else {
            selectedPlaceAddressTextView.setText(placeAddress);
        }

        if (placePhone.equals("") || placePhone.equals("N/A")){
            selectedPlacePhoneTextView.setVisibility(View.GONE);
        } else {
            selectedPlacePhoneTextView.setText(placePhone);
        }

        // Display the Place Image
            selectedPlaceImageImageView.setImageResource(placeImage);

        // Set up the custom toolbar and back button
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!= null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Launch the maps when address button is clicked
        findViewById(R.id.place_address).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(placeAddress));
                if (geoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(geoIntent);
                }
            }
        });
    }

    // Make the up button behave like a back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
            onBackPressed();
            return true;
        }
        return (super.onOptionsItemSelected(item));
    }
}
