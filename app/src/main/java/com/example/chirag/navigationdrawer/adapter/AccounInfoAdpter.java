package com.example.chirag.navigationdrawer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chirag.navigationdrawer.R;
import com.example.chirag.navigationdrawer.model.AccountInfo;

import java.util.List;


public class AccounInfoAdpter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    public TextView matter,details;
    private List<AccountInfo> AccounData;


    public AccounInfoAdpter(List<AccountInfo> AccounData)
    {
       this.AccounData=AccounData;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {



        public MyViewHolder(View itemView) {
            super(itemView);

            matter =  (TextView) itemView.findViewById(R.id.accountmatter);
            details = (TextView) itemView.findViewById(R.id.accountDetails);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accountinfo_row,parent,false);

        return new AccounInfoAdpter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder MyViewHolder, int position) {

        AccountInfo obj = AccounData.get(position);

//        MyViewHolder.matter.setText(obj.getMatter());
//
//        MyViewHolder.matter
//
//        MyViewHolder.details.setText(obj.getDetails());


    }

    @Override
    public int getItemCount() {
        return AccounData.size();
    }
}