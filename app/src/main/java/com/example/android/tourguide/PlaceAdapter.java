package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {

    private LayoutInflater mInflater;
    private ArrayList<Place> PlaceList;

   // Create the actual method of performing the recycler
    public PlaceAdapter (Context context, ArrayList<Place> PlaceList){
        this.mInflater = LayoutInflater.from(context);
        this.PlaceList = PlaceList;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.place_list_item, parent, false);
        return new PlaceHolder(view);
    }

    // Binds the Array data to the particular layout views
    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, int position) {
        final Place currentPlace = PlaceList.get(position);

        holder.placeTitle.setText(currentPlace.getPlaceTitle());
        holder.placePhotoId.setImageResource(currentPlace.getPlacePhotoId());

        // On Click Listener that goes to the selected Place's activity_details page
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent placeDetailsIntent = new Intent(v.getContext(),DetailsActivity.class);

                // Add place details BUNDLE to be sent to DetailsActivity
                placeDetailsIntent.putExtra("PLACE TITLE",currentPlace.getPlaceTitle());
                placeDetailsIntent.putExtra("PLACE DETAIL",currentPlace.getPlaceDetail());
                placeDetailsIntent.putExtra("PLACE WEBSITE",currentPlace.getPlaceWebsite());
                placeDetailsIntent.putExtra("PLACE PHONE",currentPlace.getPlacePhone());
                placeDetailsIntent.putExtra("PLACE ADDRESS",currentPlace.getPlaceAddress());
                placeDetailsIntent.putExtra("PLACE IMAGE",currentPlace.getPlacePhotoId());
                v.getContext().startActivity(placeDetailsIntent);
            }
        });
    }

    // Returns the array size
    @Override
    public int getItemCount(){
        return PlaceList.size();
    }

    //This is a custom holder which is how your data binding occurs, this is where the ids are assigned.
    class PlaceHolder extends  RecyclerView.ViewHolder{
        private TextView placeTitle;
        private ImageView placePhotoId;

        private PlaceHolder(View placeView){
            super(placeView);
            placeTitle = placeView.findViewById(R.id.place_title);
            placePhotoId = placeView.findViewById(R.id.place_image);
        }
    }
}
