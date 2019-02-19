package com.rikkei.dagger2;

import android.app.Activity;
import android.app.Application;

import com.rikkei.dagger2.di.component.ApplicationComponent;
import com.rikkei.dagger2.di.component.DaggerApplicationComponent;
import com.rikkei.dagger2.di.modules.ContextModule;

public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        mApplicationComponent.injectApplication(this);
    }

    public static MyApplication getInstance(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
