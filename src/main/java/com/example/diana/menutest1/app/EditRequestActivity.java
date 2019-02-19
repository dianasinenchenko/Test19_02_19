package com.example.diana.menutest1.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diana.menutest1.MainActivity;
import com.example.diana.menutest1.R;
import com.example.diana.menutest1.model.Request;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Diana on 18.02.2019.
 */

public class EditRequestActivity extends AppCompatActivity{

    private EditText location_et, name_et, author_et;
    private Realm myRealm;
    Bundle bundle;
    int position;
    private Request request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_request);

        bundle = getIntent().getExtras();
        if (bundle != null)
            position = bundle.getInt("position");

        location_et = findViewById(R.id.edit_location_edit_text);
        name_et = findViewById(R.id.edit_name_edit_text);
        author_et = findViewById(R.id.edit_author_edit_text);
//        date_et = findViewById(R.id.edit_date_edit_text);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myRealm = Realm.getDefaultInstance();
        RealmResults<Request> realmResults = myRealm.where(Request.class).findAll();
        request = realmResults.get(position);
        setupFriends(request);
    }

    public void setupFriends(Request request) {

        location_et.setText(request.getLocation());
        name_et.setText(request.getName());
        author_et.setText(request.getAuthor());
//        date_et.setText("" + request.getDate());
    }

    public void editFriend(View view) {

        myRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                request.setLocation(location_et.getText().toString().trim());
                request.setName(name_et.getText().toString().trim());
                request.setAuthor(author_et.getText().toString().trim());
//                request.setDate(Double.parseDouble(date_et.getText().toString()));

                Toasty.success(EditRequestActivity.this,
                        "Обновление прошло успешно",
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(EditRequestActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myRealm.close();
    }
}
