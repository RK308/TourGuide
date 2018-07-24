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
public class HotelFragment extends Fragment {

    public ArrayList<Place> PlaceList = new ArrayList<>();
    RecyclerView recyclerView;

    private Context mContext;

    public HotelFragment() {
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
        View rootView = inflater.inflate(R.layout.places_list,container,false);

        // Create the ArrayList data
        PlaceList.add(new Place(getString(R.string.place_14_title),
                getString(R.string.place_14_desc),
                getString(R.string.place_14_address),
                getString(R.string.place_14_phone),
                getString(R.string.place_14_website),
                R.drawable.intercontinental));

        PlaceList.add(new Place(getString(R.string.place_15_title),
                getString(R.string.place_15_desc),
                getString(R.string.place_15_address),
                getString(R.string.place_15_phone),
                getString(R.string.place_15_website),
                R.drawable.four_seasons));

        PlaceList.add(new Place(getString(R.string.place_16_title),
                getString(R.string.place_16_desc),
                getString(R.string.place_16_address),
                getString(R.string.place_16_phone),
                getString(R.string.place_16_website),
                R.drawable.ritz_carlton));

        PlaceList.add(new Place(getString(R.string.place_17_title),
                getString(R.string.place_17_desc),
                getString(R.string.place_17_address),
                getString(R.string.place_17_phone),
                getString(R.string.place_17_website),
                R.drawable.mandarin_oriental));

        PlaceList.add(new Place(getString(R.string.place_18_title),
                getString(R.string.place_18_desc),
                getString(R.string.place_18_address),
                getString(R.string.place_18_phone),
                getString(R.string.place_18_website),
                R.drawable.sheraton_hotel));

        PlaceList.add(new Place(getString(R.string.place_19_title),
                getString(R.string.place_19_desc),
                getString(R.string.place_19_address),
                getString(R.string.place_19_phone),
                getString(R.string.place_19_website),
                R.drawable.westin));

        PlaceList.add(new Place(getString(R.string.place_20_title),
                getString(R.string.place_20_desc),
                getString(R.string.place_20_address),
                getString(R.string.place_20_phone),
                getString(R.string.place_20_website),
                R.drawable.ellis_hotel));

        PlaceList.add(new Place(getString(R.string.place_21_title),
                getString(R.string.place_21_desc),
                getString(R.string.place_21_address),
                getString(R.string.place_21_phone),
                getString(R.string.place_21_website),
                R.drawable.sheraton_suites));


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
