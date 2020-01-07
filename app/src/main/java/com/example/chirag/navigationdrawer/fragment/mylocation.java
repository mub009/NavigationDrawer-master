package com.example.chirag.navigationdrawer.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chirag.navigationdrawer.R;
import com.example.chirag.navigationdrawer.adapter.ShopList;
import com.example.chirag.navigationdrawer.model.Movie;
import com.example.chirag.navigationdrawer.model.ShopListModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class mylocation extends Fragment {


    private List<ShopListModel> shopList=new ArrayList<>();
    private ShopList mshopList;
    private RecyclerView shoplistRecycylerView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(
                R.layout.mylocation_fragment, container, false);

        shoplistRecycylerView=view.findViewById(R.id.recycler_shoplist);

        mshopList=new ShopList(shopList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        shoplistRecycylerView.setLayoutManager(mLayoutManager);

        //shoplistRecycylerView.setAnimation(new DefaultItemAnimator());

        shoplistRecycylerView.setAdapter(mshopList);


        prepareMovieData();




        String url = "https://api.ipify.org/?format=json";

        //Request a string response from the URL resource
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {


                        //JSONObject jsonArray = reader.getJSONObject(0).optJSONObject("scores")

                        response = response.getJSONObject("ip");

                       // JSONArray students = response.getJSONArray("students");
                        System.out.println("mubashir "+response);

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("mubashir error "+error);
            }
        });

        //Instantiate the RequestQueue and add the request to the queue
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(stringRequest);


        return view;
    }

    private void prepareMovieData() {
        ShopListModel  obj= new ShopListModel("Mad Max: Fury Road");
        shopList.add(obj);

        obj = new ShopListModel("Inside Out");
        shopList.add(obj);

        obj = new ShopListModel("Star Wars: Episode VII - The Force Awakens");
        shopList.add(obj);

        obj = new ShopListModel("Shaun the Sheep");
        shopList.add(obj);

        obj = new ShopListModel("The Martian");
        shopList.add(obj);

        mshopList.notifyDataSetChanged();
    }
}
