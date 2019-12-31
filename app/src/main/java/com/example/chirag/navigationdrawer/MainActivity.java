package com.example.chirag.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.chirag.navigationdrawer.adapter.MoviesAdapter;
import com.example.chirag.navigationdrawer.adapter.SiderAdapter;
import com.example.chirag.navigationdrawer.broadcast.ConnectvityCheck;
import com.example.chirag.navigationdrawer.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ConnectvityCheck.ConnectivityReceiverListener  {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    MyApplicationLauncher MyApplicationLauncher = new MyApplicationLauncher();
    private CoordinatorLayout coordinatorLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);



        checkConnection();

       // System.out.println("Good! Connected to Internet");
//
//        if(isNetworkAvailable(this))
//        {
//            Toast.makeText(MainActivity.this, "Net connection okay",Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this, "Net connection not okay",Toast.LENGTH_SHORT).show();
//        }


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        prepareMovieData();


//
//        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
//
//        SiderAdapter adapterView = new SiderAdapter(this);
//
//        mViewPager.setAdapter(adapterView);




        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.account:

                        Intent intent = new Intent(MainActivity.this, MyAccount.class);
                         startActivity(intent);
                        //Toast.makeText(MainActivity.this, "My Account",Toast.LENGTH_SHORT).show();

                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();
                     case R.id.mycart:
                        Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                    case R.id.test:
                        Toast.makeText(MainActivity.this, "test",Toast.LENGTH_SHORT).show();

                    default:
                        return true;
                }




            }
        });


    }

    /**
     * Callback will be triggered when there is change in
     * network connection
     */
    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

        Toast.makeText(MainActivity.this, "meee",Toast.LENGTH_SHORT).show();
        //showSnack(isConnected);
    }


    // Method to manually check connection status
    private void checkConnection() {
        boolean isConnected = ConnectvityCheck.isConnected();
        showSnack(isConnected);
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


    // Showing the status in Snackbar
    private void showSnack(boolean isConnected) { String message;

        if (isConnected) {
          message = "Good! Connected to Internet";
//            Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT).show();
//            System.out.println("Good! Connected to Internet");
//
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);

            snackbar.show();


        } else {
          message = "Sorry! Not connected to internet";
//            Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT).show();
//            System.out.println("Sorry! Not connected to internet mubashir");

            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.RED);

            snackbar.show();

        }


    }



    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    @Override
    protected void onResume() {
        super.onResume();

//
//        final IntentFilter intentFilter = new IntentFilter();
//
//        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
//
//        ConnectvityCheck ConnectvityCheck = new ConnectvityCheck();
//
//        registerReceiver(ConnectvityCheck, intentFilter);

       // System.out.println("Good! Connected to Internet");

//         register connection status listener

        MyApplicationLauncher.setConnectivityListener(new ConnectvityCheck.ConnectivityReceiverListener() {
            @Override
            public void onNetworkConnectionChanged(boolean isConnected) {
                showSnack(isConnected);
            }
        });

    }



}
