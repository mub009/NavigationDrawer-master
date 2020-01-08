package com.example.chirag.navigationdrawer.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.example.chirag.navigationdrawer.utility.APIUrl;
import com.example.chirag.navigationdrawer.utility.ApiDataInterface;
import com.example.chirag.navigationdrawer.utility.ServerResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class mylocation extends Fragment implements ShopList.OnClickShoplistListener, ApiDataInterface {


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

        mshopList=new ShopList(shopList,this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        shoplistRecycylerView.setLayoutManager(mLayoutManager);

        //shoplistRecycylerView.setAnimation(new DefaultItemAnimator());

        shoplistRecycylerView.setAdapter(mshopList);


        ReadData();

        ServerResponse ServerResponse=new ServerResponse(this,getContext(), APIUrl.ipify);
        ServerResponse.read();
        ServerResponse.read();ServerResponse.read();
//        ServerResponse.readData(url,getContext());
//         System.out.println("mubashir "+response);
//


        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void ReadData() {


       // ServerResponse ServerResponseobj=new ServerResponse();

        String url = "https://api.ipify.org/?format=json";
        JSONObject response;
        //response=ServerResponseobj.readData(url,getContext());
       // System.out.println("mubashir "+response);

//
//        String url = "https://api.ipify.org/?format=json";
//        final ProgressDialog progressDialog = new ProgressDialog(getContext());
//        progressDialog.setMessage("Loading...");
//        progressDialog.show();
//        //Request a string response from the URL resource
//        JsonObjectRequest  JsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        try {
////                            response.getJSONObject("ip");
//
//                            ShopListModel  obj= new ShopListModel(response.getString("ip"));
//                            shopList.add(obj);
//                           // System.out.println("mubashir "+response.getString("ip"));
//                            mshopList.notifyDataSetChanged();
//                            progressDialog.dismiss();
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            progressDialog.dismiss();
//                        }
//
//                        //  System.out.println("mubashir "+response);
////                        response.getJSONObject("ip");
//
//                    }
//
//
//
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                System.out.println("mubashir error "+error);
//                progressDialog.dismiss();
//            }
//        });
//
//        //Instantiate the RequestQueue and add the request to the queue
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        queue.add(JsonObjectRequest);

    }


    @Override
    public void onClickShoplist(int position) {

       System.out.println("mubashir click"+position);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public JSONObject readDataInterface(JSONObject url) {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");


            try {
                            ShopListModel  obj= new ShopListModel(url.getString("ip"));
                            shopList.add(obj);
                           // System.out.println("mubashir "+response.getString("ip"));
                            mshopList.notifyDataSetChanged();
                            progressDialog.dismiss();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                        }


        return null;
    }
}
