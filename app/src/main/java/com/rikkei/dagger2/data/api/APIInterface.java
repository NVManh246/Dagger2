package com.rikkei.dagger2.data.api;

import com.rikkei.dagger2.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("users")
    Call<List<User>> getUser();
}
