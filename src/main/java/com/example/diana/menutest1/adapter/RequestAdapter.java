package com.example.diana.menutest1.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;
import io.realm.RealmResults;


import com.example.diana.menutest1.R;
import com.example.diana.menutest1.app.EditRequestActivity;
import com.example.diana.menutest1.model.Friends;
import com.example.diana.menutest1.model.Request;

/**
 * Created by Diana on 18.02.2019.
 */

public class RequestAdapter  extends RecyclerView.Adapter<RequestAdapter.FriendHolder>{

    private Context context;
    private Realm realm;
    private RealmResults<Request> realmResults;
    private LayoutInflater inflater;
    private Request request;

    public RequestAdapter(Context context, Realm realm, RealmResults<Friends> request) {

        this.context = context;
        this.realm = realm;
//        this.realmResults = request;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public FriendHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = inflater.inflate(R.layout.request_list_layout, null);
        FriendHolder holder = new FriendHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RequestAdapter.FriendHolder holder, int position) {
        request = realmResults.get(position);
        holder.boundData(request, position);
        holder.setListener();
    }



    @Override
    public int getItemCount() {
        return realmResults.size();
    }

    public class FriendHolder extends RecyclerView.ViewHolder {
        private Integer position;
        private TextView location_tv, name_tv, author_tv;
        private ImageView editImage, deleteImage;

        public FriendHolder(View itemView) {
            super(itemView);
            location_tv = itemView.findViewById(R.id.location_text_view);
            name_tv = itemView.findViewById(R.id.name_text_view);
            author_tv = itemView.findViewById(R.id.author_text_view);
//            date_tv = itemView.findViewById(R.id.date_text_view);

            editImage = itemView.findViewById(R.id.edit_image_view);
            deleteImage = itemView.findViewById(R.id.delete_image_view);
        }

        public void boundData(Request request, Integer position) {
            this.position = position;

            location_tv.setText(request.getLocation());
            name_tv.setText(request.getName());
            author_tv.setText(request.getAuthor());
//            date_tv.setText("дата " + request.getDate());

        }

        public void setListener() {

            editImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, EditRequestActivity.class);
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }
            });

            deleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realmResults.deleteFromRealm(position);
                            Toasty.error(context,
                                    "Удалить сотрудника из списка",
                                    Toast.LENGTH_LONG).show();
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, realmResults.size());
                        }
                    });

                }
            });

            name_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    request = realmResults.get(position);

                    Dialog dialog = new Dialog(context, R.style.appDialog);
                    dialog.setTitle("Детальная информация о сотруднике");
                    dialog.setContentView(R.layout.dialog_list);
                    dialog.setCanceledOnTouchOutside(true);

//                    TextView tv1 = dialog.findViewById(R.id.location_detail);
//                    TextView tv2 = dialog.findViewById(R.id.name_detail);
//                    TextView tv3 = dialog.findViewById(R.id.author_detail);
////                    TextView tv4 = dialog.findViewById(R.id.date_detail);

//                    tv1.setText("локация  \n\n" + request.getLocation()+ "\n");
//                    tv2.setText("название \n\n" + request.getName() + "\n");
//                    tv3.setText("автор \n\n" + request.getAuthor() + "\n");
////                    tv4.setText("дата \n\n" + request.getDate());

                    dialog.show();

                }
            });

        }
    }
}
