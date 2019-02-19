package com.example.diana.menutest1;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diana.menutest1.adapter.AddRequestActivity;
import com.example.diana.menutest1.adapter.FriendAdapter;
import com.example.diana.menutest1.adapter.RequestAdapter;
import com.example.diana.menutest1.app.AddActivity;
import com.example.diana.menutest1.fragments.FragmentGallery;
import com.example.diana.menutest1.fragments.FragmentSend;
import com.example.diana.menutest1.fragments.FragmentShare;
import com.example.diana.menutest1.fragments.FragmentSlideshow;
import com.example.diana.menutest1.fragments.FragmentTools;
import com.example.diana.menutest1.fragments.FragmentImport;
import com.example.diana.menutest1.model.Friends;
import com.example.diana.menutest1.model.Request;
import com.example.diana.menutest1.places.ArchitectureActivityMap;
import com.example.diana.menutest1.places.Place;
import com.example.diana.menutest1.places.RecyclerViewAdapter;


import java.util.ArrayList;
import java.util.List;

import com.example.diana.menutest1.places.Utils;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.*;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    FragmentImport fragmentImport;
    FragmentGallery fragmentGallery;
    FragmentSend fragmentSend;
    FragmentShare fragmentShare;
    FragmentSlideshow fragmentSlideshow;
    FragmentTools fragmentTools;
    List<Place> lstPlace ;
    private AccessToken accessToken;
    MapsActivity mapsActivity;



    private Realm myRealm;
    private RealmResults<Friends> realmResults;
    private FriendAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;

//



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myRealm = Realm.getDefaultInstance();
        getDataList();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragmentImport = new FragmentImport();
        fragmentGallery = new FragmentGallery();
        fragmentSend = new FragmentSend();
        fragmentShare =  new FragmentShare();
        fragmentSlideshow = new FragmentSlideshow();
        fragmentTools = new FragmentTools();
        mapsActivity =  new MapsActivity();

//
//
//
//



      //  AccessToken accessToken = AccessToken.getCurrentAccessToken();

                        // Insert your code here
                       // TextView view1 = (TextView) findViewById(R.id.fb);

                       // view1.setText("test"+ response.toString());


        /*

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Insert your code here
                       // Toast toast = Toast.makeText(getApplicationContext(),
                          //      response.toString(),Toast.LENGTH_SHORT);
                       // toast.show();
                        TextView view1 = (TextView) findViewById(R.id.fb);
                        view1.setText(response.toString());
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id");
        request.setParameters(parameters);
        request.executeAsync();
*/
               // Toast toast = Toast.makeText(getApplicationContext(),
                    //    response.getJSONObject().toString(), Toast.LENGTH_SHORT);
               // toast.show();






   /*     lstPlace = new ArrayList<>();
        lstPlace.add(new Place("Музеи", R.drawable.museum));
        lstPlace.add(new Place("Фонтаны", R.drawable.fontani));
        lstPlace.add(new Place("Соборы", R.drawable.sobor));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstPlace);
        myrv.setLayoutManager(new GridLayoutManager(this,3));

        myrv.setAdapter(myAdapter);


*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Toasty.info(MainActivity.this,
                        "Меню настройки",
                        Toast.LENGTH_LONG).show();
                break;

            case R.id.add_menu:
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();



        if (id == R.id.nav_camera) {

           fragmentTransaction.replace(R.id.conteiner, fragmentSlideshow);
        } else if (id == R.id.nav_gallery) {
            fragmentTransaction.replace(R.id.conteiner, fragmentSend);
        } else if (id == R.id.nav_slideshow) {
            fragmentTransaction.replace(R.id.conteiner, fragmentShare);
        } else if (id == R.id.nav_manage) {
            fragmentTransaction.replace(R.id.conteiner, fragmentTools);
        } else if (id == R.id.nav_share) {
            fragmentTransaction.replace(R.id.conteiner, fragmentSlideshow);
        } else if (id == R.id.nav_send) {
            fragmentTransaction.replace(R.id.conteiner, fragmentSend);

        }

        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (adapter != null)
//            adapter.notifyDataSetChanged();
//    }
//
    public void getDataList() {

        realmResults = myRealm.where(Friends.class).findAll();




        recyclerView = findViewById(R.id.my_recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new FriendAdapter(MainActivity.this, myRealm, realmResults);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myRealm.close();
    }
//


}
