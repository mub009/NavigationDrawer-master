package com.example.chirag.navigationdrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chirag.navigationdrawer.adapter.AccounInfoAdpter;
import com.example.chirag.navigationdrawer.model.AccountInfo;


import java.util.ArrayList;
import java.util.List;

public class MyAccount extends AppCompatActivity {

    private List<AccountInfo> AccountInfoList=new ArrayList<>();
    private RecyclerView recyclerView;
    private AccounInfoAdpter AccounInfoAdpter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        recyclerView=findViewById(R.id.recycler_accountinfo);
        AccounInfoAdpter = new AccounInfoAdpter(AccountInfoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(AccounInfoAdpter);
        Accouninfo();
    }

    public void Accouninfo()
    {
        AccountInfo objaccountinfo=new AccountInfo("Name:","Mubashir");
        AccountInfoList.add(objaccountinfo);

        objaccountinfo=new AccountInfo("Address:","Palakkan");
        AccountInfoList.add(objaccountinfo);

    }
}
