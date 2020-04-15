package com.dotinfiny.attendanceapp.ApiClient;

import com.dotinfiny.attendanceapp.ApiResponseModel.Login;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Apis {

    @FormUrlEncoded
    @POST("app_api.php")
    Call<Login> userLogin(
            @Field("api") String api,
            @Field("email") String email,
            @Field("uuId") String uuId,
            @Field("name") String name
    );
    @POST("app_api.php")
    Call<JsonElement> userLogout(
            @Field("api") String api,
            @Field("userId") String userId
    );

}
