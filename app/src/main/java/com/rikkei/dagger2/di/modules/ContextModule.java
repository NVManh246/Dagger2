package com.rikkei.dagger2.di.modules;

import android.content.Context;

import com.rikkei.dagger2.di.qualifer.ApplicationContext;
import com.rikkei.dagger2.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context mContext;

    public ContextModule(Context context) {
        mContext = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return mContext;
    }
}
