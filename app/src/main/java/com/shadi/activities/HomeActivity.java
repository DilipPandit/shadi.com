package com.shadi.activities;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.android.volley.VolleyError;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.shadi.R;
import com.shadi.adapters.UserProfileAdapter;
import com.shadi.customViews.CustomActionBar;
import com.shadi.interfaces.NetworkRequest;
import com.shadi.interfaces.UserConnectListner;
import com.shadi.models.UserProfile;
import com.shadi.networking.NetworkService;
import com.shadi.utilities.EndPointAPI;

import java.util.ArrayList;


public class HomeActivity extends BaseActivity implements UserConnectListner, NetworkRequest {
    CustomActionBar customActionBar;
    RecyclerView rvCustomList;
    UserProfileAdapter userProfileAdapter;
    ArrayList<UserProfile> userProfileArrayList;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        _init();
    }

    private void _init() {
        customActionBar = findViewById(R.id.customActionBar);
        rvCustomList = findViewById(R.id.rvCustomList);
        if (userProfileArrayList == null)
            userProfileArrayList = new ArrayList<>();
        if (userProfileAdapter == null)
            userProfileAdapter = new UserProfileAdapter(this, userProfileArrayList, this);
        setAdapterView();
        getUserList();
    }

    private void getUserList() {
        if (isNetworkConnected())
            NetworkService.getInstance().NetworkObjectRequest(EndPointAPI.UserPrifleList, this, this);
        else
            showToast(getString(R.string.no_internet));

    }

    private void setAdapterView() {
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);
        rvCustomList.setLayoutManager(staggeredGridLayoutManager);
        rvCustomList.setAdapter(userProfileAdapter);
    }


    @Override
    public void OnSuccess(ArrayList<UserProfile> profileArrayList) {
        if (userProfileArrayList.size() > 0)
            userProfileArrayList.clear();
        userProfileArrayList.addAll(profileArrayList);
        userProfileAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnError(VolleyError volleyError) {
        showToast(getString(R.string.something_wrong));
    }

    @Override
    public void isConnect(boolean isConnect, final int position) {

        if (isConnect) {

        } else {
        }

    }

}
