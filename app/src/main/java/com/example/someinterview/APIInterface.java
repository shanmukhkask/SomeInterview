package com.example.someinterview;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {

   // /API/User_api/user_auth

    String BASEURL="https://mrcarto.tk/API/";
    @POST("User_api/user_auth")
    Call<OTPModal> sentOTP(@Body OTPModal otpModal);
}
