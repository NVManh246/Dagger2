package com.rikkei.dagger2.di.modules;

import com.rikkei.dagger2.data.api.APIInterface;
import com.rikkei.dagger2.di.scopes.ApplicationScope;
import com.rikkei.dagger2.utils.StringUtils;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    @Provides
    @ApplicationScope
    APIInterface getAPIInterface(Retrofit retrofit) {
        return retrofit.create(APIInterface.class);
    }

    @Provides
    @ApplicationScope
    Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(StringUtils.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }
}
