package com.example.chirag.navigationdrawer.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chirag.navigationdrawer.R;
import com.example.chirag.navigationdrawer.adapter.AccounInfoAdpter;
import com.example.chirag.navigationdrawer.model.AccountInfo;

import java.util.ArrayList;
import java.util.List;

public class accountinfo extends Fragment {
    private List<AccountInfo> AccountInfoList=new ArrayList<>();
    private RecyclerView recyclerView;
    private  AccounInfoAdpter AccounInfoAdpter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view=inflater.inflate(
                R.layout.fragment_accountinfo, container, false);


        recyclerView=(RecyclerView) view.findViewById(R.id.recycler_accountinfo);

        AccounInfoAdpter = new AccounInfoAdpter(AccountInfoList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(AccounInfoAdpter);

        Accouninfo();

        return view;
    }
    public void Accouninfo()
    {
        AccountInfo objaccountinfo=new AccountInfo("Name:","Mubashir");
        AccountInfoList.add(objaccountinfo);

        objaccountinfo=new AccountInfo("Address:","Palakkan");
        AccountInfoList.add(objaccountinfo);

    }
}
