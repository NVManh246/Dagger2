package com.rikkei.dagger2.di.modules;

import android.content.Context;

import com.rikkei.dagger2.di.qualifer.ActivityContext;
import com.rikkei.dagger2.di.scopes.ActivityScope;
import com.rikkei.dagger2.screen.main.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mMainActivity;
    private Context mContext;

    public MainActivityContextModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
        mContext = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity provideMainActivity(){
        return mMainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return mContext;
    }
}
