package com.example.diana.menutest1.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diana.menutest1.R;
import com.example.diana.menutest1.model.Request;

import java.util.UUID;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;
import io.realm.RealmAsyncTask;

/**
 * Created by Diana on 18.02.2019.
 */

public class AddRequestActivity extends AppCompatActivity {

    private EditText location_et, name_et, author_et;
    private Realm myRealm;
    private RealmAsyncTask realmAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        myRealm = Realm.getDefaultInstance();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        location_et = findViewById(R.id.location_edit_text);
//        name_et = findViewById(R.id.name_edit_text);
//        author_et = findViewById(R.id.author_edit_text);
////        date_et = findViewById(R.id.date_edit_text);



    }

    public void addRequest (View view) {

        final String id = UUID.randomUUID().toString();
        final String location = location_et.getText().toString().trim();
        final String name = name_et.getText().toString().trim();
        final String author = author_et.getText().toString().trim();
//        final String date = date_et.getText().toString();

        if (location.isEmpty()) {
            Toasty.info(AddRequestActivity.this,
                    "Введите локацию", Toast.LENGTH_LONG).show();
            return;
        }

        if (name.isEmpty()) {
            Toasty.info(AddRequestActivity.this,
                    "Введите названеи", Toast.LENGTH_LONG).show();
            return;
        }

        if (author.isEmpty()) {
            Toasty.info(AddRequestActivity.this,
                    "Введите автора", Toast.LENGTH_LONG).show();
            return;
        }

//        if (date.isEmpty()) {
//            Toasty.info(AddRequestActivity.this,
//                    "Введите дату", Toast.LENGTH_LONG).show();
//            return;
//        }

        realmAsyncTask = myRealm.executeTransactionAsync(new Realm.Transaction() {
                                                             @Override
                                                             public void execute(Realm realm) {
                                                                 Request request = realm.createObject(Request.class, id);
                                                                 request.setLocation(location);
                                                                 request.setName(name);
                                                                 request.setAuthor(author);
//                                                                 request.setDate(Double.parseDouble(date));
                                                             }
                                                         },
                new Realm.Transaction.OnSuccess() {
                    @Override
                    public void onSuccess() {
                        Toasty.success(AddRequestActivity.this,
                                "Заявка добавлена успешно", Toast.LENGTH_LONG).show();

                        location_et.setText("");
                        name_et.setText("");
                        author_et.setText("");
//                        date_et.setText("");
                    }
                }
                ,
                new Realm.Transaction.OnError() {
                    @Override
                    public void onError(Throwable error) {
                        Toasty.error(AddRequestActivity.this,
                                "Ошибка добавления", Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (realmAsyncTask != null && !realmAsyncTask.isCancelled()) {
            realmAsyncTask.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myRealm.close();
    }
}
