package com.shadi.networking;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shadi.R;
import com.shadi.application.AppController;
import com.shadi.interfaces.NetworkRequest;
import com.shadi.models.UserProfile;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NetworkService {
    private static final Object lock = new Object();
    private static NetworkService mInstance;
    ProgressDialog progressDialog;

    private NetworkService() {

    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            synchronized (lock) {
                if (mInstance == null) {
                    mInstance = new NetworkService();
                }
            }
        }
        return mInstance;
    }

    public void NetworkObjectRequest(String url, Context context, final NetworkRequest networkRequest) {

        progressCall(context);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Gson gson = new Gson();
                TypeToken<List<UserProfile>> token = new TypeToken<List<UserProfile>>() {
                };
                ArrayList<UserProfile> userProfiles = null;
                try {
                    userProfiles = gson.fromJson(response.getJSONArray("results").toString(), token.getType());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                networkRequest.OnSuccess(userProfiles);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq, context.getResources().getString(R.string.app_name));
    }

    public void progressCall(Context context) {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = ProgressDialog.show(context, "Please Wait", "Loading...");

        progressDialog.setContentView(R.layout.progress_dialog);
        if (progressDialog.getWindow() != null)
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {

                try {
                    if (progressDialog != null) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
