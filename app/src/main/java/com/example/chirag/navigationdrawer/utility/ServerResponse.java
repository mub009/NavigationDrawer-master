package com.example.chirag.navigationdrawer.utility;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.chirag.navigationdrawer.model.ShopListModel;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerResponse {



    ApiDataInterface ApiDataInterface;
    Context context;
    String URL;

    public ServerResponse(ApiDataInterface ApiDataInterface,Context context,String URL)
    {
        this.ApiDataInterface=ApiDataInterface;
        this.context=context;
        this.URL=URL;
    }

    public void read()
    {
        System.out.println("hey12333");


        JsonObjectRequest JsonObjectRequest = new JsonObjectRequest(Request.Method.GET, this.URL,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        ApiDataInterface.readDataInterface(response);



                        // Datareurn=response;

                            //ShopListModel obj= new ShopListModel(response.getString("ip"));
                            //shopList.add(obj);
                            // System.out.println("mubashir "+response.getString("ip"));
//                            mshopList.notifyDataSetChanged();
                          //  progressDialog.dismiss();



                        //  System.out.println("mubashir "+response);
//                        response.getJSONObject("ip");

                    }



                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("mubashir error "+error);


              //  progressDialog.dismiss();
            }
        });

        //Instantiate the RequestQueue and add the request to the queue
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(JsonObjectRequest);


    }


}




