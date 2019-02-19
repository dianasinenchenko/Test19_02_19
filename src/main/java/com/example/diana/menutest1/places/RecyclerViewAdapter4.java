package com.example.diana.menutest1.places;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diana.menutest1.R;

import java.util.List;

/**
 * Created by Diana on 19.05.2018.
 */

public class RecyclerViewAdapter4 extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>   {
    private List<Place> mData ;


    public RecyclerViewAdapter4 ( List<Place> mData) {

        this.mData = mData;
    }



    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardveiw_item_place, parent, false);
        RecyclerViewAdapter.MyViewHolder myViewHolder = new RecyclerViewAdapter.MyViewHolder(view);

        // LayoutInflater mInflater = LayoutInflater.from(mContext);
        // view = mInflater.inflate(R.layout.cardveiw_item_place,parent,false);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, final int position2) {
        holder.tv_book_title.setText(mData.get(position2).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position2).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position2){
                    case 0:
                        Intent intent0=new Intent(v.getContext(),MapsM.class);
                        v.getContext().startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1=new Intent(v.getContext(),MapsM.class);
                        v.getContext().startActivity(intent1);
                        break;


                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView ;
        public Place place;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.place_title_id) ;
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.place_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Intent intent = new Intent(view.getContext(), ArchitectureActivityMap.class);
                    //  view.getContext().startActivity(intent);

                    //  Toast.makeText(view.getContext(), "os version is: " + place.getTitle(), Toast.LENGTH_SHORT).show();


                }
            });



        }
    }
}
