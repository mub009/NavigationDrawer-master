package com.example.chirag.navigationdrawer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chirag.navigationdrawer.R;
import com.example.chirag.navigationdrawer.model.ShopListModel;

import java.util.List;

public class ShopList extends RecyclerView.Adapter<ShopList.MyViewHolder> {

    private List<ShopListModel> ShopList;

    public ShopList(List<ShopListModel> ShopList) {

        this.ShopList=ShopList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title;
        private ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.Shopimage);
            image=itemView.findViewById(R.id.Shopimage);
        }
    }


    @Override
    public ShopList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shoplist_row,parent,false);

        return new ShopList.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ShopListModel soplistModelObj=ShopList.get(position);

        holder.title.setText(soplistModelObj.getTitle());

        holder.image.setImageResource(soplistModelObj.getImage());



    }

    @Override
    public int getItemCount() {
        return ShopList.size();
    }
}
