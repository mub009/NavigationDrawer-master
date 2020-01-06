package com.example.chirag.navigationdrawer.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.navigationdrawer.R;
import com.example.chirag.navigationdrawer.adapter.ShopList;
import com.example.chirag.navigationdrawer.model.Movie;
import com.example.chirag.navigationdrawer.model.ShopListModel;

import java.util.ArrayList;
import java.util.List;

public class mylocation extends Fragment {


    private List<ShopListModel> shopList=new ArrayList<>();
    private ShopList mshopList;
    private RecyclerView shoplistRecycylerView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(
                R.layout.mylocation_fragment, container, false);

        shoplistRecycylerView=view.findViewById(R.id.recycler_shoplist);

        mshopList=new ShopListModel(shopList);

        prepareMovieData();

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
