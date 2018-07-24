package com.example.android.tourguide;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumFragment extends Fragment {

    public ArrayList<Place> PlaceList = new ArrayList<>();
    RecyclerView recyclerView;

    private Context mContext;

    public MuseumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Intialize context from onAttach()
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.places_list,container,false);

        // Create the ArrayList data
        PlaceList.add(new Place(getString(R.string.place_8_title),
                getString(R.string.place_8_desc),
                getString(R.string.place_8_address),
                getString(R.string.place_8_phone),
                getString(R.string.place_8_website),
                R.drawable.coca_cola));

        PlaceList.add(new Place(getString(R.string.place_9_title),
                getString(R.string.place_9_desc),
                getString(R.string.place_9_address),
                getString(R.string.place_9_phone),
                getString(R.string.place_9_website),
                R.drawable.college_football_hall));

        PlaceList.add(new Place(getString(R.string.place_10_title),
                getString(R.string.place_10_desc),
                getString(R.string.place_10_address),
                getString(R.string.place_10_phone),
                getString(R.string.place_10_website),
                R.drawable.mlk_jr));

        PlaceList.add(new Place(getString(R.string.place_11_title),
                getString(R.string.place_11_desc),
                getString(R.string.place_11_address),
                getString(R.string.place_11_phone),
                getString(R.string.place_11_website),
                R.drawable.cyclorama));

        PlaceList.add(new Place(getString(R.string.place_12_title),
                getString(R.string.place_12_desc),
                getString(R.string.place_12_address),
                getString(R.string.place_12_phone),
                getString(R.string.place_12_website),
                R.drawable.fernbank_museum));

        PlaceList.add(new Place(getString(R.string.place_13_title),
                getString(R.string.place_13_desc),
                getString(R.string.place_13_address),
                getString(R.string.place_13_phone),
                getString(R.string.place_13_website),
                R.drawable.braves_museum));

        // Create a standard LinearLayout manager to control how the recycler works
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        // create an adapter based on the custom class you created
        PlaceAdapter placeAdapter = new PlaceAdapter(mContext,PlaceList);

        // Find your recycler and set your layoutManager and adapter to it
        recyclerView = rootView.findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(placeAdapter);

        return rootView;
    }

}
