package com.example.diana.menutest1.places;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.diana.menutest1.MapsActivity;
import com.example.diana.menutest1.R;


import java.util.List;

/**
 * Created by Diana on 19.04.2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  {

    private List<Place> mData ;






    public RecyclerViewAdapter( List<Place> mData) {

        this.mData = mData;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardveiw_item_place, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

       // LayoutInflater mInflater = LayoutInflater.from(mContext);
       // view = mInflater.inflate(R.layout.cardveiw_item_place,parent,false);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               switch (position){
                   case 0:
                       Intent intent0=new Intent(v.getContext(),MapsActivity.class);
                       v.getContext().startActivity(intent0);
                       break;
                   case 1:
                       Intent intent1=new Intent(v.getContext(),MapsActivity.class);
                       v.getContext().startActivity(intent1);
                       break;
                   case 2:
                       Intent intent2=new Intent(v.getContext(),MapsActivity.class);
                       v.getContext().startActivity(intent2);
                       break;
                   case 3:
                       Intent intent3=new Intent(v.getContext(),MapsActivity.class);
                       v.getContext().startActivity(intent3);
                       break;
                   case 4:
                       Intent intent4=new Intent(v.getContext(),MapsActivity.class);
                       v.getContext().startActivity(intent4);
                       break;


               }

           }
            //    Intent intent = new Intent(v.getContext(), SecondPage.class);
              //  v.getContext().startActivity(intent);

             //   Toast.makeText(v.getContext(), "os version is: " + place.getTitle(), Toast.LENGTH_SHORT).show();

           //}
        });
      //  holder.cardView.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {

             //   Intent intent = new Intent(mContext,ArchitectureActivityMap.class);

                // passing data to the book activity
                //intent.putExtra("Title",mData.get(position).getTitle());

               // intent.putExtra("Thumbnail",mData.get(position).getThumbnail());

                // start the activity
               // mContext.startActivity(intent);

          // }
      // });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

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
