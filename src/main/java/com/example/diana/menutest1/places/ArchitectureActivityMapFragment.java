package com.example.diana.menutest1.places;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.diana.menutest1.R;

/**
 * Created by Diana on 22.04.2018.
 */

@SuppressLint("ValidFragment")
class ArchitectureActivityMapFragment   extends android.support.v4.app.Fragment {
    private TextView title;
    private int index;

    public ArchitectureActivityMapFragment() { }

    public static ArchitectureActivityMapFragment newInstance(int i) {
        ArchitectureActivityMapFragment f = new ArchitectureActivityMapFragment();
        Bundle args = new Bundle();
        args.putInt("INDEX", i);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_architecture_activity_map, container, false);
        title = (TextView) view.findViewById(R.id.title );

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) index = args.getInt("INDEX", 0);


        title.setText( ArchitectureActivityMapAdapter.TITLES_test[index]);
    }

}
