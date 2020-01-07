package com.example.chirag.navigationdrawer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chirag.navigationdrawer.R;
import com.example.chirag.navigationdrawer.model.ShopListModel;

import java.util.List;

public class ShopList extends RecyclerView.Adapter<ShopList.MyViewHolder> {

    private List<ShopListModel> ShopList;
    private OnClickShoplistListener OnClickShoplistListener;

    public ShopList(List<ShopListModel> ShopList,OnClickShoplistListener OnClickShoplistListener) {

        this.ShopList=ShopList;
        this.OnClickShoplistListener=OnClickShoplistListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView title;
        private ImageView image;
        OnClickShoplistListener OnClickShoplistListener;

        public MyViewHolder(View itemView,OnClickShoplistListener OnClickShoplistListener) {
            super(itemView);
            title=itemView.findViewById(R.id.titleName);
            image=itemView.findViewById(R.id.Shopimage);
            this.OnClickShoplistListener=OnClickShoplistListener;
        }

        @Override
        public void onClick(View view) {

            OnClickShoplistListener.onClickShoplist(getAdapterPosition());
        }
    }


    @Override
    public ShopList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shoplist_row,parent,false);

        return new ShopList.MyViewHolder(view,OnClickShoplistListener);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ShopListModel soplistModelObj=ShopList.get(position);

        holder.title.setText(soplistModelObj.getTitle());

        holder.image.setImageResource(R.drawable.profile);


//        holder.image.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                System.out.println("sss");
//            }
//        });

        //holder.image.setImageURI(soplistModelObj.getImage());

    }

    @Override
    public int getItemCount() {
        return ShopList.size();
    }

    public interface OnClickShoplistListener{

            void onClickShoplist(int position);
    }
}
