package com.shadi.interfaces;


import com.android.volley.VolleyError;
import com.shadi.models.UserProfile;

import java.util.ArrayList;

public interface NetworkRequest {
    public void OnSuccess(ArrayList<UserProfile> profileArrayList);

    public void OnError(VolleyError volleyError);
}
