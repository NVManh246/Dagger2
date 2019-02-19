package com.rikkei.dagger2.di.modules;

import com.rikkei.dagger2.di.scopes.ActivityScope;
import com.rikkei.dagger2.screen.main.MainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {
    private MainContract.View mView;

    public MainActivityMvpModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    @ActivityScope
    public MainContract.View provideView() {
        return mView;
    }
}
