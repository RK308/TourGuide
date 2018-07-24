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

import java.util.ArrayList;

/**
 *  {@link Fragment} that displays the list of attractions.
 */
public class AttractionFragment extends Fragment {

    public ArrayList<Place> PlaceList = new ArrayList<>();
    RecyclerView recyclerView;

    private Context mContext;

    public AttractionFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create the ArrayList data
        PlaceList.add(new Place(getString(R.string.place_1_title),
                getString(R.string.place_1_desc),
                getString(R.string.place_1_address),
                getString(R.string.place_1_phone),
                getString(R.string.place_1_website),
                R.drawable.aquarium));

        PlaceList.add(new Place(getString(R.string.place_2_title),
                getString(R.string.place_2_desc),
                getString(R.string.place_2_address),
                getString(R.string.place_2_phone),
                getString(R.string.place_2_website),
                R.drawable.history_center));

        PlaceList.add(new Place(getString(R.string.place_3_title),
                getString(R.string.place_3_desc),
                getString(R.string.place_3_address),
                getString(R.string.place_3_phone),
                getString(R.string.place_3_website),
                R.drawable.zoo));

        PlaceList.add(new Place(getString(R.string.place_4_title),
                getString(R.string.place_4_desc),
                getString(R.string.place_4_address),
                getString(R.string.place_4_phone),
                getString(R.string.place_4_website),
                R.drawable.six_flags));

        PlaceList.add(new Place(getString(R.string.place_5_title),
                getString(R.string.place_5_desc),
                getString(R.string.place_5_address),
                getString(R.string.place_5_phone),
                getString(R.string.place_5_website),
                R.drawable.cnn));

        PlaceList.add(new Place(getString(R.string.place_6_title),
                getString(R.string.place_6_desc),
                getString(R.string.place_6_address),
                getString(R.string.place_6_phone),
                getString(R.string.place_6_website),
                R.drawable.stone_mountain));

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
