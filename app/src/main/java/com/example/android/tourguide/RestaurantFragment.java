package com.example.android.tourguide;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
public class RestaurantFragment extends Fragment {

    public ArrayList<Place> PlaceList = new ArrayList<>();
    RecyclerView recyclerView;

    private Context mContext;

    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Initialize context from onAttach()
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create the ArrayList data
        PlaceList.add(new Place(getString(R.string.place_22_title),
                getString(R.string.place_22_desc),
                getString(R.string.place_22_address),
                getString(R.string.place_22_phone),
                getString(R.string.place_22_website),
                R.drawable.cafe_sunflower));

        PlaceList.add(new Place(getString(R.string.place_23_title),
                getString(R.string.place_23_desc),
                getString(R.string.place_23_address),
                getString(R.string.place_23_phone),
                getString(R.string.place_23_website),
                R.drawable.mccormick_schmick));

        PlaceList.add(new Place(getString(R.string.place_24_title),
                getString(R.string.place_24_desc),
                getString(R.string.place_24_address),
                getString(R.string.place_24_phone),
                getString(R.string.place_24_website),
                R.drawable.mckendrick));

        PlaceList.add(new Place(getString(R.string.place_25_title),
                getString(R.string.place_25_desc),
                getString(R.string.place_25_address),
                getString(R.string.place_25_phone),
                getString(R.string.place_25_website),
                R.drawable.nuevo_laredo));

        PlaceList.add(new Place(getString(R.string.place_26_title),
                getString(R.string.place_26_desc),
                getString(R.string.place_26_address),
                getString(R.string.place_26_phone),
                getString(R.string.place_26_website),
                R.drawable.nan_thai_fine_dining));

        PlaceList.add(new Place(getString(R.string.place_27_title),
                getString(R.string.place_27_desc),
                getString(R.string.place_27_address),
                getString(R.string.place_27_phone),
                getString(R.string.place_27_website),
                R.drawable.maggiano_italy));

        PlaceList.add(new Place(getString(R.string.place_28_title),
                getString(R.string.place_28_desc),
                getString(R.string.place_28_address),
                getString(R.string.place_28_phone),
                getString(R.string.place_28_website),
                R.drawable.ecco));

        PlaceList.add(new Place(getString(R.string.place_29_title),
                getString(R.string.place_29_desc),
                getString(R.string.place_29_address),
                getString(R.string.place_29_phone),
                getString(R.string.place_29_website),
                R.drawable.rumi_kitchen));

        // Create a standard LinearLayout manager to control how the recycler works
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        // create an adapter based on the custom class you created
        PlaceAdapter placeAdapter = new PlaceAdapter(mContext, PlaceList);

        // Find your recycler and set your layoutManager and adapter to it
        recyclerView = rootView.findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(placeAdapter);

        return rootView;

    }

}
