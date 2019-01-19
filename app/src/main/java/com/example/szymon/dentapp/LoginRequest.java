package com.example.szymon.dentapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOG_URL = "http://localhost:8080/patient/byemail";
    private Map<String, String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener){
        super(Method.POST, LOG_URL, listener ,null);
        params = new HashMap<>();
        params.put("email" , email);
        params.put("password" , password);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
