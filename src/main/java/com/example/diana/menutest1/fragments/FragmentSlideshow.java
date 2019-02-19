package com.example.diana.menutest1.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.diana.menutest1.MainActivity;
import com.example.diana.menutest1.R;
import com.example.diana.menutest1.places.ArchitectureActivityMap;
import com.example.diana.menutest1.places.Place;
import com.example.diana.menutest1.places.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentSlideshow.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentSlideshow#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSlideshow extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    List<Place> lstPlace;
    private OnFragmentInteractionListener mListener;


    public FragmentSlideshow() {
        // Required empty public constructor



    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSlideshow.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSlideshow newInstance(String param1, String param2) {
        FragmentSlideshow fragment = new FragmentSlideshow();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);




        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);


        RecyclerView recyclerView =  (RecyclerView) view.findViewById(R.id.recyclerview_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        lstPlace = new ArrayList<>();
//        lstPlace.add(new Place("Соборы / Храмы / Церкви",R.drawable.sobor));
//        lstPlace.add(new Place("Сооружения",R.drawable.soorush));
//        lstPlace.add(new Place("Фонтаны",R.drawable.fontani));
//        lstPlace.add(new Place("Музеи",R.drawable.muse));
//        lstPlace.add(new Place("Памятники",R.drawable.pamatka));





        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(lstPlace);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return view;
    }





    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);





        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }




}
