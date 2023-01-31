package com.android.study.retrofit_example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {
    @GET("posts/{userId}")  //BaseUrl 뒤 경로 지정
    Call<DataModel> testApiGet(@Path("userId")String userId);   //String userid의 값이 @Path("userId")이며 DataModel의 값

    @GET("posts/")
    Call<List<DataModel>> testApiGetAll();
}
