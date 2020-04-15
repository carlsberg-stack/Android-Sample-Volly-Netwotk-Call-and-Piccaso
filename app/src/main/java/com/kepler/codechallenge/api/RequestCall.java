package com.kepler.codechallenge.api;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;

public abstract class RequestCall {

    public static final String BASE = "http://demo3196012.mockable.io";
    public static final String EP_DELIVERIES = "/deliveries";
    private RequestQueue mRequestQueue;

    public void jsonArrayRequest(String urlAppender, final VolleyCallback volleyCallback) {
        CustomJsonArrayRequest jsonObjectRequest = new CustomJsonArrayRequest(Request.Method.GET, BASE + urlAppender, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                volleyCallback.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.onError(error);

            }
        });

        getRequestQueue().add(jsonObjectRequest);

// Access the RequestQueue through your singleton class.
    }

    public void stringRequest(String urlAppender, final VolleyCallback volleyCallback) {
        CustomStringRequest customStringRequest = new CustomStringRequest(Request.Method.GET, BASE + urlAppender, null, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallback.onResponse(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallback.onError(error);

            }
        });

        getRequestQueue().add(customStringRequest);

// Access the RequestQueue through your singleton class.
    }


    protected RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = initRequestQueue();
        }
        return mRequestQueue;
    }

    protected abstract RequestQueue initRequestQueue();

    protected void cancelAllRequests() {
        getRequestQueue().cancelAll(null);
    }

    protected void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }

}