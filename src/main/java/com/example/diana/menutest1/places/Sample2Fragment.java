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
 * Created by Diana on 19.05.2018.
 */

@SuppressLint("ValidFragment")
class Sample2Fragment extends android.support.v4.app.Fragment{
    private TextView title;
    private int index;

    public Sample2Fragment() { }

    public static Sample2Fragment newInstance(int i) {
        Sample2Fragment f = new Sample2Fragment();
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
        View view = inflater.inflate(R.layout.fragment_sample_1, container, false);
        title = (TextView) view.findViewById(R.id.title );

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) index = args.getInt("INDEX", 0);


        title.setText( Sample2Adapter.TITLES_test[index]);
    }

}
